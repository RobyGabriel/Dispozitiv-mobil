package com.mycompany.dispozitiv_mobil;

public class AccesoriiSmartwatch extends Dispozitiv_mobil {

    String tipAccesorii;
    String modelHusa;
    String tipIncarcator;
    final int TVA = 19;
    protected double pretTVA;

    public AccesoriiSmartwatch() //constructor fara argumente
    {
        super();
        tipAccesorii = "";
        modelHusa = "";
        tipIncarcator = "";
    }

    public AccesoriiSmartwatch(String Brand, double marimeEcran, double pret, int baterie, String tipAccesorii, String modelHusa, String tipIncarcator) {
        super(Brand, marimeEcran, pret, baterie);
        this.tipAccesorii = tipAccesorii;                //constructor cu toate argumentele
        this.modelHusa = modelHusa;
        this.tipIncarcator = tipIncarcator;
    }

    public AccesoriiSmartwatch(AccesoriiSmartwatch A) { //constructor de copiere
        super(A);
        this.tipAccesorii = A.tipAccesorii;
        this.modelHusa = A.modelHusa;
        this.tipIncarcator = A.tipIncarcator;
    }

    @Override
    public String toString() {
        return "Accesorii: " + tipAccesorii + "\nModel husa: " + modelHusa + "\nTip Incarcator: " + tipIncarcator;

    }        //rescriere toString

    @Override
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

    public String getTipAccesorii() {
        return tipAccesorii;
    }

    public void setTipAccesorii(String tip_accesorii) {
        this.tipAccesorii = tip_accesorii;
    }

    public String getModelHusa() {
        return modelHusa;
    }

    public void setModelHusa(String model_husa) {
        this.modelHusa = model_husa;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public String getTipIncarcator() {
        return tipIncarcator;
    }

    public void setTipIncarcator(String tipIncarcator) {
        this.tipIncarcator = tipIncarcator;
    }
}
