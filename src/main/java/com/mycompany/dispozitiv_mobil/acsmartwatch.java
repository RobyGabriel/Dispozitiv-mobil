package com.mycompany.dispozitiv_mobil;

public class acsmartwatch extends Dispozitiv_mobil {

    String tip_accesorii;
    String model_husa;
    String tipIncarcator;

    public acsmartwatch() //constructor fara argumente
    {
        super();
        tip_accesorii = "";
        model_husa="";
        tipIncarcator="";
    }

    public acsmartwatch(String Brand, double marimeEcran, double pret, int baterie, String tip_accesorii,String model_husa,String tipIncarcator) 
    {
        super(Brand, marimeEcran, pret, baterie);
        this.tip_accesorii = tip_accesorii;                //constructor cu toate argumentele
        this.model_husa=model_husa;
        this.tipIncarcator= tipIncarcator;
    }

    public acsmartwatch(acsmartwatch A) { //constructor de copiere
        super(A);
        this.tip_accesorii = A.tip_accesorii;
        this.model_husa=A.model_husa;
        this.tipIncarcator= A.tipIncarcator;
    }

    @Override
    public String toString() {
        return "Accesorii: " + tip_accesorii+ "\nModel husa "+model_husa+"\nTip Incarcator: "+tipIncarcator;

    }        //rescriere toString

    public static void main(String[] args) {
        acsmartwatch test = new acsmartwatch("Samsung", 2.0, 500, 2000, "Husa,Incarcator,Bratara","Silicon","Tip C");
        System.out.println(test);
 }
}