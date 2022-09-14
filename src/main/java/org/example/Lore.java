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
        for(int i = 1; i < this.eventArrayList.size(); i++){
            Event event = this.eventArrayList.get(i);
            if (event.type.equals("fight")){
                while (!player.isDead && !event.creature.isDead){
                    fight(player, event.creature);
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

        for (int i = 0; i < (creatureArrayList.size()-1); i++){
            tempA.add(createEvent("fight"));
        }
        for (int i = 0; i < 5; i++){
            tempB.add(createEvent("item"));
        }
        int counter = 0;
        for(int i = 0; i < tempA.size()-1; i++){
            eventArrayList.add(tempA.get(i));
            //eventArrayList.add(tempB.get(i));
        }
    }
}
