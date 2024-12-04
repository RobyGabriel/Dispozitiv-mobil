package com.mycompany.dispozitiv_mobil;

import com.mycompany.dispozitiv_mobil.Dispozitiv_mobil;
/*
Ichim Ionut
 */


public class Tableta extends Dispozitiv_mobil {

    protected String procesor;
    protected String model;
    protected boolean tastatura;
    protected String displayTip;
    protected int camera;
    final int TVA = 19;
    protected double pretTVA;

    // Constructor fara argumente
    public Tableta() {
        super();
        procesor = "";
        model = "";
        camera = 0;
        tastatura = false;
        displayTip = "";
    }

    // Constructor cu toate argumentele
    public Tableta(String brand, double marimeEcran, String model, int camera, String procesor, double pret, int baterie, boolean tast, String displayTip) {
        super(brand, marimeEcran, pret, baterie);
        this.model = model;
        this.procesor = procesor;
        this.camera = camera;
        this.tastatura = tast;
        this.displayTip = displayTip;
    }

    // Constructor de copiere
    public Tableta(Tableta a) {
        super(a);
        this.model = a.model;
        this.procesor = a.procesor;
        this.camera = a.camera;
        this.tastatura = a.tastatura;
        this.displayTip = a.displayTip;
    }

    // Metoda toString
    @Override
    public String toString() {
        // Calculăm prețul cu TVA
        pretTVA = pret + (pret * TVA / 100);
         return super.toString() + "Model: " + model + "\nProcesor: " + procesor + "\nCamera: " + camera + "MP" + "\nPreț: " + pret + " lei\n" 
                + "Display: " + displayTip + "\n" + (tastatura ? "Are tastatura\n" : "Nu are tastatura\n");
    }

    @Override
    public double calcularePret() {
        return pret * ((pret * TVA) / 100);
    }

    @Override
    public void pretDupaTVA() {
        pretTVA = pret * ((pret * TVA) / 100);
        System.out.println(pretTVA);
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

    public String getProcesor() {
        return procesor;
    }

    public void setProcesor(String procesor) {
        this.procesor = procesor;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean areTastatura() {
        return tastatura;
    }

    public void setTastatura(boolean tastatura) {
        this.tastatura = tastatura;
    }

    public String getDisplayTip() {
        return displayTip;
    }

    public void setdisplayTip(String displayTip) {
        this.displayTip = displayTip;
    }

    public int getCamera() {
        return camera;
    }

    public void setCamera(int camera) {
        this.camera = camera;
    }

    public int getTVA() {
        return TVA;
    }
}
