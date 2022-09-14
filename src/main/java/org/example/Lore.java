package org.example;

import java.util.ArrayList;

import static org.example.GameGenerator.createEvent;

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
            tempA.add(createEvent("fight"));
        }
        for (int i = 0; i < 5; i++){
            tempB.add(createEvent("item"));
        }
        int counter = 0;
        for(int i = 0; i < tempA.size(); i++){
            eventArrayList.add(tempA.get(i));
            System.out.println(tempA.get(i).type);
            eventArrayList.add(tempB.get(i));
            System.out.println(tempB.get(i).type);
        }
    }
}
