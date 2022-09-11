package org.example;

import org.example.GameGenerator;

import java.util.ArrayList;

import static java.lang.Math.round;
import static java.text.ChoiceFormat.nextDouble;
import static org.example.GameGenerator.creatureArrayList;
import static org.example.Main.dice;

public class Creature implements Cloneable {
    String name;
    int hP;
    int attackPoints;
    boolean isDead;
    int positionArrayList;

    public static String nameOfPlayer = "Daniel";

    public static int counterOfNPCCreated = 0;
    ArrayList<Weapon> weaponInventory;

    ArrayList<Weapon> lootInventory;

    // CONSTRUCTOR
    public Creature(String name, int hP, int attackPoints){
        this.name = name;
        this.hP = hP;
        this.attackPoints= attackPoints;
        weaponInventory = new ArrayList<>();
        lootInventory = new ArrayList<>();
        isDead = false;
        positionArrayList = counterOfNPCCreated;
        counterOfNPCCreated++;

        this.fillNPCInventory();

        creatureArrayList.add(this);

        System.out.println("\n" + this.name + " was created" + " " + this.attackPoints + "/" + this.hP);
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

    public void die(){
        this.isDead = true;
    }

    public static void fight(Creature attacker, Creature defender){

        if (attacker.isDead || defender.isDead){
            System.out.println("Unable to fight. - Someone is dead");
        }
        else{
            if(!attacker.weaponInventory.isEmpty()){
                defender.hP = defender.hP - attacker.attackPoints + getBestWeapon(attacker).extraAttackPoints;
                if(defender.hP < 1){
                    defender.isDead = true;
                }
            }
            else{
                defender.hP = defender.hP - attacker.attackPoints;
            }
            if(defender.isDead){
                System.out.println(defender.name + " died.");
                defender.isDead = true;
            }
            else {
                counterAtack(attacker,defender);
            }
            attacker.printStats();
            defender.printStats();
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

    public void pickUpWeapon(Weapon weapon){
        this.weaponInventory.add(weapon);
        System.out.println(this.name + " picked up " + weapon.name + " " + weapon.extraAttackPoints + " DMG.");
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
