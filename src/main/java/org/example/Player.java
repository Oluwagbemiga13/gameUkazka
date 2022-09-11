package org.example;

public class Player extends Creature {


    public static void killPlayer( Creature player){
        System.out.println("\n" + player.name + " died.");
        System.out.println("GAME OVER");
    }

    public Player(String name, int hP, int attackPoints){
        super(name,hP,attackPoints);

    }
}
