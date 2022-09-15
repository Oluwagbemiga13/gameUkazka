package org.example;

import java.io.Serializable;

import static java.lang.Math.round;
import static org.example.Main.dice;

public class Potion extends Item implements Serializable {

    int healingPoints;
    String name;

    public Potion(String name, int strenght){
        super(name);
        this.name = name;
        if(strenght == 10){
            this.name = "Flask of whiskey";
            healingPoints = strenght;
        }
        if(strenght == 20){
            this.name = "Heal potion";
            healingPoints = strenght;
        }
    }
}
