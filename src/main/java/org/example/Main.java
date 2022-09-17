package org.example;

import org.example.tools.GUIHandler;
import org.example.tools.GameGenerator;
import org.example.tools.Input;
import org.example.tools.SerTool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static org.example.tools.GameGenerator.*;
import static org.example.tools.SerTool.*;


public class Main {

    public static Random dice;
    public static Input input;
    public static GUIHandler guiHandler;
    public static Lore currentLore;
    public static Event currentEvent;


    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {

        Random randomizer = new Random();
        dice = randomizer;
        guiHandler = new GUIHandler();

      input = new Input();
      
      guiHandler.createFirstFrame();

      for(String s : guiHandler.getFilesNames()){
          System.out.println(s);
      }


        GameGenerator gameGenerator = new GameGenerator("Level 1");

        //currentPlayer = createPlayer(input.returnString());

        currentPlayer = createPlayer("Dan");


        saveEverything();
        //ArrayList<Creature> testCreature = loadCreatureArrayList("CreatureArrayList.ser");

        System.out.println("Current player: " + currentPlayer.name);

        Lore testLore = new Lore(Lore.Difficulty.MODERATE);

        saveLore(testLore);

        //SerTool.saveLore(testLore);
        //Lore testLoreLoad = SerTool.loadLore("MODERATE_LORE.ser");

//        for(Event event : testLoreLoad.eventArrayList){
//            //event.consumeEvent();
//            currentPlayer.printStats();
//            if(currentPlayer.hP < 60){
//                currentPlayer.heal();
//            }
//        }


        //Test game
//        for(Event event : testLore.eventArrayList){
//            event.consumeEvent();
//            currentPlayer.printStats();
//            if(currentPlayer.hP < 60){
//                currentPlayer.heal();
//            }
//        }



//        currentPlayer.itemInventory.add(new Potion(Potion.Type.HEAL, Potion.Strenght.BEST));
//        System.out.println(currentPlayer.itemInventory.get(0).name);
//        currentPlayer.heal();
//        currentPlayer.printStats();


        /*
        System.out.println("Pres any key and enter to exit program.");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        in.readLine();
         */
    }

}