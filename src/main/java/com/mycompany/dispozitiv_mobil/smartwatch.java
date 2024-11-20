package com.mycompany.dispozitiv_mobil;

public class smartwatch extends Dispozitiv_mobil{

    String culoare;
    String tip_ecran;
    String rez_apa;

    public smartwatch() {
        super();
        culoare = "";                     //constructor fara argumente
        tip_ecran = "";
        rez_apa = "";
    }

    public smartwatch(String brand, double marime_ecran,double pret,String culoare, int baterie, String tip_ecran, String rez_apa) {
        super(brand, marime_ecran,pret,baterie);
        this.culoare = culoare;       //constructor cu toate argumentele
        this.tip_ecran = tip_ecran;
        this.rez_apa = rez_apa;
    }

    public smartwatch(smartwatch A) { //constructor de copiere
        super(A);
        this.culoare = A.culoare;
        this.tip_ecran = A.tip_ecran;
        this.rez_apa = A.rez_apa;
    }
    
    @Override
public String toString() //rescriere toString
{
    return "Brand: " + Brand + "\nMarimea ecranului: " + marime_ecran + "\nPret: " + pret + "\nBaterie: " + baterie+"\nCuloare: "+culoare+"\nTip Ecran: "+tip_ecran+"\nRezistenta la Apa: "+rez_apa;
}

 public static void main(String[] args)
    {
     smartwatch test=new smartwatch();
     System.out.println(test);
    }
}