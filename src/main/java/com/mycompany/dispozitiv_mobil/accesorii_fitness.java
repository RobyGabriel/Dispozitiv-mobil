package com.mycompany.dispozitiv_mobil;

/**
 *
 * @author Roby
 */
public class accesorii_fitness extends Dispozitiv_mobil 
{
    String culoare_bratara;
    
    public accesorii_fitness() //constructor fara argumente
{
    super();
    this.culoare_bratara="";
}

public accesorii_fitness(String Brand, double marime_ecran, int pret, String culoare_bratara) //constructor cu toate argumentele
{
    super(Brand, marime_ecran,pret);
    this.culoare_bratara=culoare_bratara;
}

public accesorii_fitness(fitness_band other) //constructor de copiere
{
    super(other);
}

@Override
public String toString() //rescriere toString
{
    return "Brand: " + Brand + "\nMarimea ecranului: " + marime_ecran + "\nPret: " + pret + "Culoare bratara: " + culoare_bratara;
}

 public static void main(String[] args)
    {
     accesorii_fitness test=new accesorii_fitness("Samsung",1.5,700,"neagra");
     System.out.println(test);
    }
}
