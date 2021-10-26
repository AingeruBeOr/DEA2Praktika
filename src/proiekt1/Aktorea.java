package proiekt1;

public class Aktorea implements Comparable<Aktorea>{
    private final String izena;
    private ListaPelikulak pelikulak;

    public Aktorea(String pIzen) {
        this.izena=pIzen;
        this.pelikulak=new ListaPelikulak();
    }
    public String getIzena() {
        return izena;
    }

    public void gehituPelikula(Pelikula p) {
        this.pelikulak.gehituPelikula(p);
    }

    public ListaPelikulak lortuAktorearenPeli(){
        return this.pelikulak;
    }

    /**
     * Aktoreak izenaren arabera ordenatuko dira.
     * @param o
     * @return
     */
    @Override
    public int compareTo(Aktorea o) {
        return this.izena.compareTo(o.izena);
    }

    public boolean pelikulaDauka(Pelikula pPelikula) {
        return this.pelikulak.badago(pPelikula);
    }
}