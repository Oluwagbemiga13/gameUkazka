package org.example.tools;

import java.io.Serializable;

public class PersistentInfo implements Serializable {

    public static int persistentInfoSavedGames;

    public int counterOfSavedGames;


    public PersistentInfo(int counterOfSavedGames){
        this.counterOfSavedGames = counterOfSavedGames;
    }
}
