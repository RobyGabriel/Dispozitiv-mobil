package com.mycompany.dispozitiv_mobil;

/**
 *
 * @author Manea Robert-Gabriel
 */
public class fitness_band extends Dispozitiv_mobil
{
    String model;
    String senzor;
    String rezistenta_apa;
    int pasi_inregistrati;
    int calorii_arse;
    boolean monitorizare_somn;

public fitness_band() //constructor fara argumente
{
    super();
    this.model="";
    this.senzor="";
    this.rezistenta_apa="";
    this.pasi_inregistrati=0;
    this.calorii_arse=0;
    this.monitorizare_somn=false;
}

public fitness_band(String Brand, String model, double marime_ecran, double pret, int baterie, String senzor, String rezistenta_apa, int pasi_inregistrati, int calorii_arse, boolean monitorizare_somn) //constructor cu toate argumentele
{
    super(Brand, marime_ecran,pret,baterie);
    this.model=model;
    this.senzor=senzor;
    this.rezistenta_apa=rezistenta_apa;
    this.pasi_inregistrati=pasi_inregistrati;
    this.calorii_arse=calorii_arse;
    this.monitorizare_somn=monitorizare_somn;
}

public fitness_band(fitness_band other) //constructor de copiere
{
    super(other);
    this.model=other.model;
    this.senzor=other.senzor;
    this.rezistenta_apa=other.rezistenta_apa;
    this.pasi_inregistrati=other.pasi_inregistrati;
    this.calorii_arse=other.calorii_arse;
    this.monitorizare_somn=other.monitorizare_somn;
}

@Override
public String toString() //rescriere toString
{
    if(monitorizare_somn==true)
    return "Brand: " + Brand + "\nModel: " + model + "\nMarimea ecranului: " + marime_ecran + " inch" + "\nBaterie: " + baterie + " mAh" + "\nSenzor: " + senzor + "\nPret: " + pret + "lei" + "\nRezistenta apa: " + rezistenta_apa + "\nPasi inregistrati " + pasi_inregistrati + "\nCalorii arse: " + calorii_arse + "\nMonitorizare somn: Da\n";
    else return "Brand: " + Brand + "\nModel: " + model + "\nMarimea ecranului: " + marime_ecran + " inch" + "\nBaterie: " + baterie + " mAh" + "\nSenzor: " + senzor + "\nPret: " + pret + "lei" + "\nRezistenta apa: " + rezistenta_apa + "\nPasi inregistrati " + pasi_inregistrati + "\nCalorii arse: " + calorii_arse + "\nMonitorizare somn: Nu\n";

}

 public static void main(String[] args)
    {
        fitness_band test1=new fitness_band();
        fitness_band test2= new fitness_band("Samsung", "Galaxy", 1.5, 749, 500, "pulsoximetru", "IP68", 10243, 500, true);
        fitness_band test3=new fitness_band(test2);
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
    }
}