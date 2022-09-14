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
        for (int i = 0; i < creatureArrayList.size(); i++) {
            Creature c = creatureArrayList.get(i);
            if (!c.isDead && !c.isSetInLore){
                creature = c;
                break;
            }
        }
        return creature;
    }

    public Event(String type){
        this.type = type;
        if (type.equals("fight")){
            creature = returnFirstAlive(creatureArrayList);
            creature.isSetInLore = true;
            this.message = "FIGHT: Do you want to attack " + creature.name + " ?";
            System.out.println(creature.name + " was added to Event.");
        }
        if (type.equals("item")) {
            item = new Item("ITEM");
            this.message = "ITEM: ...";
        }
    }
}
