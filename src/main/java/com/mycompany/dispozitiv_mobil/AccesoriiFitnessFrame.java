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

public class AccesoriiFitnessFrame extends JFrame {
    protected JTextField brandField, tipAccesoriuField, culoareBrataraField, tipCataramaBrataraField, pretField, tipIncarcatorField, marimeEcranField, baterieField;
    protected JTextArea rezultat;
    protected JScrollPane scrollPanel;
    protected JButton filterButton, addButton, loadButton;
    protected JCheckBox cureaAjustabilaCheckBox;
    protected String locatie = "C:\\Users\\Roby\\Documents\\NetBeansProjects\\Dispozitiv-mobil\\src\\main\\java\\com\\mycompany\\dispozitiv_mobil\\accesoriifitness.txt";
    protected ArrayList<AccesoriiFitness> accesoriiFitness;

    public AccesoriiFitnessFrame(ArrayList<AccesoriiFitness> accesoriiFitness) {
        this.accesoriiFitness = accesoriiFitness;
        setTitle("Detalii accesoriu bratara fitness");
        setSize(1000,800);
        setLayout(new BorderLayout());

        JPanel panelFiltre = new JPanel();
        panelFiltre.setLayout(new GridLayout(0, 2, 5, 5));
        panelFiltre.setPreferredSize(new Dimension(350, 1080));

        rezultat = new JTextArea(20, 50);

        scrollPanel = new JScrollPane(rezultat);
        scrollPanel.setPreferredSize(new Dimension(1400, 1000));

        panelFiltre.add(new JLabel("Brand:"));
        panelFiltre.add(brandField = new JTextField(10));
        panelFiltre.add(new JLabel("Baterie:"));
        panelFiltre.add(baterieField = new JTextField());
        panelFiltre.add(new JLabel("Marime ecran:"));
        panelFiltre.add(marimeEcranField = new JTextField());
        panelFiltre.add(new JLabel("Tip Accesoriu:"));
        panelFiltre.add(tipAccesoriuField = new JTextField());
        panelFiltre.add(new JLabel("Culoare bratara:"));
        panelFiltre.add(culoareBrataraField = new JTextField());
        panelFiltre.add(new JLabel("Tip catarama bratara:"));
        panelFiltre.add(tipCataramaBrataraField = new JTextField());
        panelFiltre.add(new JLabel("Pret maxim:"));
        panelFiltre.add(pretField = new JTextField());
        panelFiltre.add(new JLabel("Tip incarcator:"));
        panelFiltre.add(tipIncarcatorField = new JTextField());
        panelFiltre.add(cureaAjustabilaCheckBox = new JCheckBox("Curea ajustabila"));
        
        filterButton = new JButton("Filtreaza");
        panelFiltre.add(filterButton);
        
        addButton = new JButton("Adauga accesoriu");
        panelFiltre.add(addButton);

        loadButton = new JButton("Incarca Datele");
        panelFiltre.add(loadButton);

        add(panelFiltre, BorderLayout.WEST);
        add(scrollPanel, BorderLayout.CENTER);

        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtreazaAccesoriiFitness();
            }
        });
        
        addButton.addActionListener((ActionEvent e) -> {
            addAccesoriuFitness();
        });

        loadButton.addActionListener((ActionEvent e) -> {
           loadAccesoriuFitnessFromFile();
        });
    }

    public void filtreazaAccesoriiFitness() {
        StringBuilder sb = new StringBuilder();
        String brand = brandField.getText().toLowerCase();
        String marimeEcran = marimeEcranField.getText();
        String baterie = baterieField.getText();
        String tipAccesoriu = tipAccesoriuField.getText().toLowerCase();
        String culoareBratara = culoareBrataraField.getText().toLowerCase();
        String tipCatarama = tipCataramaBrataraField.getText().toLowerCase();
        String pret = pretField.getText();
        String tipIncarcator = tipIncarcatorField.getText().toLowerCase();
        boolean cureaAjustabila = cureaAjustabilaCheckBox.isSelected();

        for (AccesoriiFitness af : accesoriiFitness) {
            boolean sePotriveste = true;
            if (!brand.isEmpty() && !af.getBrand().toLowerCase().contains(brand))
                continue;
            
            if (!baterie.isEmpty()) {
                try {
                    int baterieValue = Integer.parseInt(baterie);
                    if (af.getBaterie() < baterieValue) continue;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Introduceti un numar valid pentru Baterie!");
                    return;
                }
            }
            
            if (!marimeEcran.isEmpty()) {
                try {
                    double ecranValue = Double.parseDouble(marimeEcran);
                    if (af.getMarimeEcran() < ecranValue) continue;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Introduceti un numar valid pentru Marime Ecran!");
                    return;
                }
            }

            if (!tipAccesoriu.isEmpty() && !af.getTipAccesoriu().toLowerCase().contains(tipAccesoriu))
                continue;
            
            if (!culoareBratara.isEmpty() && !af.getCuloareBratara().toLowerCase().contains(culoareBratara))
                continue;

            if (!pret.isEmpty()) {
                try {
                    double pretValue = Double.parseDouble(pret);
                    if (af.getPret() >= pretValue) {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Introduceti un numar valid.");
                    return;
                }
            }
            if (!tipCatarama.isEmpty() && !af.getTipCataramaBratara().toLowerCase().contains(tipCatarama))
                continue;
            
            if (!tipIncarcator.isEmpty() && !af.getTipIncarcator().toLowerCase().contains(tipIncarcator))
                continue;
            
            if (cureaAjustabila && !af.isCureaAjustabila())
                continue;

            if (sePotriveste) {
                sb.append(af.toString() + "\n");
            }
        }

        if (sb.length() == 0) {
            rezultat.setText("Nu exista.");
        } else {
            rezultat.setText(sb.toString());
        }
    }
    
    private void addAccesoriuFitness() {
        try {
            String brand = brandField.getText();
            double marimeEcran = Double.parseDouble(marimeEcranField.getText());
            double pret = Double.parseDouble(pretField.getText());
            int baterie = Integer.parseInt(baterieField.getText());
            String tipAccesoriu = tipAccesoriuField.getText();
            String culoareBratara = culoareBrataraField.getText();
            String tipCataramaBratara = tipCataramaBrataraField.getText();
            boolean cureaAjustabila = cureaAjustabilaCheckBox.isSelected();
            String tipIncarcator = tipIncarcatorField.getText();
            

            AccesoriiFitness newAccesoriuFitness = new AccesoriiFitness(brand, marimeEcran, pret, baterie, tipAccesoriu, culoareBratara, tipCataramaBratara, cureaAjustabila, tipIncarcator);

            saveAccesoriuFitnessToFile(newAccesoriuFitness);

            clearFields();

            JOptionPane.showMessageDialog(this, "Fitness Band-ul a fost adaugat cu succes!");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Te rugam sa introduci valori valide!");
        }
    }
    
    private void saveAccesoriuFitnessToFile(AccesoriiFitness accesoriiFitness) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(locatie, true))) {
            writer.write(accesoriiFitness.getBrand() + "|"
                    + accesoriiFitness.getMarimeEcran() + "|"
                    + accesoriiFitness.getPret() + "|"
                    + accesoriiFitness.getBaterie() + "|"
                    + accesoriiFitness.getTipAccesoriu() + "|"
                    + accesoriiFitness.getCuloareBratara() + "|"
                    + accesoriiFitness.getTipCataramaBratara() + "|"
                    + accesoriiFitness.isCureaAjustabila() + "|"
                    + accesoriiFitness.getTipIncarcator());
            writer.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Eroare la salvarea datelor!");
        }
    }
    
    private void clearFields() {
        brandField.setText("");
        marimeEcranField.setText("");
        pretField.setText("");
        baterieField.setText("");
        tipAccesoriuField.setText("");
        culoareBrataraField.setText("");
        tipCataramaBrataraField.setText("");
        cureaAjustabilaCheckBox.setSelected(false);
        tipIncarcatorField.setText("");
    }
    
    public void loadAccesoriuFitnessFromFile() {
        accesoriiFitness.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(locatie))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                String brand = data[0];
                double marimeEcran = Double.parseDouble(data[1]);
                double pret = Double.parseDouble(data[2]);
                int baterie = Integer.parseInt(data[3]);
                String tipAccesoriu = data[4];
                String culoareBratara = data[5];
                String tipCataramaBratara = data[6];
                boolean cureaAjustabila = Boolean.parseBoolean(data[7]);
                String tipIncarcator = data[8];

                AccesoriiFitness AccesoriuFitness2 = new AccesoriiFitness(brand, marimeEcran, pret, baterie, tipAccesoriu, culoareBratara, tipCataramaBratara, cureaAjustabila, tipIncarcator);
                accesoriiFitness.add(AccesoriuFitness2);
            }
            JOptionPane.showMessageDialog(this, "Datele au fost incarcate cu succes!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Eroare la incarcarea datelor!");
        }
    } 
}