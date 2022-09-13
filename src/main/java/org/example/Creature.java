package org.example;

import org.example.GameGenerator;

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

    ArrayList<Weapon> lootInventory;

    ArrayList<Item> itemInventory;

    // CONSTRUCTOR
    public Creature(String name, int hP, int attackPoints){
        this.name = name;
        this.hP = hP;
        this.attackPoints= attackPoints;
        weaponInventory = new ArrayList<>();
        itemInventory = new ArrayList<>();
        lootInventory = new ArrayList<>();
        isDead = false;
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
            }
            if(defender.hP < 1){
                defender.isDead = true;
                System.out.println(defender.name + " died.");
                pickUpWeapon(attacker,defender);
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

    public static void pickUpWeapon(Creature player, Creature nPC){
        if(!nPC.lootInventory.isEmpty()) {
            Weapon weapon = nPC.lootInventory.get(0);
            player.weaponInventory.add(weapon);
            System.out.println(player.name + " picked up " + weapon.name + " " + weapon.extraAttackPoints + " DMG.");
        }
        else{
            System.out.println("There is no weapon to loot.");
        }
    }

    public void fillNPCInventory(){
        Weapon sword = new Weapon("Sword ", 10);
        Weapon mace = new Weapon("Mace", 20);
        Weapon drakobijec = new Weapon("Drakobijec", 150);

        if(this.name == "Skeleton"){
            this.lootInventory.add(sword);
        }
        if(this.name == "Witch"){
            this.lootInventory.add(mace);
        }
        if(this.name == "Spider"){
            this.lootInventory.add(drakobijec);
        }
    }


}
