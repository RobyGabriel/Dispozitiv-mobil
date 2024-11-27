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

    public smartwatch(String brand, double marimeEcran,double pret,int baterie,String culoare, String tip_ecran, String rez_apa) {
        super(brand, marimeEcran,pret,baterie);
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
    return "Brand: " + Brand + "\nMarimea ecranului: " + marimeEcran + "\nPret: " + pret + "\nBaterie: " + baterie+"\nCuloare: "+culoare+"\nTip Ecran: "+tip_ecran+"\nRezistenta la Apa: "+rez_apa+"\n";
}

 public static void main(String[] args)
    {
     smartwatch test=new smartwatch("Samsung",2.0,500,2000,"Negru","LCD","IP68");
     System.out.println(test);
     smartwatch test2=new smartwatch();
     System.out.println(test2);
     smartwatch test3=new smartwatch(test);
     System.out.println(test3);
     
    }
}