package org.example.tools;

import org.example.Creature;
import org.example.Item;
import org.example.NPC;
import org.example.Player;

import java.util.ArrayList;

import static org.example.Creature.nameOfPlayer;

public class GameGenerator {

    public static Creature currentPlayer = null;
    public static ArrayList<Creature> creatureArrayList;
    public static ArrayList<Item> itemArrayList;


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
        return new NPC("Spider", 50, 10);
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
        createPlayer(nameOfPlayer);
        switch (difficulty){
            case 1:
                for(int i =0; i <5; i++) {
                    createWitch();
                }
                for(int i =0; i <5; i++) {
                    createSkeleton();
                }
                createSpider();
                createDragon();
                printOutNPCs();
                break;
            default:
                System.out.println("Wrong input!");
        }
    }

    public static Creature getAlivePlayer(ArrayList <Creature> arrayList){
        Creature player = null;
        for (Creature creature : arrayList){
            if (creature.getClass().toString().equals("class org.example.Player")){
                if (!creature.isDead)
                    player = creature;
                break;
            }
        }
        return player;
    }

    public GameGenerator (String name){
        creatureArrayList = new ArrayList<>();
        itemArrayList = new ArrayList<>();
    }
}
