package com.mycompany.dispozitiv_mobil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AccesoriiFitnessFrame extends JFrame {
    protected JTextField brandField, tipAccesoriuField, culoareBrataraField, tipCataramaBrataraField, pretField, tipIncarcatorField;
    protected JTextArea rezultat;
    protected JScrollPane scrollPanel;
    protected JButton filterButton;
    protected JCheckBox cureaAjustabilaCheckBox;
    
    protected ArrayList<AccesoriiFitness> accesoriiFitness;

    public AccesoriiFitnessFrame(ArrayList<AccesoriiFitness> accesoriiFitness) {
        this.accesoriiFitness = accesoriiFitness;
        setTitle("Detalii accesoriu bratara fitness");
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
        panelFiltre.add(filterButton);

        add(panelFiltre, BorderLayout.WEST);
        add(scrollPanel, BorderLayout.CENTER);

        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtreazaAccesoriiFitness();
            }
        });
    }

    public void filtreazaAccesoriiFitness() {
        StringBuilder sb = new StringBuilder();
        String brand = brandField.getText().toLowerCase();
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
}