package com.mycompany.dispozitiv_mobil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Interfata extends JFrame {
    protected ArrayList<Telefon> telefoane;
    protected ArrayList<Tableta> tablete;
    protected ArrayList<FitnessBand> fitnessBand;
    protected ArrayList<AccesoriiFitness> accesoriiFitness;
    protected ArrayList<Smartwatch> smartwatch;
    protected ArrayList<AccesoriiSmartwatch> accesoriiSmartwatch;
    public Interfata(ArrayList<Telefon> telefoane,ArrayList<Tableta> tablete, ArrayList<FitnessBand> fitnessBand, ArrayList<AccesoriiFitness> accesoriiFitness) {
        this.telefoane = telefoane;
        this.tablete=tablete;
        this.accesoriiFitness=accesoriiFitness;
        this.fitnessBand=fitnessBand;
        setTitle("Interfata Principala");
        setSize(1000, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton telefonButton = new JButton("Telefon");
        JButton tabletaButton = new JButton("Tableta");
        JButton fitnessBandButton = new JButton("Fitness Band");
        JButton accesoriiFitnessButton = new JButton("Accesorii Fitness");
        JButton smartwatchButton = new JButton("Smartwatch");
        JButton accesoriiSmartwatchButton = new JButton("Accesorii Smartwatch");

        telefonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TelefonFrame(telefoane).setVisible(true);
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
                new FitnessBandFrame(fitnessBand).setVisible(true);
            }
        });
        
        accesoriiFitnessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AccesoriiFitnessFrame(accesoriiFitness).setVisible(true);
            }
        });
        smartwatchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                new SmartwatchFrame(smartwatch).setVisible(true);
            }
        });

        accesoriiSmartwatchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                new AccesoriiSmartwatchFrame(accesoriiSmartwatch).setVisible(true);
            }
        });

        panel.add(telefonButton);
        panel.add(Box.createVerticalStrut(100));
        panel.add(tabletaButton);
        panel.add(Box.createVerticalStrut(100));
        panel.add(fitnessBandButton);
        panel.add(Box.createVerticalStrut(100));
        panel.add(accesoriiFitnessButton);
        panel.add(Box.createVerticalStrut(100));
        panel.add(smartwatchButton);
        panel.add(Box.createVerticalStrut(100));
        panel.add(accesoriiSmartwatchButton);
        panel.add(Box.createVerticalStrut(100));
        panel.setBounds(50, 50, 300, 800);
        add(panel);
        setVisible(true);
    }
}
