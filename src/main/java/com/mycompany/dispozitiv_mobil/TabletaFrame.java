package com.mycompany.dispozitiv_mobil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TabletaFrame extends JFrame {
    private JTextField brandField, modelField, procesorField, cameraField, displayTipField, ecranField, pretField, baterieField;
    private JTextArea resultTextArea;
    private JScrollPane scrollPane;
    private JButton filterButton;
    private JCheckBox tastaturaCheckBox;

    private ArrayList<Tableta> tablete;

    public TabletaFrame(ArrayList<Tableta> tablete) {
        this.tablete = tablete;
        setTitle("Tableta Details");

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panou pentru filtre
        JPanel filtersPanel = new JPanel();
        filtersPanel.setLayout(new GridLayout(10, 2, 10, 10)); // am crescut numărul de rânduri pentru a adăuga un nou câmp
        filtersPanel.setPreferredSize(new Dimension(350, 1080));

        brandField = new JTextField();
        modelField = new JTextField();
        procesorField = new JTextField();
        cameraField = new JTextField();
        displayTipField = new JTextField();
        ecranField = new JTextField();
        pretField = new JTextField();
        baterieField = new JTextField();
        tastaturaCheckBox = new JCheckBox("Are tastatură");

        brandField.setPreferredSize(new Dimension(50, 20));
        modelField.setPreferredSize(new Dimension(50, 20));
        procesorField.setPreferredSize(new Dimension(50, 20));
        cameraField.setPreferredSize(new Dimension(50, 20));
        displayTipField.setPreferredSize(new Dimension(50, 20));
        ecranField.setPreferredSize(new Dimension(50, 20));
        pretField.setPreferredSize(new Dimension(50, 20));
        baterieField.setPreferredSize(new Dimension(50, 20));

        filterButton = new JButton("Filtrează");

        resultTextArea = new JTextArea(20, 50);
        scrollPane = new JScrollPane(resultTextArea);
        scrollPane.setPreferredSize(new Dimension(1400, 1000));

        // Adăugăm componentele în panoul de filtre
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
        filtersPanel.add(new JLabel("Marime minima ecran(inch):"));
        filtersPanel.add(ecranField);
        filtersPanel.add(new JLabel("Pret maxim:"));
        filtersPanel.add(pretField);
        filtersPanel.add(new JLabel("Baterie (mAh):"));
        filtersPanel.add(baterieField);
        filtersPanel.add(tastaturaCheckBox);  // Adăugăm filtrul pentru tastatură
        filtersPanel.add(filterButton);

        add(filtersPanel, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);

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
        String cameraText = cameraField.getText();
        String displayTip = displayTipField.getText().toLowerCase();
        String ecranText = ecranField.getText();
        String pretText = pretField.getText();
        String baterieText = baterieField.getText();
        boolean areTastatura = tastaturaCheckBox.isSelected(); // Verificăm dacă checkbox-ul pentru tastatură este bifat

        for (Tableta tableta : tablete) {
            boolean sePotriveste = true;
            if (!brand.isEmpty() && !tableta.getBrand().toLowerCase().contains(brand)) sePotriveste = false;
            if (!model.isEmpty() && !tableta.getModel().toLowerCase().contains(model)) sePotriveste = false;
            if (!procesor.isEmpty() && !tableta.getProcesor().toLowerCase().contains(procesor)) sePotriveste = false;
            if (!cameraText.isEmpty() && tableta.getCamera() != Integer.parseInt(cameraText)) sePotriveste = false;
            if (!displayTip.isEmpty() && !tableta.getDisplayTip().toLowerCase().contains(displayTip)) sePotriveste = false;
            if (!ecranText.isEmpty() && tableta.getMarimeEcran() <= Double.parseDouble(ecranText)) sePotriveste = false;
            if (!pretText.isEmpty() && tableta.getPret() >= Double.parseDouble(pretText)) sePotriveste = false;
            if (!baterieText.isEmpty() && tableta.getBaterie() != Integer.parseInt(baterieText)) sePotriveste = false;
            if (areTastatura && !tableta.isTastatura()) sePotriveste = false;  // Filtrăm și după tastatură

            if (sePotriveste) {
                sb.append(tableta.toString()).append("\n");
            }
        }

        if (sb.length() == 0) {
            resultTextArea.setText("Nu s-au găsit tablete care să corespundă.");
        } else {
            resultTextArea.setText(sb.toString());
        }
    }
}
