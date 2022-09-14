package org.example;

import java.util.ArrayList;

import static org.example.Creature.fight;
import static org.example.GameGenerator.createEvent;
import static org.example.GameGenerator.creatureArrayList;

public class Lore {
    String name;
    public ArrayList <Creature> creaturesLoreArray;
    public ArrayList <Weapon> weaponsLoreArray;
    public ArrayList <Event> eventArrayList;

    public void goThroughLore(Creature player){
        for(Event event : this.eventArrayList){
            if (event.type.equals("fight")){
                while (!player.isDead){
                    fight(creatureArrayList.get(0), event.creature);
                }
            }
            else {
                System.out.println("EVENT");
            }
        }
    }

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
            eventArrayList.add(tempB.get(i));
        }
    }
}
