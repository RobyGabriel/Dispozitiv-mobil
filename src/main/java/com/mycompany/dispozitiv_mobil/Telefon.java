/*
Ichim Ionut
 */
package com.mycompany.dispozitiv_mobil;

public class Telefon extends Dispozitiv_mobil {

    String procesor;
    String model;
    int camera;
    
    public Telefon(){
    super();
    procesor="";
    model="";
    camera=0;
    }//constructor fara argumente

public Telefon(String brand, double marime_ecran, String model, int camera, String procesor, double pret, int baterie){ //constructor cu toate argumentele
    super(brand,marime_ecran,pret,baterie);
    this.model=model;
    this.procesor=procesor;
    this.camera=camera;
}

public Telefon(Telefon a){ //constructor de copiere
    super(a);
    this.model=a.model;
    this.procesor=a.procesor;
    this.camera=a.camera;
}
public String toString(){
    return "\nBrand " + Brand + " " + model+ "\nProcesor " + procesor + "\nMarime_ecran "+marime_ecran+" inch"+"\nCamera "+camera+ "\nBaterie "+baterie+ " mAh"+ "\nPret "+pret+"lei\n";
}
public static void main(String[] args) {
        Telefon test= new Telefon("Samsung",6.6,"a32",120,"Snapdragon",4000,5000);
        Telefon test2= new Telefon();
        Telefon test3= new Telefon(test);
        System.out.print(test);
        System.out.print(test2);
        System.out.print(test3);
    }
}