package com.mycompany.dispozitiv_mobil;

public class acsmartwatch extends Dispozitiv_mobil {

    String tip_accesorii;
    String model_husa;

    public acsmartwatch() //constructor fara argumente
    {
        super();
        tip_accesorii = "";
        model_husa="";
    }

    public acsmartwatch(String Brand, double marime_ecran, double pret, int baterie, String tip_accesorii,String model_husa) {
        super(Brand, marime_ecran, pret, baterie);
        this.tip_accesorii = tip_accesorii;                //constructor cu toate argumentele
        this.model_husa=model_husa;
    }

    public acsmartwatch(acsmartwatch A) { //constructor de copiere
        super(A);
        this.tip_accesorii = A.tip_accesorii;
        this.model_husa=A.model_husa;

    }

    @Override
    public String toString() {
        return "Accesorii: " + tip_accesorii+ "\nModel husa "+model_husa;

    }        //rescriere toString

    public static void main(String[] args) {
        acsmartwatch test = new acsmartwatch("Samsung", 2.0, 500, 2000, "Husa,Incarcator,Bratara","Silicon");
        System.out.println(test);
 }
}