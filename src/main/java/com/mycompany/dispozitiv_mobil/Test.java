package com.mycompany.dispozitiv_mobil;

public class Test {

    public static void main(String[] args) {

        Dispozitiv_mobil dispozitiv1 = new Dispozitiv_mobil();
        Dispozitiv_mobil dispozitiv2 = new Dispozitiv_mobil("Samsung", 6.4, 1500, 4000);
        Dispozitiv_mobil dispozitiv3 = new Dispozitiv_mobil(dispozitiv2);
        System.out.println(dispozitiv1.toString());
        System.out.println(dispozitiv2.toString());
        System.out.println(dispozitiv3.toString());
        
        Telefon testTelefon1 = new Telefon("Samsung", 6.6, "a32", 120, "Snapdragon", 4000, 5000, "SuperAMOLED");
        Telefon testTelefon2 = new Telefon();
        Telefon testTelefon3 = new Telefon(testTelefon1);
        System.out.print(testTelefon1);
        System.out.print(testTelefon2);
        System.out.print(testTelefon3);

        Tableta testTableta1 = new Tableta("Samsung", 6.6, "a32", 120, "Snapdragon", 4000, 5000, false, "Amoled");
        Tableta testTableta2 = new Tableta();
        Tableta testTableta3 = new Tableta(testTableta1);
        System.out.print(testTableta1);
        System.out.print(testTableta2);
        System.out.print(testTableta3);

        Smartwatch testsmartwatch1 = new Smartwatch("Samsung", 2.0, 500, 2000, "Negru", "LCD", "IP68");
        Smartwatch testsmartwatch2 = new Smartwatch();
        Smartwatch testsmartwatch3 = new Smartwatch(testsmartwatch2);
        System.out.println(testsmartwatch1);
        System.out.println(testsmartwatch3);

        fitness_band testfitness_band1 = new fitness_band();
        fitness_band testfitness_band2 = new fitness_band("Samsung", "Galaxy", 1.5, 749, 500, "pulsoximetru", "IP68", 10243, 500, true);
        fitness_band testfitness_band3 = new fitness_band(testfitness_band2);
        System.out.println(testfitness_band1);
        System.out.println(testfitness_band2);
        System.out.println(testfitness_band3);

        accesorii_fitness testaccesorii_fitness1 = new accesorii_fitness();
        accesorii_fitness testaccesorii_fitness2 = new accesorii_fitness("Samsung", 1.5, 600, 2000, "bratara", "neagra", "magnetica", false, "magnetic");
        accesorii_fitness testaccesorii_fitness3 = new accesorii_fitness(testaccesorii_fitness2);
        System.out.println(testaccesorii_fitness1);
        System.out.println(testaccesorii_fitness2);
        System.out.println(testaccesorii_fitness3);

        AcSmartwatch testacsmartwatch1 = new AcSmartwatch();
        AcSmartwatch testacsmartwatch2 = new AcSmartwatch("Samsung", 2.0, 500, 2000, "Husa,Incarcator,Bratara", "Silicon", "Tip C");
        AcSmartwatch testacsmartwatch3 = new AcSmartwatch(testacsmartwatch2);
        System.out.println(testacsmartwatch1);
        System.out.println(testacsmartwatch2);
        System.out.println(testacsmartwatch3);
    }
}
