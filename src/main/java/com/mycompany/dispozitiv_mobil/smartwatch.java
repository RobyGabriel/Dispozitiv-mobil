package com.mycompany.dispozitiv_mobil;

public class smartwatch extends Dispozitiv_mobil{

    String culoare;
    int baterie;
    String tip_ecran;
    String rez_apa;

    public smartwatch() {
        super();
        culoare = "";
        baterie = 0;             //constructor fara argumente
        tip_ecran = "";
        rez_apa = "";
    }

    public smartwatch(String brand, int marime_ecran, String culoare, int baterie, String tip_ecran, String rez_apa) {
        super(brand, marime_ecran);
        this.culoare = culoare;
        this.baterie = baterie;             //constructor cu toate argumentele
        this.tip_ecran = tip_ecran;
        this.rez_apa = rez_apa;
    }

    public smartwatch(smartwatch A) { //constructor de copiere
        super(A);
        this.culoare = A.culoare;
        this.baterie = A.baterie;
        this.tip_ecran = A.tip_ecran;
        this.rez_apa = A.rez_apa;
    }
}