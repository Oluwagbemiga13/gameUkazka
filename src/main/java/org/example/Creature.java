package org.example;

import java.io.Serializable;
import java.util.ArrayList;

import static java.lang.Math.round;
import static java.text.ChoiceFormat.nextDouble;
import static org.example.tools.GameGenerator.creatureArrayList;
import static org.example.Main.dice;

public class Creature  implements Serializable {

    public String name;
    public int hP;
    public int attackPoints;
    public boolean isDead;
    public int positionArrayList;
    public Weapon equipedWeapon = null;
    public static String nameOfPlayer = "Daniel";
    public static int counterOfNPCCreated = 0;
    public ArrayList<Weapon> weaponInventory;
    ArrayList<Item> lootInventory;
    ArrayList<Item> itemInventory;

    boolean isSetInLore;

    // CONSTRUCTOR AUTO
    public Creature(String name, int hP, int attackPoints){
        this.name = name;
        this.hP = hP;
        this.attackPoints= attackPoints;
        weaponInventory = new ArrayList<>();
        itemInventory = new ArrayList<>();
        lootInventory = new ArrayList<>();
        isDead = false;
        isSetInLore = false;
        positionArrayList = counterOfNPCCreated;
        counterOfNPCCreated++;

        creatureArrayList.add(this);

        System.out.println("\n" + this.name + " was created" + " " + this.attackPoints + "/" + this.hP);
    }

    // CONSTRUCTOR CREATIVE
    public Creature(String name, int hP, int attackPoints, Weapon weapon){
        this.name = name;
        this.hP = hP;
        this.attackPoints = attackPoints;
        this.weaponInventory.add(weapon);
        this.itemInventory.add(weapon);
    }


    public void die(){
        int indexToDelete = this.positionArrayList;
        creatureArrayList.set(indexToDelete, null);
    }

    /***
     *
     * @return best weapon form inventory
     */
    public void equipBestWeapon(){

        if (!this.weaponInventory.isEmpty()) {
            if(this.equipedWeapon == null){
                this.equipedWeapon = this.weaponInventory.get(0);
            }
            for (Weapon weapon : this.weaponInventory) {
                if (weapon.extraAttackPoints > this.equipedWeapon.extraAttackPoints) {
                    this.equipedWeapon = weapon;
                }
            }
        }
    }


    public static String fight(Creature attacker, Creature defender){
        String message = "";

        if (attacker.isDead || defender.isDead){
            message = "Unable to fight. - Someone is dead";
        }
        else{
            if(attacker.equipedWeapon != null){
                int attackPointsTotal = attacker.attackPoints + attacker.equipedWeapon.extraAttackPoints;
                defender.hP = defender.hP - attackPointsTotal;
                message = "\n" + attacker.name + " attacked " + defender.name + " with " + attacker.equipedWeapon.nameOfWeapon
                        + " and dealt " +  attackPointsTotal + " DMG.";
            }
            else{
                defender.hP = defender.hP - attacker.attackPoints;
                message = attacker.name + " attacked " + defender.name
                        + " with bare hands and dealt " +  attacker.attackPoints + " DMG.";
            }
            if(defender.hP < 1){
                defender.isDead = true;
                message = message.concat("\n"+ defender.name + " died.");
                defender.die();
            }
            else {
                message = message.concat(counterAtack(attacker,defender));
//                attacker.printStats();
//                defender.printStats();
            }
        }
        return message;
    }


    public void printStats(){
        System.out.println(this.name + " " + this.attackPoints + "/" + this.hP);
    }

    public static String counterAtack(Creature getDamage, Creature dealDamage){
        String message = "";
        if(!dealDamage.isDead) {
            int counterAtack = (int) round(dice.nextDouble() * dealDamage.attackPoints);
            getDamage.hP = getDamage.hP - counterAtack;
            if(getDamage.hP <1) {
                getDamage.isDead = true;
            }
            message = "\n" + dealDamage.name + " counter atacked and dealt " + counterAtack + " damage";
        }
        return message;
    }

    public static String pickUpItems(Creature player, Creature nPC){
        String message = "";
        if(!nPC.lootInventory.isEmpty()) {
            for(Item item : nPC.lootInventory) {
                if (item.getClass().toString().equals("class org.example.Weapon")) {
                    player.weaponInventory.add((Weapon) item);
                    message = message.concat( "\n"+ player.name + " picked up " + ((Weapon) item).nameOfWeapon + " +" + ((Weapon) item).extraAttackPoints + " DMG.");
                }
                else {
                    player.itemInventory.add(item);
                    message = message.concat("\n" + player.name + " picked up " + item.name + " +" + item.healingPoints + " healing points.");
                }
            }
        }
        else{
            message = "There was nothing to loot.";
        }
        player.equipBestWeapon();
        return message;
    }

    public void heal(){

        if(!itemInventory.isEmpty()) {
            for(Item item : this.itemInventory){
                if(item.healingPoints>0){
                    this.hP += item.healingPoints;
                    System.out.println(this.name + " drank " + item.name + " and got healed by " + item.healingPoints);
                    this.itemInventory.remove(item);
                    break;
                }
            }
        }
    }

    public void fillNPCInventory(){
        Item sword = new Weapon("sword");
        Item mace = new Weapon("mace");
        Item healingPotion1 = new Potion(Potion.Type.HEAL, Potion.Strenght.GOOD);
        Item healingPotion2 = new Potion(Potion.Type.HEAL, Potion.Strenght.BETTER);

        if(this.name == "Skeleton"){
            this.lootInventory.add(sword);
            this.lootInventory.add(healingPotion1);

            }
        if(this.name == "Witch"){
            this.lootInventory.add(mace);
            this.lootInventory.add(healingPotion2);
            }
        }
    }


