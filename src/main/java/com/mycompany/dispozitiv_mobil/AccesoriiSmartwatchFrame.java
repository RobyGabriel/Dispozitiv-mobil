package com.mycompany.dispozitiv_mobil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class AccesoriiSmartwatchFrame extends JFrame {

    protected JTextField brandField, tipAccesoriiField, modelHusaField, pretField, tipIncarcatorField;
    protected JTextArea rezultat;
    protected JScrollPane scrollPanel;
    protected JButton filterButton, addButton, loadButton;

    protected ArrayList<AccesoriiSmartwatch> accesoriiSmartwatch;
    protected String locatie = "accesoriismartwatchuri.txt"; 

    public AccesoriiSmartwatchFrame(ArrayList<AccesoriiSmartwatch> accesoriiSmartwatch) {
        this.accesoriiSmartwatch = accesoriiSmartwatch;
        setTitle("Detalii accesorii Smartwatch");
        setSize(1920, 1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        JPanel panelFiltre = new JPanel();
        panelFiltre.setLayout(new GridLayout(9, 2, 10, 10));
        panelFiltre.setPreferredSize(new Dimension(350, 1080));

        filterButton = new JButton("Filtreaza");
        addButton = new JButton("Adauga Accesoriu");
        loadButton = new JButton("Incarca Datele");

        rezultat = new JTextArea(20, 50);
        scrollPanel = new JScrollPane(rezultat);
        scrollPanel.setPreferredSize(new Dimension(1400, 1000));

        panelFiltre.add(new JLabel("Brand:"));
        panelFiltre.add(brandField = new JTextField(10));
        panelFiltre.add(new JLabel("Tip Accesorii:"));
        panelFiltre.add(tipAccesoriiField = new JTextField());
        panelFiltre.add(new JLabel("Model Husa:"));
        panelFiltre.add(modelHusaField = new JTextField());
        panelFiltre.add(new JLabel("Pret:"));
        panelFiltre.add(pretField = new JTextField());
        panelFiltre.add(new JLabel("Tip Incarcator:"));
        panelFiltre.add(tipIncarcatorField = new JTextField());

        panelFiltre.add(filterButton);
        panelFiltre.add(addButton);
        panelFiltre.add(loadButton);

        add(panelFiltre, BorderLayout.WEST);
        add(scrollPanel, BorderLayout.CENTER);

        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtreazaAccesoriiSmartwatch();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAccesorii();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadAccesoriiFromFile();
            }
        });
    }

    
    public void addAccesorii() {
        try {
            String brand = brandField.getText();
            double pret = Double.parseDouble(pretField.getText());
            String tipAccesorii = tipAccesoriiField.getText();
            String modelHusa = modelHusaField.getText();
            String tipIncarcator = tipIncarcatorField.getText();

           
            AccesoriiSmartwatch newAccesorii = new AccesoriiSmartwatch(brand, 0, pret, 0, tipAccesorii, modelHusa, tipIncarcator);

            saveAccesoriiToFile(newAccesorii);

            clearFields();

            JOptionPane.showMessageDialog(this, "Accesoriul a fost adaugat cu succes!");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Te rugam sa introduci valori valide!");
        }
    }

   
    private void saveAccesoriiToFile(AccesoriiSmartwatch accesorii) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(locatie, true))) {
            writer.write(accesorii.getBrand() + "|"
                    + accesorii.getTipAccesorii() + "|"
                    + accesorii.getModelHusa() + "|"
                    + accesorii.getPret() + "|"
                    + accesorii.getTipIncarcator());
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Eroare la salvarea datelor!");
        }
    }

   
    private void clearFields() {
        brandField.setText("");
        tipAccesoriiField.setText("");
        modelHusaField.setText("");
        pretField.setText("");
        tipIncarcatorField.setText("");
    }

   
    public void loadAccesoriiFromFile() {
        accesoriiSmartwatch.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(locatie))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                String brand = data[0];
                String tipAccesorii = data[1];
                String modelHusa = data[2];
                double pret = Double.parseDouble(data[3]);
                String tipIncarcator = data[4];

                
                AccesoriiSmartwatch accesorii = new AccesoriiSmartwatch(brand, 0, pret, 0, tipAccesorii, modelHusa, tipIncarcator);
                this.accesoriiSmartwatch.add(accesorii);
            }
            JOptionPane.showMessageDialog(this, "Datele au fost incarcate cu succes!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Eroare la incarcarea datelor!");
        }
    }

    
    public void filtreazaAccesoriiSmartwatch() {
        StringBuilder sb = new StringBuilder();
        String brand = brandField.getText().toLowerCase();
        String tipAccesorii = tipAccesoriiField.getText().toLowerCase();
        String modelHusa = modelHusaField.getText().toLowerCase();
        String pret = pretField.getText();
        String tipIncarcator = tipIncarcatorField.getText().toLowerCase();

        for (AccesoriiSmartwatch as : accesoriiSmartwatch) {
            boolean sePotriveste = true;
            if (!brand.isEmpty() && !as.getBrand().toLowerCase().contains(brand)) {
                continue;
            }

            if (!tipAccesorii.isEmpty() && !as.getTipAccesorii().toLowerCase().contains(tipAccesorii)) {
                continue;
            }

            if (!modelHusa.isEmpty() && !as.getModelHusa().toLowerCase().contains(modelHusa)) {
                continue;
            }

            if (!pret.isEmpty()) {
                try {
                    double pretValue = Double.parseDouble(pret);
                    if (as.getPret() >= pretValue) {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Introduceti un numar valid.");
                    return;
                }
            }

            if (!tipIncarcator.isEmpty() && !as.getTipIncarcator().toLowerCase().contains(tipIncarcator)) {
                continue;
            }

            if (sePotriveste) {
                sb.append(as.toString() + "\n");
            }
        }

        if (sb.length() == 0) {
            rezultat.setText("Nu exista.");
        } else {
            rezultat.setText(sb.toString());
        }
    }
}
