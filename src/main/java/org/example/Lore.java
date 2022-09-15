package org.example;

import java.io.Serializable;
import java.util.ArrayList;

import static java.lang.Math.round;
import static org.example.Creature.fight;
import static org.example.GameGenerator.creatureArrayList;
import static org.example.Main.dice;


public class Lore implements Serializable {
    Enum difficulty;

    int id;
    static int counter = 1;
    enum Difficulty{
        EASY,
        MODERATE,
        HARD
    }
    String name;
    public ArrayList <Creature> creaturesLoreArray;
    public ArrayList <Weapon> weaponsLoreArray;
    public ArrayList <Event> eventArrayList;


    public Lore(Difficulty difficulty){
        this.difficulty = difficulty;
        this.name = difficulty.toString() + "_LORE";
        creaturesLoreArray = new ArrayList<>();
        weaponsLoreArray = new ArrayList<>();
        eventArrayList = new ArrayList<>();

        ArrayList <Event> tempA = new ArrayList<>();
        ArrayList <Event> tempB = new ArrayList<>();

        if(difficulty.equals(Difficulty.EASY)) {
            for (int i = 0; i < 5; i++) {
                eventArrayList.add(new Event(Event.TypeOfEvent.FIGHT, Event.Difficulty.LOW));
                int random = (int) round(dice.nextDouble());
                if (random < 3) {
                    eventArrayList.add(new Event(Event.TypeOfEvent.REST, Event.Difficulty.MEDIUM));
                } else {
                    eventArrayList.add(new Event(Event.TypeOfEvent.REST, Event.Difficulty.LOW));
                }
            }
        }
        if (difficulty.equals(Difficulty.MODERATE)){
            for (int i = 0; i < 5; i++) {
                int random1 = (int) round(dice.nextDouble());

                if(random1 <= 3){
                    eventArrayList.add(new Event(Event.TypeOfEvent.FIGHT, Event.Difficulty.MEDIUM));
                }
                else{
                    eventArrayList.add(new Event(Event.TypeOfEvent.FIGHT, Event.Difficulty.LOW));
                }

                int random = (int) round(dice.nextDouble());
                if(random <= 1){
                    eventArrayList.add(new Event(Event.TypeOfEvent.REST, Event.Difficulty.HIGH));
                }
                else if  (random < 3) {
                    eventArrayList.add(new Event(Event.TypeOfEvent.REST, Event.Difficulty.LOW));
                } else {
                    eventArrayList.add(new Event(Event.TypeOfEvent.REST, Event.Difficulty.MEDIUM));
                }
            }
        }
    }
}
