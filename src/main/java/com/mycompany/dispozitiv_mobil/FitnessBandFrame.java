package com.mycompany.dispozitiv_mobil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FitnessBandFrame extends JFrame {
    protected JTextField brandField, modelField, senzorField, rezistentaApaField, pretField, marimeEcranField, baterieField;
    protected JTextArea rezultat;
    protected JScrollPane scrollPanel;
    protected JButton filterButton, addButton, loadButton;
    protected JCheckBox monitorizareSomnCheckBox;
    protected String locatie = "C:\\Users\\Roby\\Documents\\NetBeansProjects\\Dispozitiv-mobil\\src\\main\\java\\com\\mycompany\\dispozitiv_mobil\\fitnessband.txt";
    protected ArrayList<FitnessBand> fitnessBand;

    public FitnessBandFrame(ArrayList<FitnessBand> fitnessBand) {
        this.fitnessBand = fitnessBand;
        setTitle("Detalii fitness band");
        setSize(1000,800);
        setLayout(new BorderLayout());

        JPanel panelFiltre = new JPanel();
        panelFiltre.setLayout(new GridLayout(9, 2, 10, 10));
        panelFiltre.setPreferredSize(new Dimension(350, 1080));


        rezultat = new JTextArea(20, 50);

        scrollPanel = new JScrollPane(rezultat);
        scrollPanel.setPreferredSize(new Dimension(1400, 1000));

        panelFiltre.add(new JLabel("Brand:"));
        panelFiltre.add(brandField = new JTextField(10));
        panelFiltre.add(new JLabel("Model:"));
        panelFiltre.add(modelField = new JTextField());
        panelFiltre.add(new JLabel("Marime ecran:"));
        panelFiltre.add(marimeEcranField = new JTextField());
        panelFiltre.add(new JLabel("Baterie:"));
        panelFiltre.add(baterieField = new JTextField());
        panelFiltre.add(new JLabel("Senzor:"));
        panelFiltre.add(senzorField = new JTextField());
        panelFiltre.add(new JLabel("Rezistenta apa:"));
        panelFiltre.add(rezistentaApaField = new JTextField());
        panelFiltre.add(new JLabel("Pret maxim:"));
        panelFiltre.add(pretField = new JTextField());
        panelFiltre.add(monitorizareSomnCheckBox = new JCheckBox("Monitorizare somn"));
        
        filterButton = new JButton("Filtreaza");
        panelFiltre.add(filterButton);
        
        addButton = new JButton("Adauga Fitness Band");
        panelFiltre.add(addButton);

        loadButton = new JButton("Incarca Datele");
        panelFiltre.add(loadButton);

        add(panelFiltre, BorderLayout.WEST);
        add(scrollPanel, BorderLayout.CENTER);

        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtreazaFitnessBand();
            }
        });
        
        addButton.addActionListener((ActionEvent e) -> {
            addFitnessBand();
        });

        loadButton.addActionListener((ActionEvent e) -> {
            loadFitnessBandFromFile();
        });
    }

    public void filtreazaFitnessBand() {
        StringBuilder sb = new StringBuilder();
        String brand = brandField.getText().toLowerCase();
        String model = modelField.getText().toLowerCase();
        String baterie = baterieField.getText();
        String marimeEcran = marimeEcranField.getText();
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
            
            if (!baterie.isEmpty()) {
                try {
                    int baterieValue = Integer.parseInt(baterie);
                    if (fb.getBaterie() < baterieValue) continue;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Introduceti un numar valid pentru Baterie!");
                    return;
                }
            }
            
            if (!marimeEcran.isEmpty()) {
                try {
                    double ecranValue = Double.parseDouble(marimeEcran);
                    if (fb.getMarimeEcran() < ecranValue) continue;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Introduceti un numar valid pentru Marime Ecran!");
                    return;
                }
            }
            
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
    
    private void addFitnessBand() {
        try {
            String brand = brandField.getText();
            String model = modelField.getText();
            double marimeEcran = Double.parseDouble(marimeEcranField.getText());
            String senzor = senzorField.getText();
            int baterie = Integer.parseInt(baterieField.getText());
            String rezistentaApa = rezistentaApaField.getText();
            boolean monitorizareSomn = monitorizareSomnCheckBox.isSelected();
            double pret = Double.parseDouble(pretField.getText());

            FitnessBand newFitnessBand = new FitnessBand(brand, model, marimeEcran, pret, baterie, senzor, rezistentaApa, monitorizareSomn);

            saveFitnessBandToFile(newFitnessBand);

            clearFields();

            JOptionPane.showMessageDialog(this, "Fitness Band-ul a fost adaugat cu succes!");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Te rugam sa introduci valori valide!");
        }
    }
    
    private void saveFitnessBandToFile(FitnessBand fitnessBand) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(locatie, true))) {
            writer.write(fitnessBand.getBrand() + "|"
                    + fitnessBand.getModel() + "|"
                    + fitnessBand.getMarimeEcran() + "|"
                    + fitnessBand.getPret() + "|"
                    + fitnessBand.getBaterie() + "|"
                    + fitnessBand.getSenzor() + "|"
                    + fitnessBand.getRezistentaApa() + "|"
                    + fitnessBand.getMonitorizareSomn());
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Eroare la salvarea datelor!");
        }
    }
    
    private void clearFields() {
        brandField.setText("");
        modelField.setText("");
        marimeEcranField.setText("");
        pretField.setText("");
        baterieField.setText("");
        senzorField.setText("");
        rezistentaApaField.setText("");
        monitorizareSomnCheckBox.setSelected(false);
    }
    
    public void loadFitnessBandFromFile() {
        fitnessBand.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(locatie))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                String brand = data[0];
                String model = data[1];
                double marimeEcran = Double.parseDouble(data[2]);
                double pret = Double.parseDouble(data[3]);
                int baterie = Integer.parseInt(data[4]);
                String senzor = data[5];
                String rezistentaApa = data[6];
                boolean monitorizareSomn = Boolean.parseBoolean(data[7]);
                

                FitnessBand fitnessBand2 = new FitnessBand(brand, model, marimeEcran, pret, baterie, senzor, rezistentaApa, monitorizareSomn);
                fitnessBand.add(fitnessBand2);
            }
            JOptionPane.showMessageDialog(this, "Datele au fost incarcate cu succes!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Eroare la incarcarea datelor!");
        }
    }
}