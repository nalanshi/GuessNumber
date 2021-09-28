package controller;

import model.Log;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Oniichan
 * @data 14/09/2021
 * @project GuessNumber
 */
public class Controller implements ActionListener {
    private model.Number number;
    private View view;
    public Controller(model.Number number,View view){
        this.number = number;
        this.view = view;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String response = null;
        if (e.getActionCommand().equals("Button")) {
            response = number.isCorrect(view.getTextField().getText());
            view.getJlabel().setText(response);
        }
        if(e.getActionCommand().equals("Log")){
            response = Log.logRead();
            view.refreshLog(response);
        }
    }
}
