package com.mycompany.dispozitiv_mobil;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Telefon> telefoane = new ArrayList<>();

        telefoane.add(new Telefon("Samsung", 6.5, "Galaxy S21", 108, "Exynos 2100", 4500, 4000, "AMOLED"));
        telefoane.add(new Telefon("Apple", 6.1, "iPhone 13", 12, "A15 Bionic", 5000, 3227, "Super Retina XDR"));
        telefoane.add(new Telefon("Samsung", 6.7, "Galaxy S20 FE", 12, "Snapdragon 865", 3000, 4500, "AMOLED"));
        telefoane.add(new Telefon("Xiaomi", 6.67, "Redmi Note 11", 50, "Snapdragon 680", 1500, 5000, "AMOLED"));
        telefoane.add(new Telefon("Apple", 5.8, "iPhone SE", 12, "A13 Bionic", 2000, 1821, "Retina"));
        telefoane.add(new Telefon("Samsung", 6.4, "Galaxy A52", 64, "Snapdragon 720G", 2000, 4500, "Super AMOLED"));
        telefoane.add(new Telefon("Xiaomi", 6.81, "Mi 11", 108, "Snapdragon 888", 4000, 4600, "AMOLED"));
        telefoane.add(new Telefon("Huawei", 6.4, "P30", 40, "Kirin 980", 3000, 3650, "OLED"));
        telefoane.add(new Telefon("Huawei", 6.6, "Mate 30 Pro", 50, "Kirin 990", 5000, 4500, "OLED"));
        telefoane.add(new Telefon("Samsung", 6.8, "Galaxy Note 20 Ultra", 108, "Exynos 990", 6000, 4500, "Dynamic AMOLED"));
        for (Telefon telefon : telefoane) {
            if (!telefon.getBrand().equals("Samsung") && telefon.getPret() <=5000) {
                System.out.println(telefon);
            }
        }
        ArrayList<Tableta> tablete = new ArrayList<>();

        tablete.add(new Tableta("Samsung", 10.1, "Galaxy Tab S7", 13, "Snapdragon 865+", 3000, 8000, true, "AMOLED"));
        tablete.add(new Tableta("Apple", 10.5, "iPad Pro", 12, "A12Z Bionic", 5000, 9720, false, "Liquid Retina"));
        tablete.add(new Tableta("Huawei", 8.0, "MediaPad M5", 8, "Kirin 960", 2000, 5100, true, "IPS"));
        tablete.add(new Tableta("Samsung", 7.0, "Galaxy Tab A7", 8, "Snapdragon 662", 1500, 7040, false, "TFT"));
        tablete.add(new Tableta("Lenovo", 8.0, "Tab M10", 5, "Snapdragon 429", 1200, 4850, true, "IPS"));
        tablete.add(new Tableta("Xiaomi", 10.4, "Pad 5", 13, "Snapdragon 860", 2500, 8720, false, "LCD"));
        tablete.add(new Tableta("Apple", 11.0, "iPad Air", 12, "A14 Bionic", 3500, 7567, true, "Liquid Retina"));
        tablete.add(new Tableta("Samsung", 12.4, "Galaxy Tab S6", 13, "Snapdragon 855", 4500, 7040, true, "Super AMOLED"));
        tablete.add(new Tableta("Huawei", 10.1, "MediaPad T5", 8, "Kirin 659", 1800, 5100, false, "IPS"));
        tablete.add(new Tableta("Xiaomi", 10.1, "Mi Pad 4", 13, "Snapdragon 660", 2300, 6000, true, "IPS"));
        for (Tableta tableta : tablete) {
            if (tableta.getBrand().equals("Samsung") && tableta.getPret() <=5000) {
                System.out.println(tableta);
            }
        }
        ArrayList<FitnessBand> fitnessBand = new ArrayList<>();
        
        fitnessBand.add(new FitnessBand("Samsung", "Galaxy Fit 2", 1.5, 749, 500, "Pulsoximetru", "IP68", 10243, 500, true));
        fitnessBand.add(new FitnessBand("Apple", "Watch Series 7", 1.9, 1599, 600, "ECG", "WR50", 12000, 700, true));
        fitnessBand.add(new FitnessBand("Fitbit", "Charge 5", 1.4, 799, 450, "HR Sensor", "IP68", 9500, 550, true));
        fitnessBand.add(new FitnessBand("Huawei", "Band 7", 1.47, 249, 400, "Sleep Tracker", "5ATM", 8000, 400, true));
        fitnessBand.add(new FitnessBand("Xiaomi", "Mi Band 7", 1.62, 199, 350, "SpO2 Sensor", "5ATM", 7500, 300, true));
        fitnessBand.add(new FitnessBand("Garmin", "Vivosmart 5", 1.2, 849, 500, "HRV Sensor", "IP68", 6000, 450, true));
        fitnessBand.add(new FitnessBand("Samsung", "Galaxy Watch 5", 1.4, 1299, 590, "Temperature Sensor", "IP68", 10000, 600, true));
        fitnessBand.add(new FitnessBand("Amazfit", "Band 5", 1.1, 179, 350, "Oxygen Monitor", "5ATM", 5000, 250, true));
        fitnessBand.add(new FitnessBand("Polar", "Ignite 3", 1.6, 1099, 450, "Fitness Tracker", "IP67", 7000, 350, true));
        fitnessBand.add(new FitnessBand("Honor", "Band 6", 1.47, 199, 300, "Stress Monitor", "5ATM", 7800, 330, true));
        
        System.out.println("\nFitness Band de la Samsung cu rezistenta la apa IP68:");
        for (FitnessBand f : fitnessBand) {
            if (f.getBrand().equals("Samsung") && f.getRezistentaApa().equals("IP68")) {
                System.out.println(f);
            }
        }
        
        ArrayList<AccesoriiFitness> accesoriiFitness = new ArrayList<>();

        accesoriiFitness.add(new AccesoriiFitness("Samsung", 1.5, 600, 2000, "bratara fitness", "neagra", "magnetica", true, "magnetic"));
        accesoriiFitness.add(new AccesoriiFitness("Apple", 1.9, 1200, 2500, "bratara smartwatch", "alba", "clasica", true, "wireless"));
        accesoriiFitness.add(new AccesoriiFitness("Huawei", 1.4, 450, 1500, "bratara sport", "albastra", "cu catarama", false, "microUSB"));
        accesoriiFitness.add(new AccesoriiFitness("Xiaomi", 1.3, 300, 1200, "bratara Mi Band", "rosie", "elastică", true, "magnetic"));
        accesoriiFitness.add(new AccesoriiFitness("Fitbit", 1.6, 800, 1800, "bratara Charge", "verde", "clasica", true, "USB-C"));
        accesoriiFitness.add(new AccesoriiFitness("Garmin", 1.5, 950, 2000, "bratara fitness premium", "gri", "cu catarama", true, "wireless"));
        accesoriiFitness.add(new AccesoriiFitness("Polar", 1.2, 700, 1700, "bratara sport", "portocalie", "cu catarama", false, "microUSB"));
        accesoriiFitness.add(new AccesoriiFitness("Honor", 1.5, 350, 1300, "bratara Honor Band", "roz", "elastica", true, "magnetic"));
        accesoriiFitness.add(new AccesoriiFitness("Amazfit", 1.1, 400, 1400, "bratara sport simpla", "alba", "elastica", true, "USB-C"));
        accesoriiFitness.add(new AccesoriiFitness("Garmin", 1.3, 250, 1000, "bratara sport", "neagra", "cu catarama", false, "microUSB"));
        
        System.out.println("\nAccesoriu fitness de la Garmin de culoare neagra:");
        for (AccesoriiFitness af : accesoriiFitness) {
            if (af.getBrand().equals("Garmin") && af.getCuloareBratara().equals("neagra")) {
                System.out.println(af);
            }
        }
        
        ArrayList<Smartwatch> smartwatch = new ArrayList<>();

        smartwatch.add(new Smartwatch("Apple", 1.78, 3500, 300, "Negru", "OLED", "IP68"));
        smartwatch.add(new Smartwatch("Samsung", 1.4, 1500, 200, "Albastru", "AMOLED", "5ATM"));
        smartwatch.add(new Smartwatch("Garmin", 1.3, 700, 180, "Verde", "MIP", "10ATM"));
        smartwatch.add(new Smartwatch("Fossil", 1.5, 1200, 250, "Argintiu", "AMOLED", "IP67"));
        smartwatch.add(new Smartwatch("Huawei", 1.6, 1200, 350, "Negru", "AMOLED", "5ATM"));
        smartwatch.add(new Smartwatch("Fitbit", 1.45, 600, 150, "Roșu", "OLED", "IP68"));
        smartwatch.add(new Smartwatch("Amazfit", 1.39, 700, 180, "Albastru", "AMOLED", "5ATM"));
        smartwatch.add(new Smartwatch("Xiaomi", 1.4, 800, 200, "Gri", "AMOLED", "5ATM"));
        smartwatch.add(new Smartwatch("Withings", 1.2, 200, 150, "Alb", "OLED", "IP68"));
        smartwatch.add(new Smartwatch("Polar", 1.3, 550, 180, "Negru", "MIP", "5ATM"));
        
        System.out.println("\nSmartwatch cu pret mai mic de 1000 lei si ecran AMOLED:");
        for (Smartwatch s : smartwatch) {
            if (s.calcularePret() < 1000 && s.getTipEcran().equals("AMOLED")) {
                System.out.println(s);
            }
        }
        
        ArrayList<AccesoriiSmartwatch> accesoriiSmartwatch = new ArrayList<>();

        accesoriiSmartwatch.add(new AccesoriiSmartwatch("Apple", 1.78, 3500, 300, "Curea silicon", "Husa protectoare din silicon", "Magnetic"));
        accesoriiSmartwatch.add(new AccesoriiSmartwatch("Samsung", 1.4, 1500, 200, "Curea din piele", "Husa din plastic", "Qi Wireless"));
        accesoriiSmartwatch.add(new AccesoriiSmartwatch("Garmin", 1.3, 700, 180, "Curea din metal", "Husa de protectie din silicon", "USB-C"));
        accesoriiSmartwatch.add(new AccesoriiSmartwatch("Fossil", 1.5, 1200, 250, "Curea textila", "Husa din piele", "Wireless"));
        accesoriiSmartwatch.add(new AccesoriiSmartwatch("Huawei", 1.6, 1200, 350, "Curea sport", "Husa protectoare", "Magnetic"));
        accesoriiSmartwatch.add(new AccesoriiSmartwatch("Fitbit", 1.45, 600, 150, "Curea silicon", "Husa transparentă", "USB-A"));
        accesoriiSmartwatch.add(new AccesoriiSmartwatch("Amazfit", 1.39, 700, 180, "Curea din piele", "Husa de protectie din silicon", "Wireless"));
        accesoriiSmartwatch.add(new AccesoriiSmartwatch("Xiaomi", 1.4, 800, 200, "Curea sport", "Husa din silicon", "Magnetic"));
        accesoriiSmartwatch.add(new AccesoriiSmartwatch("Withings", 1.2, 200, 150, "Curea din piele", "Husa subtire din silicon", "USB-C"));
        accesoriiSmartwatch.add(new AccesoriiSmartwatch("Polar", 1.3, 550, 180, "Curea sport", "Husa protectoare din plastic", "Magnetic"));
        
        System.out.println("\nAccesorii Smartwatch cu husa din silicon si incarcare magnetica:");
        for (AccesoriiSmartwatch a : accesoriiSmartwatch) {
            if (a.getModelHusa().contains("silicon") && a.getTipIncarcator().equals("Magnetic")) {
                System.out.println(a);
            }
        }
        Interfata a=new Interfata(telefoane,tablete);
    }
}