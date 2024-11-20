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

public Telefon(String brand, int marime_ecran,int camera, String procesor){ //constructor cu toate argumentele
    super(brand,marime_ecran);
    this.procesor=procesor;
    this.camera=camera;
}

public Telefon(Dispozitiv_mobil other){ //constructor de copiere
    
}
}
