package com.mycompany.dispozitiv_mobil;

/**
 *
 * @author Manea Robert-Gabriel
 */
public class FitnessBand extends Dispozitiv_mobil {

    String model;
    String senzor;
    String rezistentaApa;
    int pasiInregistrati;
    int caloriiArse;
    boolean monitorizareSomn;
    final int TVA = 19;
    protected double pretTVA;

    public FitnessBand() //constructor fara argumente
    {
        super();
        this.model = "";
        this.senzor = "";
        this.rezistentaApa = "";
        this.pasiInregistrati = 0;
        this.caloriiArse = 0;
        this.monitorizareSomn = false;
    }

    public FitnessBand(String Brand, String model, double marimeEcran, double pret, int baterie, String senzor, String rezistentaApa, int pasiInregistrati, int caloriiArse, boolean monitorizareSomn) //constructor cu toate argumentele
    {
        super(Brand, marimeEcran, pret, baterie);
        this.model = model;
        this.senzor = senzor;
        this.rezistentaApa = rezistentaApa;
        this.pasiInregistrati = pasiInregistrati;
        this.caloriiArse = caloriiArse;
        this.monitorizareSomn = monitorizareSomn;
    }

    public FitnessBand(FitnessBand other) //constructor de copiere
    {
        super(other);
        this.model = other.model;
        this.senzor = other.senzor;
        this.rezistentaApa = other.rezistentaApa;
        this.pasiInregistrati = other.pasiInregistrati;
        this.caloriiArse = other.caloriiArse;
        this.monitorizareSomn = other.monitorizareSomn;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public double getMarimeEcran() {
        return marimeEcran;
    }

    public void setMarimeEcran(double marime_ecran) {
        this.marimeEcran = marime_ecran;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getBaterie() {
        return baterie;
    }

    public void setBaterie(int baterie) {
        this.baterie = baterie;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSenzor() {
        return senzor;
    }

    public void setSenzor(String senzor) {
        this.senzor = senzor;
    }

    public String getRezistentaApa() {
        return rezistentaApa;
    }

    public void setRezistentaApa(String rezistentaApa) {
        this.rezistentaApa = rezistentaApa;
    }

    public int getPasiInregistrati() {
        return pasiInregistrati;
    }

    public void setPasiInregistrati(int pasiInregistrati) {
        this.pasiInregistrati = pasiInregistrati;
    }

    public int getCaloriiArse() {
        return caloriiArse;
    }

    public void setCaloriiArse(int caloriiArse) {
        this.caloriiArse = caloriiArse;
    }

    public boolean getMonitorizareSomn() {
        return monitorizareSomn;
    }

    public void setMonitorizareSomn(boolean monitorizareSomn) {
        this.monitorizareSomn = monitorizareSomn;
    }

    @Override
    public String toString()
    {
        return "Brand: " + Brand + "\nModel: " + model + "\nMarimea ecranului: " + marimeEcran + " inch" + "\nBaterie: " + baterie + " mAh" + "\nSenzor: " + senzor + "\nPret: " + pret + "lei" + "\nRezistenta apa: " + rezistentaApa + "\nPasi inregistrati " + pasiInregistrati + "\nCalorii arse: " + caloriiArse + "\nMonitorizare somn: " + (monitorizareSomn ? "Da\n" : "Nu\n");
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
}
