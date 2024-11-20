package com.mycompany.dispozitiv_mobil;

/**
 *
 * @author Manea Robert-Gabriel
 */
public class accesorii_fitness extends Dispozitiv_mobil 
{
    String tip_accesoriu;
    String culoare_bratara;
    String tip_catarama_bratara;
    boolean curea_ajustabila;
    String tip_incarcator;
    
    public accesorii_fitness() //constructor fara argumente
{
    super();
    this.tip_accesoriu="";
    this.culoare_bratara="";
    this.tip_catarama_bratara="";
    this.curea_ajustabila=false;
    this.tip_incarcator="";
}

public accesorii_fitness(String Brand, double marime_ecran, double pret, int baterie, String tip_accesoriu, String culoare_bratara, String tip_catarama_bratara, boolean curea_ajustabila, String tip_incarcator) //constructor cu toate argumentele
{
    super(Brand,marime_ecran,pret,baterie);
    this.tip_accesoriu=tip_accesoriu;
    this.culoare_bratara=culoare_bratara;
    this.tip_catarama_bratara=tip_catarama_bratara;
    this.curea_ajustabila=curea_ajustabila;
    this.tip_incarcator=tip_incarcator;
}

public accesorii_fitness(accesorii_fitness other) //constructor de copiere
{
    super(other);
    this.tip_accesoriu=other.tip_accesoriu;
    this.culoare_bratara=other.culoare_bratara;
    this.tip_catarama_bratara=other.tip_catarama_bratara;
    this.curea_ajustabila=other.curea_ajustabila;
    this.tip_incarcator=other.tip_incarcator;
}

@Override
public String toString() //rescriere toString
{   if(curea_ajustabila=true)
    return "Brand: " + Brand + "\nMarimea ecranului: " + marime_ecran + "\nPret: " + pret + "\nTip accesoriu: " + tip_accesoriu + "\nCuloare bratara: " + culoare_bratara + "\nTip catarama bratara: " + tip_catarama_bratara + "\nCurea ajustabila: Da" + "\nTip incarcator: " + tip_incarcator;
else return "Brand: " + Brand + "\nMarimea ecranului: " + marime_ecran + "\nPret: " + pret + "\nTip accesoriu: " + tip_accesoriu + "\nCuloare bratara: " + culoare_bratara + "\nTip catarama bratara: " + tip_catarama_bratara + "\nCurea ajustabila: Nu" + "\nTip incarcator: " + tip_incarcator;
}

 public static void main(String[] args)
    {
        accesorii_fitness test1=new accesorii_fitness();
        accesorii_fitness test2= new accesorii_fitness("Samsung", 1.5, 600, 2000,"bratara","neagra","magnetica",false,"magnetic");
        accesorii_fitness test3=new accesorii_fitness(test2);
        System.out.println(test1);
        System.out.println("\n");
        System.out.println(test2);
        System.out.println("\n");
        System.out.println(test3);
    }
}