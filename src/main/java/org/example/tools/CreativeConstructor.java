package org.example.tools;

import org.example.Event;

public class CreativeConstructor {

    public static Event creativeEvent(String message, int plusHP, int minusHP){
        return new Event(message,plusHP,minusHP);
    }
}
