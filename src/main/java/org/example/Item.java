package org.example;

import java.io.Serializable;

public class Item implements Serializable {
    String name;
    String t;


    public Item(String name){
        this.name = name;
         t = "item";
    }
}
