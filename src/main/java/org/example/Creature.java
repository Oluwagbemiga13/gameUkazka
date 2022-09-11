package org.example;

import java.util.ArrayList;

import static java.lang.Math.round;
import static java.text.ChoiceFormat.nextDouble;
import static org.example.Main.dice;

public class Creature {
    String name;
    int hP;
    int attackPoints;
    boolean isDead;
    ArrayList<Weapon> weaponInventory;

    ArrayList<Weapon> lootInventory;

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

    /***
     *
     * @param oponent = oponent
     */
    public void attack(Creature oponent){
        if (!oponent.isDead && !this.isDead) {
            int weaponAttackPoints = 0;
            int totalAttackPoints = this.attackPoints;
            // if there is weapon
            if (!this.weaponInventory.isEmpty()) {
                weaponAttackPoints = this.attackPoints + getBestWeapon(this).extraAttackPoints;
                totalAttackPoints = this.attackPoints + weaponAttackPoints;
            }
            oponent.hP = oponent.hP - totalAttackPoints;
            if (oponent.hP <= 0) {
                oponent.isDead = true;
            }
            System.out.println("\n" + this.name + " attacked " + oponent.name + " and dealt " + totalAttackPoints + " damage.");

            counterAtack(this, oponent);
        }

        if(this.isDead){
            Player.killPlayer(this);
        }
        oponent.printStats();
    }

    public void fight(Creature c){
        while(!this.isDead && !this.isDead) {
            this.attack(c);
        }
        // If creature dies
        if (c.isDead){
            System.out.println(c.name + " died.");
            for (Weapon w: c.lootInventory){
                this.pickUpWeapon(w);
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
    public Creature(String name, int hP, int attackPoints){
        this.name = name;
        this.hP = hP;
        this.attackPoints= attackPoints;
        weaponInventory = new ArrayList<>();
        lootInventory = new ArrayList<>();
        isDead = false;

        fillNPCInventory();

        System.out.println("\n" + this.name + " was created" + " " + this.attackPoints + "/" + this.hP);
    }
}
