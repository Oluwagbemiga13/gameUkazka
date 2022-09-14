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
    public static Weapon getBestWeapon(Creature c){
        Weapon tempW = null;
        if (!c.weaponInventory.isEmpty()) {
            for (Weapon w : c.weaponInventory) {
                if (tempW != null){
                    if (w.extraAttackPoints > tempW.extraAttackPoints) {
                        tempW = w;
                    }
                }
                else{
                    tempW = w;
                }
            }
        }
        return tempW;
    }


    public static void fight(Creature attacker, Creature defender){

        if (attacker.isDead || defender.isDead){
            System.out.println("Unable to fight. - Someone is dead");
        }
        else{
            if(!attacker.weaponInventory.isEmpty()){
                Weapon bestWeapon = getBestWeapon(attacker);
                int attackPointsTotal = attacker.attackPoints + bestWeapon.extraAttackPoints;
                defender.hP = defender.hP - attackPointsTotal;
                System.out.println(attacker.name + " attacked " + defender.name + " with " + bestWeapon.name
                        + " and dealt " +  attackPointsTotal + " DMG.");
            }
            else{
                defender.hP = defender.hP - attacker.attackPoints;
                System.out.println(attacker.name + " attacked " + defender.name
                        + " and dealt " +  attacker.attackPoints + " DMG.");
            }
            if(defender.hP < 1){
                defender.isDead = true;
                System.out.println(defender.name + " died.");
                pickUpItem(attacker,defender);
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

    public static void pickUpItem(Creature player, Creature nPC){
        if(!nPC.lootInventory.isEmpty()) {
            Item item = nPC.lootInventory.get(0);
            player.weaponInventory.add((Weapon) item);
            System.out.println(player.name + " picked up " + item.name + " " + ((Weapon) item).extraAttackPoints + " DMG.");
        }
        else{
            System.out.println("There is no weapon to loot.");
        }
    }

    public void fillNPCInventory(){
        Item sword = new Weapon("sword");
        Item mace = new Weapon("mace");

        if(this.name == "Skeleton"){
            this.lootInventory.add(sword);
            }
        if(this.name == "Witch"){
            this.lootInventory.add(mace);
            }
        }
    }

