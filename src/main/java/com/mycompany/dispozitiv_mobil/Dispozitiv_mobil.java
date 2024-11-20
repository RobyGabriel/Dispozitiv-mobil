package com.mycompany.dispozitiv_mobil;

public class Dispozitiv_mobil {

String Brand;
int marime_ecran;

public Dispozitiv_mobil() //constructor fara argumente
        {
            this.marime_ecran=0;
            this.Brand="";
        }

public Dispozitiv_mobil(int marime_ecran, String Brand) //constructor cu toate argumentele
{
    this.marime_ecran=marime_ecran;
    this.Brand=Brand;
}

public Dispozitiv_mobil(Dispozitiv_mobil other) //constructor de copiere
{
this.marime_ecran=other.marime_ecran;
this.Brand=other.Brand;
}

public String toString() //rescriere toString
{
    return "Brand: " + Brand + "/nMarimea ecranului:" + marime_ecran;
}

    public static void main(String[] args)
    {
     
    }
}
