package org.example;

import org.example.creatures.NPC;

import java.util.ArrayList;

import static org.example.Creature.nameOfPlayer;

public class GameGenerator {

    public static Creature createPlayer(String name){
        return new Player(name, 100, 5);
    }

    public static Creature createWitch(){
        return new NPC("Witch", 25, 5);
    }

    public static Creature createSkeleton(){
        return new NPC("Skeleton", 10, 5);
    }

    public static Creature createSpider(){
        return new NPC("Spider", 50, 5);
    }

    public static Creature createDragon(){
        return new NPC("Dragon", 100, 50);
    }

    public static void printOutNPCs(){
        for (Creature c: creatureArrayList) {
            c.printStats();
        }
    }



    public static void createNPCs(int difficulty){

        switch (difficulty){
            case 1:
                createPlayer(nameOfPlayer);
                createWitch();
                createSkeleton();
                createSpider();
                createDragon();
                printOutNPCs();
                break;
            default:
                System.out.println("Wrong input!");
        }
    }

    public static ArrayList<Creature> creatureArrayList;

    public void fillGameWithCreatures(ArrayList<Creature> createdCreatures){
    }

    public GameGenerator (String name){
        creatureArrayList = new ArrayList<>();
    }

    public static void fillNPCsLootInventory(ArrayList<Creature> inputCreatureArrayList){
        for(Creature creature : inputCreatureArrayList){
            creature.fillNPCInventory();
        }
    }
}
