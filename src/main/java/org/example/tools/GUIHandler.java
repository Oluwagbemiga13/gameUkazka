/*
 *  @ Danile Rakovský
$RequestHeader set AuditDate expr=%{TIME_YEAR}-%{TIME_MON}-%{TIME_DAY}
$RequestHeader set AuditDateTime expr=%{TIME}
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.tools;


import org.example.gui.FirstFrame;
import org.example.gui.LoadGameFrame;
import org.example.gui.NewGameFrame;
import org.example.gui.PlayFrame;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class GUIHandler {
    
    public void createFirstFrame(){
        FirstFrame firstWindow = new FirstFrame();
        firstWindow.setVisible(true);
    }

    public void createNewGameFrame() {
        NewGameFrame newGameFrame = new NewGameFrame();
        newGameFrame.setVisible(true);
        
    }
    
    public void createLoadGameFrame(){
        LoadGameFrame loadGameFrame = new LoadGameFrame();
        loadGameFrame.setVisible(true);
    }
    
    public void createPlayFrame(){
        PlayFrame playFrame = new PlayFrame();
        playFrame.setVisible(true);
        playFrame.setFrameFightDecision();
    }

    public String [] getFilesNames (){
        // get all files in the folder excluding sub-folders
        final File folder = new File("C:\\Users\\danie\\Documents\\NetBeansProjects\\gameUkazka\\src\\main\\" +
                "java\\org\\example\\savedGames\\");
        final List<File> fileList = Arrays.asList(folder.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        }));
        String [] stringArray = new String[fileList.size()];
        for(int i = 0; i < fileList.size(); i++){
            stringArray [i] = fileList.get(i).getName();
        }
        return stringArray;
    }
    
}
