package com.mycompany.dispozitiv_mobil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FitnessBandFrame extends JFrame {
    protected JTextField brandField, modelField, senzorField, rezistentaApaField, pretField;
    protected JTextArea rezultat;
    protected JScrollPane scrollPanel;
    protected JButton filterButton;
    protected JCheckBox monitorizareSomnCheckBox;
    
    protected ArrayList<FitnessBand> fitnessBand;

    public FitnessBandFrame(ArrayList<FitnessBand> fitnessBand) {
        this.fitnessBand = fitnessBand;
        setTitle("Detalii fitness band");
        setSize(1920,1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        JPanel panelFiltre = new JPanel();
        panelFiltre.setLayout(new GridLayout(9, 2, 10, 10));
        panelFiltre.setPreferredSize(new Dimension(350, 1080));

        filterButton = new JButton("Filtreaza");

        rezultat = new JTextArea(20, 50);

        scrollPanel = new JScrollPane(rezultat);
        scrollPanel.setPreferredSize(new Dimension(1400, 1000));

        panelFiltre.add(new JLabel("Brand:"));
        panelFiltre.add(brandField = new JTextField(10));
        panelFiltre.add(new JLabel("Model:"));
        panelFiltre.add(modelField = new JTextField());
        panelFiltre.add(new JLabel("Senzor:"));
        panelFiltre.add(senzorField = new JTextField());
        panelFiltre.add(new JLabel("Rezistenta apa:"));
        panelFiltre.add(rezistentaApaField = new JTextField());
        panelFiltre.add(new JLabel("Pret maxim:"));
        panelFiltre.add(pretField = new JTextField());
        panelFiltre.add(monitorizareSomnCheckBox = new JCheckBox("Monitorizare somn"));
        panelFiltre.add(filterButton);

        add(panelFiltre, BorderLayout.WEST);
        add(scrollPanel, BorderLayout.CENTER);

        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtreazaFitnessBand();
            }
        });
    }

    public void filtreazaFitnessBand() {
        StringBuilder sb = new StringBuilder();
        String brand = brandField.getText().toLowerCase();
        String model = modelField.getText().toLowerCase();
        String senzor = senzorField.getText().toLowerCase();
        String rezistentaApa = rezistentaApaField.getText().toLowerCase();
        String pret = pretField.getText();
        boolean monitorizareSomn = monitorizareSomnCheckBox.isSelected();

        for (FitnessBand fb : fitnessBand) {
            boolean sePotriveste = true;
            if (!brand.isEmpty() && !fb.getBrand().toLowerCase().contains(brand))
                continue;

            if (!model.isEmpty() && !fb.getModel().toLowerCase().contains(model))
                continue;
            
            if (!senzor.isEmpty() && !fb.getSenzor().toLowerCase().contains(senzor))
                continue;
            
            if (!rezistentaApa.isEmpty() && !fb.getRezistentaApa().toLowerCase().contains(rezistentaApa))
                continue;

            if (!pret.isEmpty()) {
                try {
                    double pretValue = Double.parseDouble(pret);
                    if (fb.getPret() >= pretValue) {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Introduceti un numar valid.");
                    return;
                }
            }
            
            if (monitorizareSomn && !fb.getMonitorizareSomn())
                continue;

            if (sePotriveste) {
                sb.append(fb.toString() + "\n");
            }
        }

        if (sb.length() == 0) {
            rezultat.setText("Nu exista.");
        } else {
            rezultat.setText(sb.toString());
        }
    }
}