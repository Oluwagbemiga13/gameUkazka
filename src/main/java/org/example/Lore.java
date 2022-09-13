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

        for (int i = 0; i < (tempA.size() + tempB.size() - 2); i++){
            if(i % 2 == 0 || i == 0) {
                eventArrayList.add(tempA.get(i));
            }
            if( i % 2 != 0) {
                eventArrayList.add(tempB.get(i));
            }
        }
         /*
        while (counter < (tempA.size() + tempB.size() - 2)){
            if(counter % 2 == 0 || counter == 0) {
                eventArrayList.add(tempA.get(counter));
            }
            else {
                eventArrayList.add(tempB.get(counter));
            }
            counter ++;
        }

          */
    }
}
