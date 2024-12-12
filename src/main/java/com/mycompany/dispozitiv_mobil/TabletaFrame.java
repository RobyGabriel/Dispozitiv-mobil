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
        setTitle("Detalii Tableta");
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(245, 245, 245));

        JPanel panelFiltre = new JPanel();
        panelFiltre.setLayout(new GridLayout(10, 2, 10, 10));
        panelFiltre.setBackground(new Color(255, 255, 255, 240));
        panelFiltre.setPreferredSize(new Dimension(350, 1080));

        brandField = createTextField();
        modelField = createTextField();
        procesorField = createTextField();
        cameraField = createTextField();
        displayTipField = createTextField();
        ecranField = createTextField();
        pretField = createTextField();
        baterieField = createTextField();

        panelFiltre.add(createLabel("Brand:"));
        panelFiltre.add(brandField);
        panelFiltre.add(createLabel("Model:"));
        panelFiltre.add(modelField);
        panelFiltre.add(createLabel("Procesor:"));
        panelFiltre.add(procesorField);
        panelFiltre.add(createLabel("Camera (MP):"));
        panelFiltre.add(cameraField);
        panelFiltre.add(createLabel("Display Tip:"));
        panelFiltre.add(displayTipField);
        panelFiltre.add(createLabel("Minim marime ecran (inch):"));
        panelFiltre.add(ecranField);
        panelFiltre.add(createLabel("Pret maxim:"));
        panelFiltre.add(pretField);
        panelFiltre.add(createLabel("Baterie (mAh):"));
        panelFiltre.add(baterieField);

        tastaturaCheckBox = new JCheckBox("Are tastatura");
        tastaturaCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tastaturaCheckBox.setBackground(new Color(255, 255, 255, 240));
        panelFiltre.add(tastaturaCheckBox);

        filterButton = new JButton("Filtreaza");
        styleButton(filterButton);

        filterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                filterButton.setBackground(new Color(0, 102, 204));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                filterButton.setBackground(new Color(0, 123, 255));
            }
        });

        panelFiltre.add(filterButton);

        rezultat = new JTextArea(20, 50);
        rezultat.setEditable(false);
        scrollPanel = new JScrollPane(rezultat);
        scrollPanel.setPreferredSize(new Dimension(1400, 1000));
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(panelFiltre, BorderLayout.WEST);
        add(scrollPanel, BorderLayout.CENTER);

        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtreazaTablete();
            }
        });
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textField.setPreferredSize(new Dimension(150, 30));
        textField.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));
        textField.setBackground(Color.WHITE);
        textField.setForeground(Color.BLACK);
        return textField;
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 14));
        label.setForeground(new Color(50, 50, 50));
        return label;
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(0, 123, 255));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setPreferredSize(new Dimension(200, 40));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 200), 1));
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(true);
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
            if (!areTastatura)
                continue;

            sb.append(tableta.toString()).append("\n");
        }

        if (sb.length() == 0) {
            rezultat.setText("Nu exista.");
        } else {
            rezultat.setText(sb.toString());
        }
    }
}
