package org.example.tools;

import org.example.Creature;
import org.example.Event;

import java.util.ArrayList;


public class CreativeConstructor {

    public static Event creativeEventRest(String message, int plusHP, int minusHP){
        return new Event(message,plusHP,minusHP);
    }

    public static Event creativeEventFight(Creature creature, String message){
        return new Event(creature,message);
    }
    
    public static String [] getStringArrFromEventArrList(ArrayList<Event> eventArrayList){
        int sizeOfArray = eventArrayList.size();
        String [] stringArray = new String[eventArrayList.size()];
        for(int i = 0; i < eventArrayList.size(); i++){
            stringArray [i] = eventArrayList.get(i).typeOfEventVar.toString();
        }

        return stringArray;
    }


}
