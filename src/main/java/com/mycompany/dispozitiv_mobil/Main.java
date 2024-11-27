package com.mycompany.dispozitiv_mobil;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Creăm o listă de tip Object pentru a stoca elemente de tip Telefon
        ArrayList<Object> telefoane = new ArrayList<>();

        // Adăugăm 10 obiecte Telefon în listă
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

        // Adăugăm 10 obiecte de tip Tableta în listă
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
        
    }

}
