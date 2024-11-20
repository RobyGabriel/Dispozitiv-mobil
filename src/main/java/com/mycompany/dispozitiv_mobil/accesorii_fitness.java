package com.mycompany.dispozitiv_mobil;

/**
 *
 * @author Manea Robert-Gabriel
 */
public class accesorii_fitness extends Dispozitiv_mobil 
{
    String tip_accesoriu;
    String culoare_bratara;
    
    public accesorii_fitness() //constructor fara argumente
{
    super();
    this.tip_accesoriu="";
    this.culoare_bratara="";
}

public accesorii_fitness(String Brand, double marime_ecran, double pret, int baterie, String tip_accesoriu, String culoare_bratara) //constructor cu toate argumentele
{
    super(Brand, marime_ecran,pret,baterie);
    this.tip_accesoriu=tip_accesoriu;
    this.culoare_bratara=culoare_bratara;
}

public accesorii_fitness(fitness_band other) //constructor de copiere
{
    super(other);
}

@Override
public String toString() //rescriere toString
{
    return "Brand: " + Brand + "\nMarimea ecranului: " + marime_ecran + "\nPret: " + pret + "Tip accesoriu: " + tip_accesoriu + "Culoare bratara: " + culoare_bratara;
}

 public static void main(String[] args)
    {
        
    }
}