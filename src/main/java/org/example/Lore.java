package org.example;

import java.util.ArrayList;

import static org.example.Creature.fight;
import static org.example.GameGenerator.creatureArrayList;

public class Lore {
    String name;
    public ArrayList <Creature> creaturesLoreArray;
    public ArrayList <Weapon> weaponsLoreArray;
    public ArrayList <Event> eventArrayList;


    public Lore(String name){
        this.name = name;
        creaturesLoreArray = new ArrayList<>();
        weaponsLoreArray = new ArrayList<>();
        eventArrayList = new ArrayList<>();

        ArrayList <Event> tempA = new ArrayList<>();
        ArrayList <Event> tempB = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            eventArrayList.add(new Event(Event.TypeOfEvent.FIGHT, Event.Difficulty.LOW));
        }
        for (int i = 0; i < 5; i++){
            eventArrayList.add(new Event(Event.TypeOfEvent.FIGHT, Event.Difficulty.MEDIUM));
        }
        for (int i = 0; i < 5; i++){
            eventArrayList.add(new Event(Event.TypeOfEvent.REST, Event.Difficulty.HIGH));
        }
    }
}
