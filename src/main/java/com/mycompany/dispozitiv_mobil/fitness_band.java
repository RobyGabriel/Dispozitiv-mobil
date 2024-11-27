package com.mycompany.dispozitiv_mobil;

/**
 *
 * @author Manea Robert-Gabriel
 */
public class fitness_band extends Dispozitiv_mobil
{
    String model;
    String senzor;
    String rezistentaApa;
    int pasiInregistrati;
    int caloriiArse;
    boolean monitorizareSomn;
    final int TVA = 19;
    protected double pretTVA;

public fitness_band() //constructor fara argumente
{
    super();
    this.model="";
    this.senzor="";
    this.rezistentaApa="";
    this.pasiInregistrati=0;
    this.caloriiArse=0;
    this.monitorizareSomn=false;
}

public fitness_band(String Brand, String model, double marimeEcran, double pret, int baterie, String senzor, String rezistentaApa, int pasiInregistrati, int caloriiArse, boolean monitorizareSomn) //constructor cu toate argumentele
{
    super(Brand, marimeEcran,pret,baterie);
    this.model=model;
    this.senzor=senzor;
    this.rezistentaApa=rezistentaApa;
    this.pasiInregistrati=pasiInregistrati;
    this.caloriiArse=caloriiArse;
    this.monitorizareSomn=monitorizareSomn;
}

public fitness_band(fitness_band other) //constructor de copiere
{
    super(other);
    this.model=other.model;
    this.senzor=other.senzor;
    this.rezistentaApa=other.rezistentaApa;
    this.pasiInregistrati=other.pasiInregistrati;
    this.caloriiArse=other.caloriiArse;
    this.monitorizareSomn=other.monitorizareSomn;
}

public String getModel() 
{
        return model;
    }

    // Setter for model
    public void setModel(String model) 
    {
        this.model = model;
    }

    // Getter for senzor
    public String getSenzor()
    {
        return senzor;
    }

    // Setter for senzor
    public void setSenzor(String senzor)
    {
        this.senzor = senzor;
    }

    // Getter for rezistentaApa
    public String getRezistentaApa()
    {
        return rezistentaApa;
    }

    // Setter for rezistentaApa
    public void setRezistentaApa(String rezistentaApa) 
    {
        this.rezistentaApa = rezistentaApa;
    }

    // Getter for pasiInregistrati
    public int getPasiInregistrati() 
    {
        return pasiInregistrati;
    }

    // Setter for pasiInregistrati
    public void setPasiInregistrati(int pasiInregistrati)
    {
        this.pasiInregistrati = pasiInregistrati;
    }

    // Getter for caloriiArse
    public int getCaloriiArse() 
    {
        return caloriiArse;
    }

    // Setter for caloriiArse
    public void setCaloriiArse(int caloriiArse) 
    {
        this.caloriiArse = caloriiArse;
    }

    // Getter for monitorizareSomn
    public boolean isMonitorizareSomn() 
    {
        return monitorizareSomn;
    }

    // Setter for monitorizareSomn
    public void setMonitorizareSomn(boolean monitorizareSomn) 
    {
        this.monitorizareSomn = monitorizareSomn;
    }
    
@Override
public String toString() //rescriere toString
{
    return "Brand: " + Brand + "\nModel: " + model + "\nMarimea ecranului: " + marimeEcran + " inch" + "\nBaterie: " + baterie + " mAh" + "\nSenzor: " + senzor + "\nPret: " + pret + "lei" + "\nRezistenta apa: " + rezistentaApa + "\nPasi inregistrati " + pasiInregistrati + "\nCalorii arse: " + caloriiArse + "\nMonitorizare somn: " + (monitorizareSomn ? "Da\n" : "Nu\n");
}

@Override
    public double calcularePret() {
        pretTVA = pret * ((pret * TVA) / 100);
        return pretTVA;
    }

    public void pretDupaTVA() {
        pretTVA = pret * ((pret * TVA) / 100);
        System.out.println(pretTVA);
    }
}