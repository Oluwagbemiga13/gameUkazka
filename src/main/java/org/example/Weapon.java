package org.example;

import java.io.Serializable;

import static java.lang.Math.round;
import static org.example.Main.dice;

public class Weapon extends Item implements Serializable {

    String name;
    int extraAttackPoints;
    String nameOfWeapon;

    /***
     *
     *
     */
    int codeOfweapon;


    /***
     * randomly generate selected weapon.
     * int type =  [0] 3-6DMG/[1] 6-12DMG / [2] 10-14DMG / [3] 14 - 24DMG
     * @param type  sword/mace
     *
     */
    public Weapon(String type) {

        super(type);
        this.type = "weapon";
        if (type.equals("sword")) {

            int random = (int) round(dice.nextDouble() * 13);
            this.extraAttackPoints = random;

            if (extraAttackPoints <= 6) {
                if (extraAttackPoints < 3) {
                    this.extraAttackPoints = 3;
                }
                this.nameOfWeapon = "Rusty blade";
                this.codeOfweapon = 0;
            } else {
                this.nameOfWeapon = "Reliable blade";
                this.codeOfweapon = 1;
            }
        }
        if (type.equals("mace")) {
            int random = (int) round(dice.nextDouble() * 25);
            this.extraAttackPoints = random;

            if (extraAttackPoints <= 14) {
                if (extraAttackPoints < 10) {
                    this.extraAttackPoints = 10;
                }
                this.nameOfWeapon = "Spiked club";
                this.codeOfweapon = 2;
            } else {
                this.nameOfWeapon = "Captain's mace";
                this.codeOfweapon = 3;
            }
        }
    }
}
