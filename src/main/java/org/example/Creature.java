package org.example;

import java.io.Serializable;
import java.util.ArrayList;

import static java.lang.Math.round;
import static java.text.ChoiceFormat.nextDouble;
import static org.example.GameGenerator.creatureArrayList;
import static org.example.Main.dice;

public class Creature  implements Serializable {

    String name;
    int hP;
    int attackPoints;
    boolean isDead;
    int positionArrayList;

    Weapon equipedWeapon = null;

    public static String nameOfPlayer = "Daniel";

    public static int counterOfNPCCreated = 0;
    ArrayList<Weapon> weaponInventory;

    ArrayList<Item> lootInventory;

    ArrayList<Item> itemInventory;

    boolean isSetInLore;

    // CONSTRUCTOR
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


        this.fillNPCInventory();

        creatureArrayList.add(this);

        System.out.println("\n" + this.name + " was created" + " " + this.attackPoints + "/" + this.hP);
    }

    public void die(){
        int indexToDelete = this.positionArrayList;
        creatureArrayList.remove(indexToDelete);
        System.out.println(this.name + " died.");
    }

    /***
     *
     * @return best weapon form invenotry
     */
    public void getBestWeapon(){
        Weapon tempW = null;

        if (!this.weaponInventory.isEmpty()) {
            if(this.equipedWeapon == null){
                this.equipedWeapon = this.weaponInventory.get(0);
            }
            for (Weapon w : this.weaponInventory) {
                if (w.extraAttackPoints > this.equipedWeapon.extraAttackPoints) {
                    tempW = w;
                }
                else{
                    tempW = w;
                }
                this.equipedWeapon = tempW;
            }
        }
    }


    public static void fight(Creature attacker, Creature defender){

        if (attacker.isDead || defender.isDead){
            System.out.println("Unable to fight. - Someone is dead");
        }
        else{
            if(attacker.equipedWeapon != null){
                int attackPointsTotal = attacker.attackPoints + attacker.equipedWeapon.extraAttackPoints;
                defender.hP = defender.hP - attackPointsTotal;
                System.out.println("\n" + attacker.name + " attacked " + defender.name + " with " + attacker.equipedWeapon.nameOfWeapon
                        + " and dealt " +  attackPointsTotal + " DMG.");
            }
            else{
                defender.hP = defender.hP - attacker.attackPoints;
                System.out.println(attacker.name + " attacked " + defender.name
                        + " with bare hands and dealt " +  attacker.attackPoints + " DMG.");
            }
            if(defender.hP < 1){
                defender.isDead = true;
                System.out.println(defender.name + " died.");
                pickUpItems(attacker,defender);
            }
            else {
                counterAtack(attacker,defender);
                attacker.printStats();
                defender.printStats();
            }

        }
    }


    public void printStats(){
        System.out.println(this.name + " " + this.attackPoints + "/" + this.hP);
    }

    public static void counterAtack(Creature getDamage, Creature dealDamage){
        if(!dealDamage.isDead) {
            int counterAtack = (int) round(dice.nextDouble() * dealDamage.attackPoints);
            getDamage.hP = getDamage.hP - counterAtack;
            if(getDamage.hP <1) {
                getDamage.isDead = true;
            }
            System.out.println("\n" + dealDamage.name + " counter atacked and dealt " + counterAtack + " damage");
        }
    }

    public static void pickUpItems(Creature player, Creature nPC){
        if(!nPC.lootInventory.isEmpty()) {
            for(Item item : nPC.lootInventory) {
                if (item.getClass().toString().equals("class org.example.Weapon")) {
                    player.weaponInventory.add((Weapon) item);
                    //System.out.println(item.getClass().toString());
                    System.out.println(player.name + " picked up " + ((Weapon) item).nameOfWeapon + " " + ((Weapon) item).extraAttackPoints + " DMG.");
                }
                else {
                    player.itemInventory.add((Item) item);
                    //System.out.println(item.getClass().toString());
                    System.out.println(player.name + " picked up " + ((Potion) item).name + " " + ((Potion) item).healingPoints + " healing points.");
                }
            }
        }
        else{
            System.out.println("There is no weapon to loot.");
        }
        player.getBestWeapon();
    }

    public void fillNPCInventory(){
        Item sword = new Weapon("sword");
        Item mace = new Weapon("mace");
        Item healingPotion1 = new Potion("Healing Potion", 10);
        Item healingPotion2 = new Potion("Healing Potion", 20);

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

