package com.mycompany.app;

import java.awt.*;
import javax.swing.*;

public class View {
    public static JPanel mainPanel;
    public static void RenderUi() {
        // Crear vntana
        JFrame frame = new JFrame();
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear main panel que contiene ambas columnas
        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE; // Prevent stretching
        gbc.insets = new Insets(15, 15, 15, 15); // Add padding between components

        frame.getContentPane().add(mainPanel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public static void addToSubpanel(JPanel subPanel, JComponent... components){
        for (JComponent component : components){
            subPanel.add(component);
        }
    }

    public static void createSingleInputView(Hanoi hanoi) {
        // Create subpanel to add content
        JPanel fixedColumnPanel = new JPanel(new GridBagLayout());
        
        // Add components to the fixed column
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Get class name and assign to label
        JLabel columnLabel = new JLabel(hanoi.getClass().getSimpleName());
        JLabel answer = new JLabel("Respuesta: ");
        
        // Create inputs
        JTextField inputField = new JTextField(16);
        
        // Validate numbers
        inputField.addKeyListener(new NumberValidator(inputField));
        
        // Create button and event listener
        JButton button = new JButton("Calcular");
        button.addActionListener(new SingleInputListener(hanoi, inputField, answer));
        
        addToSubpanel(fixedColumnPanel, columnLabel, inputField, button);
        
        // Create growing panel for answer
        JPanel answerGrowingPanel = new JPanel();
        answerGrowingPanel.setLayout(new GridBagLayout());
        
        gbc.gridx = 1; gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        answerGrowingPanel.add(answer, gbc);
        
        JScrollPane scrollPane = new JScrollPane(answerGrowingPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 1; gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        mainPanel.add(fixedColumnPanel, gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;
        mainPanel.add(scrollPane, gbc);

    }
}
