package com.mycompany.dispozitiv_mobil;

public class Smartwatch extends Dispozitiv_mobil {

    String culoare;
    String tip_ecran;
    String rez_apa;
    final int TVA = 19;
    protected double pretTVA;

    public Smartwatch() {
        super();
        culoare = "";                     //constructor fara argumente
        tip_ecran = "";
        rez_apa = "";
    }

    public Smartwatch(String brand, double marimeEcran, double pret, int baterie, String culoare, String tip_ecran, String rez_apa) {
        super(brand, marimeEcran, pret, baterie);
        this.culoare = culoare;       //constructor cu toate argumentele
        this.tip_ecran = tip_ecran;
        this.rez_apa = rez_apa;
    }

    public Smartwatch(Smartwatch A) { //constructor de copiere
        super(A);
        this.culoare = A.culoare;
        this.tip_ecran = A.tip_ecran;
        this.rez_apa = A.rez_apa;
    }

    @Override
    public String toString() //rescriere toString
    {
        return "Brand: " + Brand + "\nMarimea ecranului: " + marimeEcran + "\nPret: " + pret + "\nBaterie: " + baterie + "\nCuloare: " + culoare + "\nTip Ecran: " + tip_ecran + "\nRezistenta la Apa: " + rez_apa + "\n";
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

    public String getTipEcran() {
        return tip_ecran;
    }

    public void setTipEcran(String tip_ecran) {
        this.tip_ecran = tip_ecran;
    }

    public String getRezApa() {
        return rez_apa;
    }

    public void setRezApa(String rez_apa) {
        this.rez_apa = rez_apa;
    }
}
