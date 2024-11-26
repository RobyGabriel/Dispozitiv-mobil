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
        
        ArrayList<fitness_band> fitnessBand = new ArrayList<>();

        fitnessBand.add(new fitness_band("Samsung", "Galaxy Fit 2", 1.5, 749, 500, "Pulsoximetru", "IP68", 10243, 500, true));
        fitnessBand.add(new fitness_band("Apple", "Watch Series 7", 1.9, 1599, 600, "ECG", "WR50", 12000, 700, true));
        fitnessBand.add(new fitness_band("Fitbit", "Charge 5", 1.4, 799, 450, "HR Sensor", "IP68", 9500, 550, true));
        fitnessBand.add(new fitness_band("Huawei", "Band 7", 1.47, 249, 400, "Sleep Tracker", "5ATM", 8000, 400, true));
        fitnessBand.add(new fitness_band("Xiaomi", "Mi Band 7", 1.62, 199, 350, "SpO2 Sensor", "5ATM", 7500, 300, true));
        fitnessBand.add(new fitness_band("Garmin", "Vivosmart 5", 1.2, 849, 500, "HRV Sensor", "IP68", 6000, 450, true));
        fitnessBand.add(new fitness_band("Samsung", "Galaxy Watch 5", 1.4, 1299, 590, "Temperature Sensor", "IP68", 10000, 600, true));
        fitnessBand.add(new fitness_band("Amazfit", "Band 5", 1.1, 179, 350, "Oxygen Monitor", "5ATM", 5000, 250, true));
        fitnessBand.add(new fitness_band("Polar", "Ignite 3", 1.6, 1099, 450, "Fitness Tracker", "IP67", 7000, 350, true));
        fitnessBand.add(new fitness_band("Honor", "Band 6", 1.47, 199, 300, "Stress Monitor", "5ATM", 7800, 330, true));
        
        ArrayList<accesorii_fitness> accesoriiFitness = new ArrayList<>();

        accesoriiFitness.add(new accesorii_fitness("Samsung", 1.5, 600, 2000, "brățară fitness", "neagră", "magnetică", true, "magnetic"));
        accesoriiFitness.add(new accesorii_fitness("Apple", 1.9, 1200, 2500, "brățară smartwatch", "albă", "clasică", true, "wireless"));
        accesoriiFitness.add(new accesorii_fitness("Huawei", 1.4, 450, 1500, "brățară sport", "albastră", "cu cataramă", false, "microUSB"));
        accesoriiFitness.add(new accesorii_fitness("Xiaomi", 1.3, 300, 1200, "brățară Mi Band", "roșie", "elastică", true, "magnetic"));
        accesoriiFitness.add(new accesorii_fitness("Fitbit", 1.6, 800, 1800, "brățară Charge", "verde", "clasică", true, "USB-C"));
        accesoriiFitness.add(new accesorii_fitness("Garmin", 1.5, 950, 2000, "brățară fitness premium", "gri", "cu cataramă", true, "wireless"));
        accesoriiFitness.add(new accesorii_fitness("Polar", 1.2, 700, 1700, "brățară sport", "portocalie", "cu cataramă", false, "microUSB"));
        accesoriiFitness.add(new accesorii_fitness("Honor", 1.5, 350, 1300, "brățară Honor Band", "roz", "elastică", true, "magnetic"));
        accesoriiFitness.add(new accesorii_fitness("Amazfit", 1.1, 400, 1400, "brățară sport simplă", "albă", "elastică", true, "USB-C"));
        accesoriiFitness.add(new accesorii_fitness("Realme", 1.3, 250, 1000, "brățară sport", "neagră", "cu cataramă", false, "microUSB"));
        
        ArrayList<smartwatch> smartwatch = new ArrayList<>();

        smartwatch.add(new smartwatch("Apple", 1.78, 3500, 300, "Negru", "OLED", "IP68"));
        smartwatch.add(new smartwatch("Samsung", 1.4, 1500, 200, "Albastru", "AMOLED", "5ATM"));
        smartwatch.add(new smartwatch("Garmin", 1.3, 700, 180, "Verde", "MIP", "10ATM"));
        smartwatch.add(new smartwatch("Fossil", 1.5, 1200, 250, "Argintiu", "AMOLED", "IP67"));
        smartwatch.add(new smartwatch("Huawei", 1.6, 1200, 350, "Negru", "AMOLED", "5ATM"));
        smartwatch.add(new smartwatch("Fitbit", 1.45, 600, 150, "Roșu", "OLED", "IP68"));
        smartwatch.add(new smartwatch("Amazfit", 1.39, 700, 180, "Albastru", "AMOLED", "5ATM"));
        smartwatch.add(new smartwatch("Xiaomi", 1.4, 800, 200, "Gri", "AMOLED", "5ATM"));
        smartwatch.add(new smartwatch("Withings", 1.2, 200, 150, "Alb", "OLED", "IP68"));
        smartwatch.add(new smartwatch("Polar", 1.3, 550, 180, "Negru", "MIP", "5ATM"));
        
        ArrayList<acsmartwatch> accesoriiSmartwatch = new ArrayList<>();

        accesoriiSmartwatch.add(new acsmartwatch("Apple", 1.78, 3500, 300, "Curea silicon", "Husă protectoare din silicon", "Magnetic"));
        accesoriiSmartwatch.add(new acsmartwatch("Samsung", 1.4, 1500, 200, "Curea din piele", "Husă din plastic", "Qi Wireless"));
        accesoriiSmartwatch.add(new acsmartwatch("Garmin", 1.3, 700, 180, "Curea din metal", "Husă de protecție din silicon", "USB-C"));
        accesoriiSmartwatch.add(new acsmartwatch("Fossil", 1.5, 1200, 250, "Curea textilă", "Husă din piele", "Wireless"));
        accesoriiSmartwatch.add(new acsmartwatch("Huawei", 1.6, 1200, 350, "Curea sport", "Husă protectoare", "Magnetic"));
        accesoriiSmartwatch.add(new acsmartwatch("Fitbit", 1.45, 600, 150, "Curea silicon", "Husă transparentă", "USB-A"));
        accesoriiSmartwatch.add(new acsmartwatch("Amazfit", 1.39, 700, 180, "Curea din piele", "Husă de protecție din silicon", "Wireless"));
        accesoriiSmartwatch.add(new acsmartwatch("Xiaomi", 1.4, 800, 200, "Curea sport", "Husă din silicon", "Magnetic"));
        accesoriiSmartwatch.add(new acsmartwatch("Withings", 1.2, 200, 150, "Curea din piele", "Husă subțire din silicon", "USB-C"));
        accesoriiSmartwatch.add(new acsmartwatch("Polar", 1.3, 550, 180, "Curea sport", "Husă protectoare din plastic", "Magnetic"));
        
        Interfata a=new Interfata(telefoane,tablete);
    }

}