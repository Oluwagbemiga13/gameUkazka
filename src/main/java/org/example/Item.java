package org.example;

import java.io.Serializable;

public class Item implements Serializable {
    String name;
    String t;

    public int healingPoints = 0;
    int damagePoints = 0;


    public Item(String name){
        this.name = name;

    }
}
