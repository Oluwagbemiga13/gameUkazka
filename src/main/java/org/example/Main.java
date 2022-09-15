package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import static org.example.Creature.fight;
import static org.example.GameGenerator.*;
import static org.example.SerTool.loadCreatureArrayList;
import static org.example.SerTool.saveEverything;

public class Main {

    public static Random dice;


    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {

        Random randomizer = new Random();
        dice = randomizer;

        GameGenerator level1 = new GameGenerator("Level 1");


        //createNPCs(1);
        currentPlayer = createPlayer("Daniel");

        saveEverything();
        ArrayList<Creature> testCreature = loadCreatureArrayList("CreatureArrayList.ser");

        setPlayer();
        System.out.println("Current player: " + currentPlayer.name);

        Lore testLore = new Lore("TEST");

        //Test game
        testLore.goThroughLore(currentPlayer);

        /*
        System.out.println("Pres any key and enter to exit program.");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        in.readLine();
         */
    }

}