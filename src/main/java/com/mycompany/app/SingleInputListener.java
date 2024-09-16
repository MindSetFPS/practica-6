package com.mycompany.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SingleInputListener implements ActionListener {

    public Hanoi hanoi;
    public JTextField inputField;
    public JLabel answer;

    public SingleInputListener(Hanoi hanoi, JTextField inpuTextField, JLabel answer) {
        this.hanoi = hanoi;
        this.inputField = inpuTextField;
        this.answer = answer;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        answer.setText(
            "<html>" + 
            Hanoi.play(Integer.parseInt(inputField.getText()), 'A', 'B', 'C') +
            "</html>"
        );
    }
}