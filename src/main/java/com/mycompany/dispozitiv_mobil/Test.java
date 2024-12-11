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

        FitnessBand testfitness_band1 = new FitnessBand();
        FitnessBand testfitness_band2 = new FitnessBand("Samsung", "Galaxy", 1.5, 749, 500, "pulsoximetru", "IP68", true);
        FitnessBand testfitness_band3 = new FitnessBand(testfitness_band2);
        System.out.println(testfitness_band1);
        System.out.println(testfitness_band2);
        System.out.println(testfitness_band3);

        AccesoriiFitness testaccesorii_fitness1 = new AccesoriiFitness();
        AccesoriiFitness testaccesorii_fitness2 = new AccesoriiFitness("Samsung", 1.5, 600, 2000, "bratara", "neagra", "magnetica", false, "magnetic");
        AccesoriiFitness testaccesorii_fitness3 = new AccesoriiFitness(testaccesorii_fitness2);
        System.out.println(testaccesorii_fitness1);
        System.out.println(testaccesorii_fitness2);
        System.out.println(testaccesorii_fitness3);

        AccesoriiSmartwatch testacsmartwatch1 = new AccesoriiSmartwatch();
        AccesoriiSmartwatch testacsmartwatch2 = new AccesoriiSmartwatch("Samsung", 2.0, 500, 2000, "Husa,Incarcator,Bratara", "Silicon", "Tip C");
        AccesoriiSmartwatch testacsmartwatch3 = new AccesoriiSmartwatch(testacsmartwatch2);
        System.out.println(testacsmartwatch1);
        System.out.println(testacsmartwatch2);
        System.out.println(testacsmartwatch3);
    }
}
