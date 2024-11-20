package com.mycompany.dispozitiv_mobil;

public class Dispozitiv_mobil {

    String Brand;
    double marime_ecran;
    double pret;
    int baterie;

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

    public static void main(String[] args) 
    {
        Dispozitiv_mobil test1=new Dispozitiv_mobil();
        Dispozitiv_mobil test2= new Dispozitiv_mobil("Samsung", 7, 999, 5000);
        Dispozitiv_mobil test3=new Dispozitiv_mobil(test2);
        System.out.println(test1);
        System.out.println("\n");
        System.out.println(test2);
        System.out.println("\n");
        System.out.println(test3);
    }
}
