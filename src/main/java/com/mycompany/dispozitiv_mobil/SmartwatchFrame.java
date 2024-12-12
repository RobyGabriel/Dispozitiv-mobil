
package com.mycompany.dispozitiv_mobil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SmartwatchFrame extends JFrame{
    protected JTextField brandField, culoareField, tipecranField, rezapaField, pretField;
    protected JTextArea rezultat;
    protected JScrollPane scrollPanel;
    protected JButton filterButton;
    protected ArrayList<Smartwatch> smartwatch;

    public SmartwatchFrame(ArrayList<Smartwatch> smartwatch) {
        this.smartwatch = smartwatch;
        setTitle("Detalii Smartwatch");
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
        panelFiltre.add(new JLabel("Culoare:"));
        panelFiltre.add(culoareField = new JTextField());
        panelFiltre.add(new JLabel("Tipul Ecranului:"));
        panelFiltre.add(tipecranField = new JTextField());
        panelFiltre.add(new JLabel("Rezistenta la apa:"));
        panelFiltre.add(rezapaField = new JTextField());
        panelFiltre.add(new JLabel("Pret:"));
        panelFiltre.add(pretField = new JTextField());
        panelFiltre.add(filterButton);

        add(panelFiltre, BorderLayout.WEST);
        add(scrollPanel, BorderLayout.CENTER);

        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtreazaSmartwatch();
            }
        });
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


