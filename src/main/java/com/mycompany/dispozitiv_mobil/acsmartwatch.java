package com.mycompany.dispozitiv_mobil;
public class acsmartwatch extends Dispozitiv_mobil{
    String tip_accesorii;
    
    public acsmartwatch() //constructor fara argumente
{
    super();
    tip_accesorii="";
}
    public acsmartwatch(String Brand, double marime_ecran, double pret, int baterie, String tip_accesorii)
{
    super(Brand, marime_ecran,pret,baterie);
    this.tip_accesorii=tip_accesorii;                //constructor cu toate argumentele
    
}
    
    public acsmartwatch(acsmartwatch A) { //constructor de copiere
        super(A);
        this.tip_accesorii=A.tip_accesorii;
        
    }
    
    
    
    
    
}
