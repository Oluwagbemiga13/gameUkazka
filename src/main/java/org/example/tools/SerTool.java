package org.example.tools;

import org.example.Creature;
import org.example.Lore;

import java.io.*;
import java.util.ArrayList;

import static org.example.tools.GameGenerator.creatureArrayList;
import static org.example.tools.GameGenerator.currentPlayer;
import static org.example.tools.PersistentInfo.persistentInfoSavedGames;

public class SerTool {


    public static void saveCreature(Creature creature) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(creature.name + "_" + creature.positionArrayList +".ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(creature);

        objectOutputStream.close();
        fileOutputStream.close();
    }

    public static Creature loadCreature(String nameOfFile) throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(nameOfFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Creature creature = (Creature) objectInputStream.readObject();

        fileInputStream.close();
        objectInputStream.close();

        return creature;

    }

    public static void saveCreatureArrayList(ArrayList<Creature> arrayList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\danie\\Documents\\NetBeansProjects\\gameUkazka\\src\\main\\java\\org\\example\\savedGames\\CreatureArrayList.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(arrayList);

        objectOutputStream.close();
        fileOutputStream.close();
    }

    public static ArrayList loadCreatureArrayList(String nameOfFile) throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(nameOfFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        ArrayList arrayList = (ArrayList) objectInputStream.readObject();

        fileInputStream.close();
        objectInputStream.close();

        return arrayList;
    }

    public static void saveEverything() throws IOException {
        saveCreatureArrayList(creatureArrayList);
    }
    public static void saveLore(Lore lore) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\danie\\Documents\\NetBeansProjects\\gameUkazka\\src\\main\\" +
                "java\\org\\example\\savedGames\\" + currentPlayer.name + "_SAVED_GAME" + ".ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(lore);

        objectOutputStream.close();
        fileOutputStream.close();

        persistentInfoSavedGames++;
    }

    public static Lore loadLore(String nameOfFile) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(nameOfFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        return (Lore) objectInputStream.readObject();
    }

    public static void saveInfo() throws IOException {
        PersistentInfo info = new PersistentInfo(persistentInfoSavedGames);
        FileOutputStream fileOutputStream = new FileOutputStream( "PersistentInfo.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(info);

        objectOutputStream.close();
        fileOutputStream.close();
    }

    public static PersistentInfo loadInfo() throws IOException, ClassNotFoundException {
        String nameOfFile = "PersistentInfo.ser";
        FileInputStream fileInputStream = new FileInputStream(nameOfFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        return (PersistentInfo) objectInputStream.readObject();
    }

}
