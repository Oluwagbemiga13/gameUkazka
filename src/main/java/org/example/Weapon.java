package org.example;

import java.io.Serializable;

public class Weapon implements Serializable {

    String name;
    int extraAttackPoints;

    public Weapon(String name, int extraAttackPoints){
        this.name = name;
        this.extraAttackPoints = extraAttackPoints;
    }
}
