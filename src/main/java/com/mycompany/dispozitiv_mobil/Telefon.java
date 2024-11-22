/*
Ichim Ionut
 */
package com.mycompany.dispozitiv_mobil;

public class Telefon extends Dispozitiv_mobil {

    protected String procesor;
    protected String model;
    protected int camera;
    protected String displayTip;
    final int TVA = 12;
    protected double pretTVA;
    //constructor fara argumente

    public Telefon() {
        super();
        procesor = "";
        model = "";
        camera = 0;
    }
    //constructor cu toate argumentele

    public Telefon(String brand, double marime_ecran, String model, int camera, String procesor, double pret, int baterie, String displayTip) {
        super(brand, marime_ecran, pret, baterie);
        this.model = model;
        this.procesor = procesor;
        this.camera = camera;
        this.displayTip = displayTip;
    }
    //constructor de copiere

    public Telefon(Telefon a) {
        super(a);
        this.model = a.model;
        this.procesor = a.procesor;
        this.camera = a.camera;
        this.displayTip = a.displayTip;
    }
    //Metoda toString

    public String toString() {
        return super.toString() + " " + model + "\nProcesor " + procesor + " inch" + "\nCamera " + camera + " mAh" + "lei\n" +
               "Display " + displayTip + "\n";
    }

    public double calcularePret() {
        pretTVA = pret * ((pret * TVA) / 100);
        return pretTVA;
    }

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
        return marime_ecran;
    }

    public void setMarimeEcran(double marime_ecran) {
        this.marime_ecran = marime_ecran;
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

    public String getdisplayTip() {
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
