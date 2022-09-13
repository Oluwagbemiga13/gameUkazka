package org.example;

import java.io.Serializable;

public class Player extends Creature implements Serializable {


    public static void killPlayer( Creature player){
        System.out.println("\n" + player.name + " died.");
        System.out.println("GAME OVER");
    }

    public Player(String name, int hP, int attackPoints){
        super(name,hP,attackPoints);

    }
}
