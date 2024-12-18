package com.mycompany.dispozitiv_mobil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class SmartwatchFrame extends JFrame{
    protected JTextField brandField, culoareField, tipecranField, rezapaField, pretField;
    protected JTextArea rezultat;
    protected JScrollPane scrollPanel;
    protected JButton filterButton, addButton, loadButton;
    protected ArrayList<Smartwatch> smartwatch;
    protected String locatie = "smartwatchuri.txt";

    public SmartwatchFrame(ArrayList<Smartwatch> smartwatch) {
        this.smartwatch = smartwatch;
        setTitle("Detalii Smartwatch");
        setSize(1920,1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        JPanel panelFiltre = new JPanel();
        panelFiltre.setLayout(new GridLayout(10, 2, 10, 10)); 
        panelFiltre.setPreferredSize(new Dimension(350, 1080));

        filterButton = new JButton("Filtreaza");
        addButton = new JButton("Adauga Smartwatch");
        loadButton = new JButton("Incarca Datele");

        rezultat = new JTextArea(20, 50);
        scrollPanel = new JScrollPane(rezultat);
        scrollPanel.setPreferredSize(new Dimension(1400, 1000));

        panelFiltre.add(new JLabel("Brand:"));
        panelFiltre.add(brandField = new JTextField(10));
        panelFiltre.add(new JLabel("Culoare:"));
        panelFiltre.add(culoareField = new JTextField());
        panelFiltre.add(new JLabel("Tipul Ecranului:"));
        panelFiltre.add(tipecranField = new JTextField());
        panelFiltre.add(new JLabel("Rezistenta la apa:"));
        panelFiltre.add(rezapaField = new JTextField());
        panelFiltre.add(new JLabel("Pret:"));
        panelFiltre.add(pretField = new JTextField());

        panelFiltre.add(filterButton);
        panelFiltre.add(addButton);
        panelFiltre.add(loadButton);

        add(panelFiltre, BorderLayout.WEST);
        add(scrollPanel, BorderLayout.CENTER);

        filterButton.addActionListener(new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                filtreazaSmartwatch();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSmartwatch();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadSmartwatchuriFromFile();
            }
        });
    }

    public void addSmartwatch() {
        try {
            String brand = brandField.getText();
            double pret = Double.parseDouble(pretField.getText());
            String culoare = culoareField.getText();
            String tipEcran = tipecranField.getText();
            String rezApa = rezapaField.getText();

            Smartwatch newSmartwatch = new Smartwatch(brand, 0, pret, 0, culoare, tipEcran, rezApa);

            saveSmartwatchToFile(newSmartwatch);

            clearFields();

            JOptionPane.showMessageDialog(this, "Smartwatch-ul a fost adaugat cu succes!");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Te rugam sa introduci valori valide!");
        }
    }

    private void saveSmartwatchToFile(Smartwatch smartwatch) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(locatie, true))) {
            writer.write(smartwatch.getBrand() + "|"
                    + smartwatch.getPret() + "|"
                    + smartwatch.getCuloare() + "|"
                    + smartwatch.getTipEcran() + "|"
                    + smartwatch.getRezApa());
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Eroare la salvarea datelor!");
        }
    }

    private void clearFields() {
        brandField.setText("");
        pretField.setText("");
        culoareField.setText("");
        tipecranField.setText("");
        rezapaField.setText("");
    }

    public void loadSmartwatchuriFromFile() {
        smartwatch.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(locatie))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                String brand = data[0];
                double pret = Double.parseDouble(data[1]);
                String culoare = data[2];
                String tipEcran = data[3];
                String rezApa = data[4];

                Smartwatch smartwatch = new Smartwatch(brand, 0, pret, 0, culoare, tipEcran, rezApa);
                this.smartwatch.add(smartwatch);
            }
            JOptionPane.showMessageDialog(this, "Datele au fost incarcate cu succes!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Eroare la incarcarea datelor!");
        }
    }

    public void filtreazaSmartwatch() {
        StringBuilder sb = new StringBuilder();
        String brand = brandField.getText().toLowerCase();
        String culoare = culoareField.getText().toLowerCase();
        String tipecran = tipecranField.getText().toLowerCase();
        String rezapa = rezapaField.getText().toLowerCase();
        String pret = pretField.getText();
        
        for (Smartwatch s : smartwatch) {
            boolean sePotriveste = true;
            if (!brand.isEmpty() && !s.getBrand().toLowerCase().contains(brand))
                continue;

            if (!culoare.isEmpty() && !s.getCuloare().toLowerCase().contains(culoare))
                continue;
            
            if (!tipecran.isEmpty() && !s.getTipEcran().toLowerCase().contains(tipecran))
                continue;

            if (!pret.isEmpty()) {
                try {
                    double pretValue = Double.parseDouble(pret);
                    if (s.getPret() >= pretValue) {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Introduceti un numar valid.");
                    return;
                }
            }
            if (!rezapa.isEmpty() && !s.getRezApa().toLowerCase().contains(rezapa))
                continue;
            
            if (sePotriveste) {
                sb.append(s.toString() + "\n");
            }
        }

        if (sb.length() == 0) {
            rezultat.setText("Nu exista.");
        } else {
            rezultat.setText(sb.toString());
        }
    }
}
