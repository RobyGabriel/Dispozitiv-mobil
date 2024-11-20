/*
Ichim Ionut
 */
package com.mycompany.dispozitiv_mobil;

public class Tableta extends Dispozitiv_mobil {
    String procesor;
    String model;
    boolean tast;
    int camera;
    //constructor fara argumente
    public Tableta(){
    super();
    procesor="";
    model="";
    camera=0;
    }
    //constructor cu toate argumentele
public Tableta(String brand, double marime_ecran, String model, int camera, String procesor, double pret, int baterie, boolean tast){
    super(brand,marime_ecran,pret,baterie);
    this.model=model;
    this.procesor=procesor;
    this.camera=camera;
    this.tast=tast;
}
     //constructor de copiere
public Tableta(Tableta a){
    super(a);
    this.model=a.model;
    this.procesor=a.procesor;
    this.camera=a.camera;
    this.tast=a.tast;
}
    //metoda toString
public String toString(){
    if(tast=false)
        return "\nBrand " + Brand + " " + model+ "\nProcesor " + procesor + "\nMarime_ecran "+marime_ecran+" inch"+"\nCamera "+camera+ "\nBaterie "+baterie+ " mAh"+ "\nPret "+pret+"lei\n";
    else
        return "\nBrand " + Brand + " " + model+ "\nProcesor " + procesor + "\nMarime_ecran "+marime_ecran+" inch"+"\nCamera "+camera+ "\nBaterie "+baterie+ " mAh"+ "\nPret "+pret+"lei\n"+"Are tastatura\n";

}
public static void main(String[] args) {
        Tableta test= new Tableta("Samsung",6.6,"a32",120,"Snapdragon",4000,5000,false);
        Tableta test2= new Tableta();
        Tableta test3= new Tableta(test);
        System.out.print(test);
        System.out.print(test2);
        System.out.print(test3);
    }
}
