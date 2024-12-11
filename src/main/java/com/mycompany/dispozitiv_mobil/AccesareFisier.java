package com.mycompany.dispozitiv_mobil;
import java.io.*;
import java.util.ArrayList;

public class AccesareFisier {

    public static void saveToFile(String filename, ArrayList<Telefon> telefoane) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Telefon telefon : telefoane) {
                writer.write("Telefon: " + telefon.getBrand() + "|" +
                        telefon.getMarimeEcran() + "|" +
                        telefon.getModel() + "|" +
                        telefon.getCamera() + "|" +
                        telefon.getProcesor() + "|" +
                        telefon.getPret() + "|" +
                        telefon.getBaterie() + "|" +
                        telefon.getDisplayTip());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Telefon> loadFromFile(String filename) {
        ArrayList<Telefon> telefoane = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Telefon: ")) {
                    String telefonData = line.substring(9);
                    String[] parts = telefonData.split("\\|");
                    
                    if (parts.length == 8) {
                        String brand = parts[0];
                        double marimeEcran = Double.parseDouble(parts[1]);
                        String model = parts[2];
                        int camera = Integer.parseInt(parts[3]);
                        String procesor = parts[4];
                        double pret = Double.parseDouble(parts[5]);
                        int baterie = Integer.parseInt(parts[6]);
                        String displayTip = parts[7];
                        
                        Telefon telefon = new Telefon(brand, marimeEcran, model, camera, procesor, pret, baterie, displayTip);
                        telefoane.add(telefon);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return telefoane;
    }
}