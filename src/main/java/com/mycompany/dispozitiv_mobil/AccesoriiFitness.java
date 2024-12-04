package com.mycompany.dispozitiv_mobil;

/**
 *
 * @author Manea Robert-Gabriel
 */
public class AccesoriiFitness extends Dispozitiv_mobil {

    String tipAccesoriu;
    String culoareBratara;
    String tipCataramaBratara;
    boolean cureaAjustabila;
    String tipIncarcator;
    final int TVA = 19;
    protected double pretTVA;

    public AccesoriiFitness()
    {
        super();
        this.tipAccesoriu = "";
        this.culoareBratara = "";
        this.tipCataramaBratara = "";
        this.cureaAjustabila = false;
        this.tipIncarcator = "";
    }

    public AccesoriiFitness(String Brand, double marimeEcran, double pret, int baterie, String tipAccesoriu, String culoareBratara, String tipCataramaBratara, boolean cureaAjustabila, String tipIncarcator)
    {
        super(Brand, marimeEcran, pret, baterie);
        this.tipAccesoriu = tipAccesoriu;
        this.culoareBratara = culoareBratara;
        this.tipCataramaBratara = tipCataramaBratara;
        this.cureaAjustabila = cureaAjustabila;
        this.tipIncarcator = tipIncarcator;
    }

    public AccesoriiFitness(AccesoriiFitness other) 
    {
        super(other);
        this.tipAccesoriu = other.tipAccesoriu;
        this.culoareBratara = other.culoareBratara;
        this.tipCataramaBratara = other.tipCataramaBratara;
        this.cureaAjustabila = other.cureaAjustabila;
        this.tipIncarcator = other.tipIncarcator;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public double getMarimeEcran() {
        return marimeEcran;
    }

    public void setMarimeEcran(double marime_ecran) {
        this.marimeEcran = marime_ecran;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getBaterie() {
        return baterie;
    }

    public void setBaterie(int baterie) {
        this.baterie = baterie;
    }

    public String getTipAccesoriu() {
        return tipAccesoriu;
    }

    public void setTipAccesoriu(String tipAccesoriu) {
        this.tipAccesoriu = tipAccesoriu;
    }

    public String getCuloareBratara() {
        return culoareBratara;
    }

    public void setCuloareBratara(String culoareBratara) {
        this.culoareBratara = culoareBratara;
    }

    public String getTipCataramaBratara() {
        return tipCataramaBratara;
    }

    public void setTipCataramaBratara(String tipCataramaBratara) {
        this.tipCataramaBratara = tipCataramaBratara;
    }

    public boolean isCureaAjustabila() {
        return cureaAjustabila;
    }

    public void setCureaAjustabila(boolean cureaAjustabila) {
        this.cureaAjustabila = cureaAjustabila;
    }

    public String getTipIncarcator() {
        return tipIncarcator;
    }

    public void setTipIncarcator(String tipIncarcator) {
        this.tipIncarcator = tipIncarcator;
    }

    @Override
    public String toString()
    {
        return "Brand: " + Brand + "\nMarimea ecranului: " + marimeEcran + "\nPret: " + pret + "\nTip accesoriu: " + tipAccesoriu + "\nCuloare bratara: " + culoareBratara + "\nTip catarama bratara: " + tipCataramaBratara + "\nCurea ajustabila: " + (cureaAjustabila ? "Da" : "Nu") + "\nTip incarcator: " + tipIncarcator + "\n";
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
