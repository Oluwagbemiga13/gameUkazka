package org.example;

import java.io.Serializable;
import java.util.ArrayList;

import static org.example.Creature.fight;
import static org.example.Main.currentLore;
import static org.example.tools.CreativeLedger.creativeEventArray;
import static org.example.tools.GameGenerator.*;
import static org.example.Main.input;

public class Event implements Serializable {
    String type;
    public int positionInLoreArray;
    public Creature creature;
    public Item item;
    public String message;

    static int counterOfCreated = 0;

    public int plusHP = 0;
    public int minusHP = 0;

    public TypeOfEvent typeOfEventVar;
    public Difficulty difficultyVar;

    public enum Difficulty{
        LOW,
        MEDIUM,
        HIGH,
        NONE
    }
    public enum TypeOfEvent {
        FIGHT,
        REST,
        FIND
    }

    public boolean isOnEndOfArray(){
       int index =  currentLore.eventArrayList.indexOf(this);
       boolean isAtEnd = false;
       if(index == currentLore.eventArrayList.size() - 1){
           isAtEnd = true;
       }
       return isAtEnd;
    }

    public boolean isOnBeginningOfArray(){
        int index =  currentLore.eventArrayList.indexOf(this);
        boolean isAtBeginning = false;
        if(index == 0){
            isAtBeginning = true;
        }
        return isAtBeginning;
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

    //CONSTRUCTOR AUTO
    public Event(TypeOfEvent t, Difficulty d){
        this.type = t.toString() +"_" +  d.toString();
        this.typeOfEventVar = t;
        this.difficultyVar = d;
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
                    message = "You rested little bit + 5HP ";
                    plusHP= 5;
                    break;
                case HIGH:
                    message = "You opened your favourite bottle and it helped. + 10HP";
                    plusHP = 10;
                    break;
            }

        }
        positionInLoreArray = counterOfCreated;
        counterOfCreated++;
    }

    //CONSTRUCTOR CREATIVE
    public Event(String message, int plusHP, int minusHP){
        this.message = message;
        this.plusHP = plusHP;
        this.minusHP = minusHP;
        this.typeOfEventVar = TypeOfEvent.REST;
        creativeEventArray.add(this);
    }

    public Event(Creature creature){
        this.creature = creature;
        this.typeOfEventVar = TypeOfEvent.FIGHT;
        creativeEventArray.add(this);
    }

    public Event(Creature creature, String message){
        this.creature = creature;
        this.typeOfEventVar = TypeOfEvent.FIGHT;
        this.message = message;
        creativeEventArray.add(this);
    }

    public void consumeEvent(){
        System.out.println(message);

        if(typeOfEventVar.equals(TypeOfEvent.FIGHT)){
            if(input.returnDoIt()) {
                while (!currentPlayer.isDead && !creature.isDead) {
                    fight(currentPlayer, creature);
                }
            }
        }
        if (typeOfEventVar.equals(TypeOfEvent.REST)){

            if(!difficultyVar.equals(Difficulty.LOW)){
                currentPlayer.hP += this.plusHP;
            }
        }
    }
}
