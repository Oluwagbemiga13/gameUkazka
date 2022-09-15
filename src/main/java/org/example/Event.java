package org.example;

import java.util.ArrayList;

import static org.example.GameGenerator.*;

public class Event {
    String type;
    int positionInLoreArray;
    Creature creature;
    Item item;
    String message;

    enum Difficulty{
        LOW,
        MEDIUM,
        HIGH,
        NONE
    }
    enum TypeOfEvent {
        FIGHT,
        REST,
        FIND
    }



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

    public Event(TypeOfEvent t, Difficulty d){
        this.type = t.toString() +"_" +  d.toString();
        if(t.equals(TypeOfEvent.FIGHT)){
            switch (d) {
                case LOW:
                    creature  = createSkeleton();
                    message = "You see skeleton. Do you want to fight? (Y/N):";
                    break;
                case MEDIUM:
                    creature = createWitch();
                    message = "You see witch. Do you want to fight? (Y/N):";
                    break;
                case HIGH:
                    creature = createSpider();
                    message = "You see spider. Do you want to fight? (Y/N):";
                    break;
                default: System.out.println("Invalid enum");
                    message = "INVALID ENUM";
                break;
            }

        }
        if(t.equals(TypeOfEvent.REST)){
            switch (d) {
                case LOW:
                    message = "Nothing interesting happened.";
                    break;
                case MEDIUM:
                    message = "You rested little bit + 5HP \n IMPLEMENT DMG!";
                    break;
                case HIGH:
                    creature = createSpider();
                    message = "You opened your favourite bottle and it helped. + 10HP";
            }

        }


            creature.isSetInLore = true;
            this.message = "FIGHT: Do you want to attack " + creature.name + " ?";
            System.out.println(creature.name + " was added to Event.");

        if (type.equals("item")) {
            item = new Item("ITEM");
            this.message = "ITEM: ...";
        }
    }
}
