package com.mycompany.dispozitiv_mobil;

public class Dispozitiv_mobil implements InterfataDispozitive {

    protected String Brand;
    protected double marimeEcran;
    protected double pret;
    protected int baterie;
    final int TVA=19;
    protected double pretTVA;
    public Dispozitiv_mobil() //constructor fara argumente
    {
        this.marimeEcran = 0;
        this.Brand = "";
        this.pret = 0;
        this.baterie = 0;
    }

    public Dispozitiv_mobil(String Brand, double marime_ecran, double pret, int baterie) //constructor cu toate argumentele
    {
        this.marimeEcran = marime_ecran;
        this.Brand = Brand;
        this.pret = pret;
        this.baterie = baterie;
    }

    public Dispozitiv_mobil(Dispozitiv_mobil other) //constructor de copiere
    {
        this.marimeEcran = other.marimeEcran;
        this.Brand = other.Brand;
        this.pret = other.pret;
        this.baterie = other.baterie;
    }

    @Override
    public String toString() //rescriere toString
    {
        return "Brand: " + Brand + "\nMarimea ecranului:" + marimeEcran + "\nPret: " + pret + "lei" + "\nMarime Baterie: " + baterie + "mAh";
    }
    @Override
    public double calcularePret(){
        return pret*((pret*TVA)/100);
    }
        public void pretDupaTVA() {
        pretTVA = pret * ((pret * TVA) / 100);
        System.out.println(pretTVA);
    }
}
