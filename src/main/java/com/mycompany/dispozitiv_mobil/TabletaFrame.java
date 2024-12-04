package com.mycompany.dispozitiv_mobil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TabletaFrame extends JFrame {
    protected JTextField brandField, modelField, procesorField, cameraField, displayTipField, ecranField, pretField, baterieField;
    protected JTextArea rezultat;
    protected JScrollPane scrollPanel;
    protected JButton filterButton;
    protected JCheckBox tastaturaCheckBox;
    
    protected ArrayList<Tableta> tablete;

    public TabletaFrame(ArrayList<Tableta> tablete) {
        this.tablete = tablete;
        setTitle("Detalii telefon");
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
        panelFiltre.add(new JLabel("Procesor:"));
        panelFiltre.add(procesorField = new JTextField());
        panelFiltre.add(new JLabel("Camera (MP):"));
        panelFiltre.add(cameraField = new JTextField());
        panelFiltre.add(new JLabel("Display Tip:"));
        panelFiltre.add(displayTipField = new JTextField());
        panelFiltre.add(new JLabel("Minim marime ecran(inch):"));
        panelFiltre.add(ecranField = new JTextField());
        panelFiltre.add(new JLabel("Pret maxim:"));
        panelFiltre.add(pretField = new JTextField());
        panelFiltre.add(new JLabel("Baterie (mAh):"));
        panelFiltre.add(baterieField = new JTextField());
        panelFiltre.add(tastaturaCheckBox = new JCheckBox("Are tastatura"));
        panelFiltre.add(filterButton);

        add(panelFiltre, BorderLayout.WEST);
        add(scrollPanel, BorderLayout.CENTER);

        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtreazaTablete();
            }
        });
    }

    public void filtreazaTablete() {
        StringBuilder sb = new StringBuilder();
        String brand = brandField.getText().toLowerCase();
        String model = modelField.getText().toLowerCase();
        String procesor = procesorField.getText().toLowerCase();
        String camera = cameraField.getText();
        String displayTip = displayTipField.getText().toLowerCase();
        String ecran = ecranField.getText();
        String pret = pretField.getText();
        String baterie = baterieField.getText();
        boolean areTastatura = tastaturaCheckBox.isSelected();

        for (Tableta tableta : tablete) {
            boolean sePotriveste = true;
            if (!brand.isEmpty() && !tableta.getBrand().toLowerCase().contains(brand))
                continue;

            if (!model.isEmpty() && !tableta.getModel().toLowerCase().contains(model))
                continue;

            if (!procesor.isEmpty() && !tableta.getProcesor().toLowerCase().contains(procesor))
                continue;

            if (!camera.isEmpty()) {
                try {
                    int cameraValue = Integer.parseInt(camera);
                    if (tableta.getCamera() != cameraValue) {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Introduce un numar valid.");
                    return;
                }
            }

            if (!ecran.isEmpty()) {
                try {
                    double ecranValue = Double.parseDouble(ecran);
                    if (tableta.getMarimeEcran() <= ecranValue) {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Introduce un numar valid.");
                    return;
                }
            }

            if (!pret.isEmpty()) {
                try {
                    double pretValue = Double.parseDouble(pret);
                    if (tableta.getPret() >= pretValue) {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Introduce un numar valid.");
                    return;
                }
            }
            if (!displayTip.isEmpty() && !tableta.getDisplayTip().toLowerCase().contains(displayTip))
                continue;
            
            if (!baterie.isEmpty()) {
                try {
                    int baterieValue = Integer.parseInt(baterie);
                    if (tableta.getBaterie() != baterieValue) {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Introduce un numar valid.");
                    return;
                }
            }
            if (areTastatura && !tableta.areTastatura())
                continue;

            if (sePotriveste) {
                sb.append(tableta.toString() + "\n");
            }
        }

        if (sb.length() == 0) {
            rezultat.setText("Nu exista.");
        } else {
            rezultat.setText(sb.toString());
        }
    }
}
