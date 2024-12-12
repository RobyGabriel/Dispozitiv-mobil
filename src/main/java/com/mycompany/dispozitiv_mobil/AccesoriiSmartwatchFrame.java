package com.mycompany.dispozitiv_mobil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AccesoriiSmartwatchFrame extends JFrame {

    protected JTextField brandField, tipAccesoriiField, modelHusaField, pretField, tipIncarcatorField;
    protected JTextArea rezultat;
    protected JScrollPane scrollPanel;
    protected JButton filterButton;

    protected ArrayList<AccesoriiSmartwatch> accesoriiSmartwatch;

    public AccesoriiSmartwatchFrame(ArrayList<AccesoriiSmartwatch> accesoriiSmartwatch) {
        this.accesoriiSmartwatch = accesoriiSmartwatch;
        setTitle("Detalii accesorii Smartwatch");
        setSize(1920, 1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(1000, 800);
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
        panelFiltre.add(new JLabel("Tip Accesorii:"));
        panelFiltre.add(tipAccesoriiField = new JTextField());
        panelFiltre.add(new JLabel("Model Husa:"));
        panelFiltre.add(modelHusaField = new JTextField());
        panelFiltre.add(new JLabel("Pret:"));
        panelFiltre.add(pretField = new JTextField());
        panelFiltre.add(new JLabel("Tip incarcator:"));
        panelFiltre.add(tipIncarcatorField = new JTextField());
        panelFiltre.add(filterButton);
        

        add(panelFiltre, BorderLayout.WEST);
        add(scrollPanel, BorderLayout.CENTER);

        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtreazaAccesoriiSmartwatch();
            }
        });
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
