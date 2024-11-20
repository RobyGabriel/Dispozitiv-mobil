package com.mycompany.dispozitiv_mobil;

/**
 *
 * @author Roby
 */
public class fitness_band extends Dispozitiv_mobil
{
    String senzor;

public fitness_band() //constructor fara argumente
{
    super();
    this.senzor="";
}

public fitness_band(String Brand, double marime_ecran, String senzor, int pret) //constructor cu toate argumentele
{
    super(Brand, marime_ecran,pret);
    this.senzor=senzor;
}

public fitness_band(fitness_band other) //constructor de copiere
{
    super(other);
    this.senzor=other.senzor;
}

@Override
public String toString() //rescriere toString
{
    return "Brand: " + Brand + "\nMarimea ecranului: " + marime_ecran + "\nSenzor: " + senzor + "\nPret: " + pret;
}

 public static void main(String[] args)
    {
     fitness_band test=new fitness_band("Samsung",1.5,"pulsoximetru",700);
     System.out.println(test);
    }
}

