package main;

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
                    View frame = new View();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
