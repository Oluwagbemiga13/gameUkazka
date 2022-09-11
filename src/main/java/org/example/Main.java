package org.example;

import org.example.creatures.NPC;

import java.util.Random;

import static org.example.Creature.fight;

public class Main {

    public static Random dice;

    public static void main(String[] args) {

        Random randomizer = new Random();
        dice = randomizer;

        System.out.println("Hello world!");

        Creature player = new Player("Daniel", 100, 5);
        Creature witch = new NPC("Witch", 25, 5);
        Creature skeleton = new NPC("Skeleton", 10, 5);
        Creature spider = new NPC("Spider", 50, 5);
        Creature dragon = new NPC("Dragon", 100, 50);

        Weapon sword = new Weapon("Sword ", 10);
        Weapon mace = new Weapon("Mace", 20);
        Weapon drakobijec = new Weapon("Drakobijec", 150);

        System.out.println(skeleton.lootInventory.get(0).name);



        //player.pickUpWeapon(sword);

        player.printStats();


        for(int i = 0; i < 10; i++) {
            fight(player,witch);
        }

    }
}