package org.example;

import java.io.Serializable;

public class Item implements Serializable {
    String name;
    String type;


    public Item(String name){
        this.name = name;
         type = "item";
    }
}
