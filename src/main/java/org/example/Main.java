package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import static org.example.Creature.fight;
import static org.example.GameGenerator.*;

public class Main {

    public static Random dice;

    public static void main(String[] args) throws InterruptedException, IOException {

        Random randomizer = new Random();
        dice = randomizer;

        GameGenerator level1 = new GameGenerator("Level 1");

        System.out.println("Hello world!");

        createNPCs(1);

        Weapon sword = new Weapon("Sword ", 10);
        Weapon mace = new Weapon("Mace", 20);
        Weapon drakobijec = new Weapon("Drakobijec", 150);

        //System.out.println(skeleton.lootInventory.get(0).name);

        fillNPCsLootInventory(creatureArrayList);

        for (Creature creature : creatureArrayList) {
            if (!creature.lootInventory.isEmpty()) {
                Weapon weapon = creature.lootInventory.get(0);
                System.out.println(weapon.name + " + " + weapon.extraAttackPoints + " was added to " + creature.name + ".lootInventory");
            }
        }

        while (!creatureArrayList.get(1).isDead) {
            fight(creatureArrayList.get(0), creatureArrayList.get(1));
        }

        while (!creatureArrayList.get(2).isDead && !creatureArrayList.get(0).isDead) {
            fight(creatureArrayList.get(0), creatureArrayList.get(2));
        }

        while (!creatureArrayList.get(3).isDead && !creatureArrayList.get(0).isDead) {
            fight(creatureArrayList.get(0), creatureArrayList.get(3));
        }
        while (!creatureArrayList.get(4).isDead && !creatureArrayList.get(0).isDead) {
            fight(creatureArrayList.get(0), creatureArrayList.get(4));
        }

        System.out.println("Pres any key and enter to exit program.");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        in.readLine();
    }

}