package com.mycompany.dispozitiv_mobil;

/**
 *
 * @author Manea Robert-Gabriel
 */
public class fitness_band extends Dispozitiv_mobil
{
    String model;
    String senzor;
    String rezistentaApa;
    int pasiInregistrati;
    int caloriiArse;
    boolean monitorizareSomn;
    final int TVA = 19;
    protected double pretTVA;

public fitness_band() //constructor fara argumente
{
    super();
    this.model="";
    this.senzor="";
    this.rezistentaApa="";
    this.pasiInregistrati=0;
    this.caloriiArse=0;
    this.monitorizareSomn=false;
}

public fitness_band(String Brand, String model, double marimeEcran, double pret, int baterie, String senzor, String rezistentaApa, int pasiInregistrati, int caloriiArse, boolean monitorizareSomn) //constructor cu toate argumentele
{
    super(Brand, marimeEcran,pret,baterie);
    this.model=model;
    this.senzor=senzor;
    this.rezistentaApa=rezistentaApa;
    this.pasiInregistrati=pasiInregistrati;
    this.caloriiArse=caloriiArse;
    this.monitorizareSomn=monitorizareSomn;
}

public fitness_band(fitness_band other) //constructor de copiere
{
    super(other);
    this.model=other.model;
    this.senzor=other.senzor;
    this.rezistentaApa=other.rezistentaApa;
    this.pasiInregistrati=other.pasiInregistrati;
    this.caloriiArse=other.caloriiArse;
    this.monitorizareSomn=other.monitorizareSomn;
}

@Override
public String toString() //rescriere toString
{
    return "Brand: " + Brand + "\nModel: " + model + "\nMarimea ecranului: " + marimeEcran + " inch" + "\nBaterie: " + baterie + " mAh" + "\nSenzor: " + senzor + "\nPret: " + pret + "lei" + "\nRezistenta apa: " + rezistentaApa + "\nPasi inregistrati " + pasiInregistrati + "\nCalorii arse: " + caloriiArse + "\nMonitorizare somn: " + (monitorizareSomn ? "Da\n" : "Nu\n");
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