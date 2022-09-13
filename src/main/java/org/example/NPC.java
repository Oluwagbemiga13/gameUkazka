package org.example;

import org.example.Creature;

import java.io.Serializable;

public class NPC extends Creature implements Serializable {

    public NPC(String name, int hP, int attackPoints){
        super(name,hP,attackPoints);

    }
}
