package com.mycompany.dispozitiv_mobil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Interfata extends JFrame {
    private ArrayList<Telefon> telefoane;
    private ArrayList<Tableta> tablete;
    public Interfata(ArrayList<Telefon> telefoane,ArrayList<Tableta> tablete ) {
        this.telefoane = telefoane;
        this.tablete=tablete;
        setTitle("Interfata Principala");
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Create a panel to hold the buttons
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create 6 buttons
        JButton telefonButton = new JButton("Telefon");
        JButton tabletaButton = new JButton("Tableta");
        JButton fitnessBandButton = new JButton("Fitness Band");
        JButton accesoriiFitnessButton = new JButton("Smartwatch");
        JButton button5 = new JButton("Accesorii Fitness");
        JButton button6 = new JButton("Accesorii Smartwatch");

        // Add action listeners for Telefon and Tableta buttons
        telefonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TelefonFrame(telefoane).setVisible(true); // Pass the list to TelefonFrame
            }
        });

        tabletaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TabletaFrame(tablete).setVisible(true);
            }
        });
        
        fitnessBandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FitnessBandFrame();
            }
        });
        
        accesoriiFitnessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AccesoriiFitnessFrame();
            }
        });

        // Add buttons to the panel
        panel.add(telefonButton);
        panel.add(Box.createVerticalStrut(100));
        panel.add(tabletaButton);
        panel.add(Box.createVerticalStrut(100));
        panel.add(fitnessBandButton);
        panel.add(Box.createVerticalStrut(100));
        panel.add(accesoriiFitnessButton);
        panel.add(Box.createVerticalStrut(100));
        panel.add(button5);
        panel.add(Box.createVerticalStrut(100));
        panel.add(button6);
        panel.add(Box.createVerticalStrut(100));
        panel.setBounds(50, 50, 300, 800);
        // Add the panel to the frame
        add(panel);
        setVisible(true);
    }
}
