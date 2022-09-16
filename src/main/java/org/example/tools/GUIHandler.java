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
    
}
