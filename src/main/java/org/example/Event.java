package org.example;

import java.util.ArrayList;

import static org.example.GameGenerator.creatureArrayList;

public class Event {
    String type;
    int positionInLoreArray;
    Creature creature;
    Item item;

    String message;

    public static Creature returnFirstAlive(ArrayList<Creature> creatures){
        Creature creature = null;
        for (Creature c : creatures) {
            if (!c.isDead){
                creature = c;
            }
        }
        return creature;
    }

    public Event(String type){
        this.type = type;
        if (type.equals("fight")){
            creature = returnFirstAlive(creatureArrayList);
            this.message = "FIGHT: Do you want to attack " + creature.name + " ?";
        }
        if (type.equals("item")) {
            item = new Item("ITEM");
            this.message = "ITEM: ...";
        }
    }
}
