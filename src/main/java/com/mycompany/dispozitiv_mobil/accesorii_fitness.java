package com.mycompany.dispozitiv_mobil;

/**
 *
 * @author Manea Robert-Gabriel
 */
public class accesorii_fitness extends Dispozitiv_mobil 
{
    String tipAccesoriu;
    String culoareBratara;
    String tipCataramaBratara;
    boolean cureaAjustabila;
    String tipIncarcator;
    final int TVA = 19;
    protected double pretTVA;
    
    public accesorii_fitness() //constructor fara argumente
{
    super();
    this.tipAccesoriu="";
    this.culoareBratara="";
    this.tipCataramaBratara="";
    this.cureaAjustabila=false;
    this.tipIncarcator="";
}

public accesorii_fitness(String Brand, double marimeEcran, double pret, int baterie, String tipAccesoriu, String culoareBratara, String tipCataramaBratara, boolean cureaAjustabila, String tipIncarcator) //constructor cu toate argumentele
{
    super(Brand,marimeEcran,pret,baterie);
    this.tipAccesoriu=tipAccesoriu;
    this.culoareBratara=culoareBratara;
    this.tipCataramaBratara=tipCataramaBratara;
    this.cureaAjustabila=cureaAjustabila;
    this.tipIncarcator=tipIncarcator;
}

public accesorii_fitness(accesorii_fitness other) //constructor de copiere
{
    super(other);
    this.tipAccesoriu=other.tipAccesoriu;
    this.culoareBratara=other.culoareBratara;
    this.tipCataramaBratara=other.tipCataramaBratara;
    this.cureaAjustabila=other.cureaAjustabila;
    this.tipIncarcator=other.tipIncarcator;
}

@Override
public String toString() //rescriere toString
{
    return "Brand: " + Brand + "\nMarimea ecranului: " + marimeEcran + "\nPret: " + pret + "\nTip accesoriu: " + tipAccesoriu + "\nCuloare bratara: " + culoareBratara + "\nTip catarama bratara: " + tipCataramaBratara + "\nCurea ajustabila: " + (cureaAjustabila ? "Da" : "Nu") + "\nTip incarcator: " + tipIncarcator + "\n";
}

 public static void main(String[] args)
    {
        accesorii_fitness test1=new accesorii_fitness();
        accesorii_fitness test2= new accesorii_fitness("Samsung", 1.5, 600, 2000,"bratara","neagra","magnetica",false,"magnetic");
        accesorii_fitness test3=new accesorii_fitness(test2);
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
    }
}