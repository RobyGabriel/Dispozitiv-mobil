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
    protected JButton filterButton, saveButton, loadButton;

    protected ArrayList<Telefon> telefoane;

    public TelefonFrame(ArrayList<Telefon> telefoane) {
        this.telefoane = telefoane;
        setTitle("Detalii Telefon");
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

        filterButton = new JButton("Filtreaza");
        styleButton(filterButton);

        saveButton = new JButton("Salveaza Datele");
        styleButton(saveButton);
        
        loadButton = new JButton("Incarca Datele");
        styleButton(loadButton);

        filterButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                filterButton.setBackground(new Color(0, 102, 204));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                filterButton.setBackground(new Color(0, 123, 255));
            }
        });

        panelFiltre.add(filterButton);
        panelFiltre.add(saveButton);
        panelFiltre.add(loadButton);

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
                filtreazaTelefoane();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveTelefoaneToFile();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadTelefoaneFromFile();
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

    // Method to filter phones based on user input
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
            if (!brand.isEmpty() && !telefon.getBrand().toLowerCase().contains(brand))
                continue;
            if (!model.isEmpty() && !telefon.getModel().toLowerCase().contains(model))
                continue;
            if (!procesor.isEmpty() && !telefon.getProcesor().toLowerCase().contains(procesor))
                continue;
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
            if (!displayTip.isEmpty() && !telefon.getDisplayTip().toLowerCase().contains(displayTip))
                continue;
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

    private void saveTelefoaneToFile() {
        AccesareFisier.saveToFile("C:\\Users\\ichim\\Desktop\\telefoane.txt", telefoane);
        JOptionPane.showMessageDialog(this, "Datele au fost salvate cu succes!");
    }

    private void loadTelefoaneFromFile() {
        telefoane = AccesareFisier.loadFromFile("C:\\Users\\ichim\\Desktop\\telefoane.txt");
        StringBuilder sb = new StringBuilder();
        for (Telefon telefon : telefoane) {
            sb.append(telefon.toString()).append("\n");
        }
        rezultat.setText(sb.toString());
        JOptionPane.showMessageDialog(this, "Datele au fost incarcate!");
    }
}
