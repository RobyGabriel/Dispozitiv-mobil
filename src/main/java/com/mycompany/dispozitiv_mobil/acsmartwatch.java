package com.mycompany.dispozitiv_mobil;

public class acsmartwatch extends Dispozitiv_mobil {

    String tip_accesorii;
    String model_husa;
    String tipIncarcator;
    final int TVA = 19;
    protected double pretTVA;

    public acsmartwatch() //constructor fara argumente
    {
        super();
        tip_accesorii = "";
        model_husa = "";
        tipIncarcator = "";
    }

    public acsmartwatch(String Brand, double marimeEcran, double pret, int baterie, String tip_accesorii, String model_husa, String tipIncarcator) {
        super(Brand, marimeEcran, pret, baterie);
        this.tip_accesorii = tip_accesorii;                //constructor cu toate argumentele
        this.model_husa = model_husa;
        this.tipIncarcator = tipIncarcator;
    }

    public acsmartwatch(acsmartwatch A) { //constructor de copiere
        super(A);
        this.tip_accesorii = A.tip_accesorii;
        this.model_husa = A.model_husa;
        this.tipIncarcator = A.tipIncarcator;
    }

    @Override
    public String toString() {
        return "Accesorii: " + tip_accesorii + "\nModel husa " + model_husa + "\nTip Incarcator: " + tipIncarcator;

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

    public String getTipAccesorii() {
        return tip_accesorii;
    }

    public void setTipAccesorii(String tip_accesorii) {
        this.tip_accesorii = tip_accesorii;
    }

    public String getModelHusa() {
        return model_husa;
    }

    public void setModelHusa(String model_husa) {
        this.model_husa = model_husa;
    }

    public String getTipIncarcator() {
        return tipIncarcator;
    }

    public void setTipIncarcator(String tipIncarcator) {
        this.tipIncarcator = tipIncarcator;
    }
}
