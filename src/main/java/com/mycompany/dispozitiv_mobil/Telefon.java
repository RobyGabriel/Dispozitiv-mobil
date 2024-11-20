/*
Ichim Ionut
 */
package com.mycompany.dispozitiv_mobil;

public class Telefon extends Dispozitiv_mobil {

    String procesor;
    int camera;
    
    public Telefon(){
    super();
    procesor="";
    camera=0;
    }//constructor fara argumente

public Telefon(String brand, double marime_ecran,int camera, String procesor, int pret){ //constructor cu toate argumentele
    super(brand,marime_ecran,pret);
    this.procesor=procesor;
    this.camera=camera;
}

public Telefon(Telefon a){ //constructor de copiere
    super(a);
    this.procesor=a.procesor;
    this.camera=a.camera;
}
}
