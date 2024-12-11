package com.mycompany.dispozitiv_mobil;

public class Smartwatch extends Dispozitiv_mobil {

    String culoare;
    String tipecran;
    String rezapa;
    final int TVA = 19;
    protected double pretTVA;

    public Smartwatch() {
        super();
        culoare = "";                     //constructor fara argumente
        tipecran = "";
        rezapa = "";
    }

    public Smartwatch(String brand, double marimeEcran, double pret, int baterie, String culoare, String tipecran, String rezapa) {
        super(brand, marimeEcran, pret, baterie);
        this.culoare = culoare;       //constructor cu toate argumentele
        this.tipecran = tipecran;
        this.rezapa = rezapa;
    }

    public Smartwatch(Smartwatch A) { //constructor de copiere
        super(A);
        this.culoare = A.culoare;
        this.tipecran = A.tipecran;
        this.rezapa = A.rezapa;
    }

    @Override
    public String toString() //rescriere toString
    {
        return "Brand: " + Brand + "\nMarimea ecranului: " + marimeEcran + "\nPret: " + pret + "\nBaterie: " + baterie + "\nCuloare: " + culoare + "\nTip Ecran: " + tipecran + "\nRezistenta la Apa: " + rezapa + "\n";
    }

    @Override
    public double calcularePret() {
        pretTVA = pret * ((pret * TVA) / 100);
        return pretTVA;
    }

    public void pretDupaTVA() {
        pretTVA = pret * ((pret * TVA) / 100);
        System.out.println(pretTVA);
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }
    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
    this.Brand = Brand;
    }

    public String getTipEcran() {
        return tipecran;
    }

    public void setTipEcran(String tip_ecran) {
        this.tipecran = tip_ecran;
    }

    public String getRezApa() {
        return rezapa;
    
    }
    public void setRezApa(String rezapa) {
        this.rezapa = rezapa;
    }
    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }
}
