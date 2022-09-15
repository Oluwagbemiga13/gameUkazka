package org.example;

import javax.swing.plaf.basic.BasicDesktopIconUI;
import java.io.Serializable;

import static java.lang.Math.round;
import static org.example.Potion.Strenght.*;

public class Potion extends Item implements Serializable {


    enum Strenght{
        GOOD,
        BETTER,
        BEST,
        BAD,
        WORSE,
        WORST,
    }

    enum Type{
        HEAL,
        DMG,

    }

    public Potion(Type type, Strenght strenght ){
        super(type.toString()+ "_" + strenght.toString());

        if(type.equals(Type.HEAL)) {
                switch (strenght) {
                    case GOOD:
                        this.name = "Jack Daniels no.7";
                        this.healingPoints = 10;
                        break;
                    case BETTER:
                        this.name = "Diplomatico R.E.";
                        this.healingPoints = 20;
                        break;
                    case BEST:
                        this.name = "Clement 10Y";
                        this.healingPoints = 30;
                        break;
                }

        }
        if(type.equals(Type.DMG)) {
            switch (strenght) {
                case BAD:
                    name = "Zelená";
                    damagePoints = 5;
                    break;
                case WORSE:
                    name = "Božkov";
                    damagePoints = 10;
                    break;
                case WORST:
                    this.name = "Alpský ryzlink";
                    damagePoints = 15;
                    break;

            }
        }
    }
}
