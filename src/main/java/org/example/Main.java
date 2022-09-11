package org.example;

import org.example.creatures.NPC;

import java.util.Random;

import static org.example.Creature.fight;
import static org.example.GameGenerator.createNPCs;
import static org.example.GameGenerator.creatureArrayList;

public class Main {

    public static Random dice;

    public static void main(String[] args) {

        Random randomizer = new Random();
        dice = randomizer;

        GameGenerator level1 = new GameGenerator("Level 1");

        System.out.println("Hello world!");

        createNPCs(1);

        Weapon sword = new Weapon("Sword ", 10);
        Weapon mace = new Weapon("Mace", 20);
        Weapon drakobijec = new Weapon("Drakobijec", 150);

        //System.out.println(skeleton.lootInventory.get(0).name);



        for(int i = 0; i < 10; i++) {
            fight(creatureArrayList.get(0),creatureArrayList.get(1));
        }

    }
}