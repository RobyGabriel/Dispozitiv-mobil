package com.mycompany.dispozitiv_mobil;

public class Dispozitiv_mobil {

String Brand;
double marime_ecran;
double pret;

public Dispozitiv_mobil() //constructor fara argumente
{
    this.marime_ecran=0;
    this.Brand="";
    this.pret=0;
}

public Dispozitiv_mobil(String Brand, double marime_ecran, double pret) //constructor cu toate argumentele
{
    this.marime_ecran=marime_ecran;
    this.Brand=Brand;
    this.pret=pret;
}

public Dispozitiv_mobil(Dispozitiv_mobil other) //constructor de copiere
{
    this.marime_ecran=other.marime_ecran;
    this.Brand=other.Brand;
    this.pret=other.pret;
}

public String toString() //rescriere toString
{
    return "Brand: " + Brand + "\nMarimea ecranului:" + marime_ecran + "\nPret: " + pret;
}

    public static void main(String[] args)
    {
     
    }
}
