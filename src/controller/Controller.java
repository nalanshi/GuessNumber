package controller;

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
        if(e.getActionCommand().equals("Button"))
            view.getJlabel().setText(number.isCorrect(view.getTextField().getText()));
    }
}
