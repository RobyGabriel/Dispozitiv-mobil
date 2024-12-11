package com.mycompany.dispozitiv_mobil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelefonFrame extends JFrame {

    protected JTextField brandField, modelField, procesorField, cameraField, displayTipField, ecranField, pretField, baterieField;
    protected JTextArea rezultat;
    protected JScrollPane scrollPanel;
    protected JButton filterButton;
    protected ArrayList<Telefon> telefoane;

    public TelefonFrame(ArrayList<Telefon> telefoane) {
        this.telefoane = telefoane;
        setTitle("Detalii telefon");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        JPanel panelFiltre = new JPanel();
        panelFiltre.setLayout(new GridLayout(9, 2, 10, 10));
        panelFiltre.setPreferredSize(new Dimension(350, 1080));

        filterButton = new JButton("Filtreaza");

        rezultat = new JTextArea(1, 1);

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
        panelFiltre.add(filterButton);

        add(panelFiltre, BorderLayout.WEST);
        add(scrollPanel, BorderLayout.CENTER);

        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtreazaTelefoane();
            }
        });
    }

    public void filtreazaTelefoane() {
        StringBuilder sb = new StringBuilder();
        String brand = brandField.getText().toLowerCase();
        String model = modelField.getText().toLowerCase();
        String procesor = procesorField.getText().toLowerCase();
        String camera = cameraField.getText();
        String displayTip = displayTipField.getText().toLowerCase();
        String ecran = ecranField.getText();
        String pret = pretField.getText();
        String baterie = baterieField.getText();
        for (Telefon telefon : telefoane) {

            if (!brand.isEmpty() && !telefon.getBrand().toLowerCase().contains(brand)) {
                continue;
            }

            if (!model.isEmpty() && !telefon.getModel().toLowerCase().contains(model)) {
                continue;
            }

            if (!procesor.isEmpty() && !telefon.getProcesor().toLowerCase().contains(procesor)) {
                continue;
            }

            if (!camera.isEmpty()) {
                try {
                    int cameraValue = Integer.parseInt(camera);
                    if (telefon.getCamera() != cameraValue) {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Introduce un numar valid.");
                    return;
                }
            }
            if (!displayTip.isEmpty() && !telefon.getdisplayTip().toLowerCase().contains(displayTip))
            continue;
            
            if (!ecran.isEmpty()) {
                try {
                    double ecranValue = Double.parseDouble(ecran);
                    if (telefon.getMarimeEcran() <= ecranValue) {
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
                    if (telefon.getPret() >= pretValue) {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Introduce un numar valid.");
                    return;
                }
            }
            if (!baterie.isEmpty()) {
                try {
                    int baterieValue = Integer.parseInt(baterie);
                    if (telefon.getBaterie() != baterieValue) {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Introduce un numar valid.");
                    return;
                }
            }

            sb.append(telefon.toString()).append("\n");
        }
        if (sb.length() == 0) {
            rezultat.setText("Nu exista.");
        } else {
            rezultat.setText(sb.toString());
        }
    }
}
