package proiekt1;

public class Pelikula {
    private String izenburua;
    private int dirua;

    public Pelikula(String pIzen) {
        this.izenburua = pIzen;
        this.dirua = 0;
    }

    public String getIzena() {return this.izenburua;}

    public void setDirua(int pDiru) {this.dirua=pDiru;}
}
