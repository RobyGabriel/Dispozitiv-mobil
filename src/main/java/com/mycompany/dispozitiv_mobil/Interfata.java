package com.mycompany.dispozitiv_mobil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Interfata extends JFrame{
    public Interfata() {
        setTitle("Interfata Principala");
        setSize(1980, 1080);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Create a panel to hold the buttons
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Create 6 buttons
        JButton telefonButton = new JButton("Telefon");
        JButton tabletaButton = new JButton("Tableta");
        JButton button3 = new JButton("Fitness Band");
        JButton button4 = new JButton("Smartwatch");
        JButton button5 = new JButton("Accesorii Fitness");
        JButton button6 = new JButton("Accesorii Smartwatch");

        // Add action listeners for Telefon and Tableta buttons
        telefonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelefonFrame();
            }
        });

        tabletaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TabletaFrame();
            }
        });

        // Add buttons to the panel
        panel.add(telefonButton);
        panel.add(Box.createVerticalStrut(100));
        panel.add(tabletaButton);
        panel.add(Box.createVerticalStrut(100));
        panel.add(button3);
        panel.add(Box.createVerticalStrut(100));
        panel.add(button4);
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
        public static void main(String[] args) {
        Interfata a=new Interfata();
    }
}
