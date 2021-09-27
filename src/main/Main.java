package main;

import model.Log;
import view.View;

import javax.swing.*;
import java.awt.*;


/**
 * @author Oniichan
 * @data 14/09/2021
 * @project GuessNumber
 */
public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    if(JOptionPane.showConfirmDialog(null,"Do you want to delete Log file?","Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0)
                        Log.deleteLog();
                    Log.logWrite("Game started");
                    View frame = new View();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                finally{
                    Log.logWrite("Game ended");
                }
            }
        });
    }
}
