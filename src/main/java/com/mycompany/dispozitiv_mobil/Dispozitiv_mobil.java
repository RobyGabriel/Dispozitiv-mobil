package com.mycompany.dispozitiv_mobil;

public class Dispozitiv_mobil implements InterfataDispozitive {

    protected String Brand;
    protected double marime_ecran;
    protected double pret;
    protected int baterie;
    final int TVA=10;
    protected double pretTVA;
    public Dispozitiv_mobil() //constructor fara argumente
    {
        this.marime_ecran = 0;
        this.Brand = "";
        this.pret = 0;
        this.baterie = 0;
    }

    public Dispozitiv_mobil(String Brand, double marime_ecran, double pret, int baterie) //constructor cu toate argumentele
    {
        this.marime_ecran = marime_ecran;
        this.Brand = Brand;
        this.pret = pret;
        this.baterie = baterie;
    }

    public Dispozitiv_mobil(Dispozitiv_mobil other) //constructor de copiere
    {
        this.marime_ecran = other.marime_ecran;
        this.Brand = other.Brand;
        this.pret = other.pret;
        this.baterie = other.baterie;
    }

    public String toString() //rescriere toString
    {
        return "Brand: " + Brand + "\nMarimea ecranului:" + marime_ecran + "\nPret: " + pret + "lei" + "\nMarime Baterie: " + baterie + "mAh";
    }
    @Override
    public double calcularePret(){
        return pret*((pret*TVA)/100);
    }
        public void pretDupaTVA() {
        pretTVA = pret * ((pret * TVA) / 100);
        System.out.println(pretTVA);
    }

    public static void main(String[] args) {
        Telefon testTelefon1 = new Telefon("Samsung", 6.6, "a32", 120, "Snapdragon", 4000, 5000,"SuperAMOLED");
        Telefon testTelefon2 = new Telefon();
        Telefon testTelefon3 = new Telefon(testTelefon1);
        System.out.print(testTelefon1);
        System.out.print(testTelefon2);
        System.out.print(testTelefon3);

        Tableta testTableta1 = new Tableta("Samsung", 6.6, "a32", 120, "Snapdragon", 4000, 5000, false,"Amoled");
        Tableta testTableta2 = new Tableta();
        Tableta testTableta3 = new Tableta(testTableta1);
        System.out.print(testTableta1);
        System.out.print(testTableta2);
        System.out.print(testTableta3);

        smartwatch testsmartwatch1 = new smartwatch("Samsung", 2.0, 500, 2000, "Negru", "LCD", "IP68");
        System.out.println(testsmartwatch1);
        smartwatch testsmartwatch2 = new smartwatch();
        System.out.println(testsmartwatch2);
        smartwatch testsmartwatch3 = new smartwatch(testsmartwatch2);
        System.out.println(testsmartwatch3);
        
        fitness_band testfitness_band1=new fitness_band();
        fitness_band testfitness_band2= new fitness_band("Samsung", "Galaxy", 1.5, 749, 500, "pulsoximetru", "IP68", 10243, 500, true);
        fitness_band testfitness_band3=new fitness_band(testfitness_band2);
        System.out.println(testfitness_band1);
        System.out.println(testfitness_band2);
        System.out.println(testfitness_band3);
        
        accesorii_fitness testaccesorii_fitness1=new accesorii_fitness();
        accesorii_fitness testaccesorii_fitness2= new accesorii_fitness("Samsung", 1.5, 600, 2000,"bratara","neagra","magnetica",false,"magnetic");
        accesorii_fitness testaccesorii_fitness3=new accesorii_fitness(testaccesorii_fitness2);
        System.out.println(testaccesorii_fitness1);
        System.out.println(testaccesorii_fitness2);
        System.out.println(testaccesorii_fitness3);
        
        acsmartwatch testacsmartwatch1=new acsmartwatch();
        acsmartwatch testacsmartwatch2 = new acsmartwatch("Samsung", 2.0, 500, 2000, "Husa,Incarcator,Bratara","Silicon");
        acsmartwatch testacsmartwatch3= new acsmartwatch(testacsmartwatch2);
        System.out.println(testacsmartwatch1);
        System.out.println(testacsmartwatch2);
        System.out.println(testacsmartwatch3);
    }
}
