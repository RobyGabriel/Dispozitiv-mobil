package com.mycompany.dispozitiv_mobil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TelefonFrame extends JFrame {
    private JTextField brandField, modelField, procesorField, cameraField, displayTipField, ecranField, pretField, baterieField;
    private JTextArea resultTextArea;
    private JScrollPane scrollPane;
    private JButton filterButton;

    private ArrayList<Telefon> telefoane;

    public TelefonFrame(ArrayList<Telefon> telefoane) {
        this.telefoane = telefoane;
        setTitle("Telefon Details");
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel filtersPanel = new JPanel();
        filtersPanel.setLayout(new GridLayout(9, 2, 10, 10));
        filtersPanel.setPreferredSize(new Dimension(350, 1080));

        brandField = new JTextField();
        brandField.setPreferredSize(new Dimension(50, 20));

        modelField = new JTextField();
        modelField.setPreferredSize(new Dimension(50, 20));

        procesorField = new JTextField();
        procesorField.setPreferredSize(new Dimension(50, 20));

        cameraField = new JTextField();
        cameraField.setPreferredSize(new Dimension(50, 20));

        displayTipField = new JTextField();
        displayTipField.setPreferredSize(new Dimension(50, 20));

        ecranField = new JTextField();
        ecranField.setPreferredSize(new Dimension(50, 20));

        pretField = new JTextField();
        pretField.setPreferredSize(new Dimension(50, 20));

        baterieField = new JTextField();
        baterieField.setPreferredSize(new Dimension(50, 20));

        filterButton = new JButton("Filtrează");

        resultTextArea = new JTextArea(20, 50);

        scrollPane = new JScrollPane(resultTextArea);
        scrollPane.setPreferredSize(new Dimension(1400, 1000));

        filtersPanel.add(new JLabel("Brand:"));
        filtersPanel.add(brandField);
        filtersPanel.add(new JLabel("Model:"));
        filtersPanel.add(modelField);
        filtersPanel.add(new JLabel("Procesor:"));
        filtersPanel.add(procesorField);
        filtersPanel.add(new JLabel("Camera (MP):"));
        filtersPanel.add(cameraField);
        filtersPanel.add(new JLabel("Display Tip:"));
        filtersPanel.add(displayTipField);
        filtersPanel.add(new JLabel("Ecran Size (inches):"));
        filtersPanel.add(ecranField);
        filtersPanel.add(new JLabel("Pret maxim:"));
        filtersPanel.add(pretField);
        filtersPanel.add(new JLabel("Baterie (mAh):"));
        filtersPanel.add(baterieField);
        filtersPanel.add(filterButton);

        add(filtersPanel, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);

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
        String cameraText = cameraField.getText();
        String displayTip = displayTipField.getText().toLowerCase();
        String ecranText = ecranField.getText();
        String pretText = pretField.getText();
        String baterieText = baterieField.getText();

        for (Telefon telefon : telefoane) {
            boolean sePotriveste  = true;
            if (!brand.isEmpty() && !telefon.getBrand().toLowerCase().contains(brand)) sePotriveste  = false;
            if (!model.isEmpty() && !telefon.getModel().toLowerCase().contains(model)) sePotriveste  = false;
            if (!procesor.isEmpty() && !telefon.getProcesor().toLowerCase().contains(procesor)) sePotriveste  = false;
            if (!cameraText.isEmpty() && telefon.getCamera() != Integer.parseInt(cameraText)) sePotriveste  = false;
            if (!displayTip.isEmpty() && !telefon.getdisplayTip().toLowerCase().contains(displayTip)) sePotriveste  = false;
            if (!ecranText.isEmpty() && telefon.getMarimeEcran() != Double.parseDouble(ecranText)) sePotriveste  = false;
            if (!pretText.isEmpty() && telefon.getPret() >= Double.parseDouble(pretText)) sePotriveste  = false;
            if (!baterieText.isEmpty() && telefon.getBaterie() != Integer.parseInt(baterieText)) sePotriveste  = false;

            if (sePotriveste ) {
                sb.append(telefon.toString()).append("\n");
            }
        }

        if (sb.length() == 0) {
            resultTextArea.setText("Nu s-au găsit telefoane care să corespundă.");
        } else {
            resultTextArea.setText(sb.toString());
        }
    }
}
