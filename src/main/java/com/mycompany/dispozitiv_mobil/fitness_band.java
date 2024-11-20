package com.mycompany.dispozitiv_mobil;

/**
 *
 * @author Roby
 */
public class fitness_band extends Dispozitiv_mobil
{
    String Firma;
    int ecran;

public fitness_band() //constructor fara argumente
{
    super();
    this.Firma="";    
    this.ecran=0;
}

public fitness_band(String Brand, int marime_ecran, String Firma, int ecran) //constructor cu toate argumentele
{
    super(Brand, marime_ecran);
    this.Firma=Brand;
    this.ecran=marime_ecran;
}

public fitness_band(fitness_band other) //constructor de copiere
{
    super(other);
    this.Firma=other.Firma;
    this.ecran=other.ecran;
}

@Override
public String toString() //rescriere toString
{
    return "Brand: " + Firma + "/nMarimea ecranului:" + ecran;
}
}