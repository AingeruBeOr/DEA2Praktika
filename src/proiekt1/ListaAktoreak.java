package proiekt1;

import listasSimples.DoubleLinkedList;
import listasSimples.Node;
import listasSimples.OrderedDoubleLinkedList;
import listasSimples.UnorderedDoubleLinkedList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class ListaAktoreak {
    private UnorderedDoubleLinkedList<Aktorea> lista;


    public ListaAktoreak()
    {
        this.lista=new UnorderedDoubleLinkedList<Aktorea>();
    }


    /*public void inprimatu(){
        for (int i=0; i<kopurua; i++){
            System.out.println(lista[i].getIzena());
        }
    }*/

    public void gehituAktorea(Aktorea pA) {
        this.lista.addToRear(pA);
    }


    /**
     * Aurrebaldintza: metodo hau deitu baino lehen, pIzen Aktorea exisititzen dela konprobatuta dago
     * @param pAktore ezabatu nahi den Aktorea da.
     * @return ezabatu den Aktorea bueltatzen da.
     */
    public Aktorea aktoreaEzabatu(Aktorea pAktore) {
        return (Aktorea) this.lista.remove(pAktore);
    }

    /**
     * quickSort algoritmoa erabiliz ordenatuko da lista. Aktoreen izen abizenen arabera ordenatuko da.
     * Kostu-funtzioa O(n*log_2(n)) izango da; non n, aktoreen kopurua den. Datu kopurua hain handia denez,
     * ezin da erabili O(n^2) kostu funtzioa dute algoritmorik denbora gehiegi behar izango zuketeelako.
     */


    public void ordenatu(){
        Iterator<Aktorea> it= this.lista.iterator();
        Aktorea unekoa;
        int i=0;
        Aktorea[] l=new Aktorea[this.lista.size()];
        while(it.hasNext()){
            unekoa=it.next();
            l[i]=unekoa;
            i++;
        }
        quickSort(l,0,l.length-1);
        UnorderedDoubleLinkedList<Aktorea> ema= new UnorderedDoubleLinkedList<>();
        for(int j=0; l.length>j; j++){
            ema.addToRear(l[j]);
        }
        this.lista=ema;
    }

    private void quickSort(Aktorea[] lista,int hasiera, int bukaera){
        if(hasiera<bukaera){
            int indizeaZatiketa=zatiketa(lista,hasiera,bukaera);
            if(indizeaZatiketa>hasiera){
                quickSort(lista,hasiera,indizeaZatiketa-1);
            }
            if(indizeaZatiketa<bukaera){
                quickSort(lista,indizeaZatiketa,bukaera);
            }
        }
    }

    /**
     * Zatiketa egiteko, pibotea ausaz aukeratzen da. Bestela, hasieratik hasten bada beti, lista ordenatua pasatzen
     * badiogu, O(n^2) bihurtzen da algoritmoaren kostua.
     * @param lista
     * @param i
     * @param j
     * @return
     */
    private int zatiketa(Aktorea[] lista,int i,int j){
        int random= (int)(Math.random()*(j-i+1))+i;
        Aktorea pibotea = lista[random];
        int ezkerra=i;
        int eskuina=j;

        while(ezkerra<eskuina) {
            while (ezkerra < eskuina && lista[ezkerra].compareTo(pibotea) <= 0) ezkerra++;
            while (ezkerra < eskuina && lista[eskuina].compareTo(pibotea) >= 0) eskuina--;
            if(ezkerra<eskuina){
                trukatu(lista,ezkerra,eskuina);
            }
        }
        if(lista[ezkerra].compareTo(pibotea)<0){
            trukatu(lista,random,ezkerra);
        }
        return ezkerra;
    }

    private void trukatu(Aktorea[] lista,int i, int j){
        Aktorea lag=lista[i];
        lista[i]=lista[j];
        lista[j]=lag;
    }

    public ListaAktoreak pelikularenAktoreak(Pelikula pPelikula) {
        ListaAktoreak listAkt = new ListaAktoreak();
        Iterator<Aktorea> itr = this.lista.iterator();
        Aktorea unekoa;
        while(itr.hasNext()){
            unekoa = itr.next();
            if(unekoa.pelikulaDauka(pPelikula)){
                listAkt.gehituAktorea(unekoa);
            }
        }
        return listAkt;
    }

    /**
     * Aktore guztiak bere pelikulekin inprimatuko dira. Horretarako FileWriter klasea erabiltzen da fitxategia sortzeko.
     * FileWriter-ekin fitxategian idatzi daiteke ere, horretarako metodo bat duelako baina karakterez karaktere idazten
     * du eta horrek moteldu egiten du algorimtoa. BufferWriter klasearekin, gutxinaka gutxinaka idazten da fitxategian
     * horrela eraginkortasuna asko handitzen da. Fitxategia exisistitzen bada, dagoen guztia ezabatzen da eta berriro
     * idazten da.
     */
    public void fitxategiaSortu(){
        FileWriter fitxategia;
        try{
            fitxategia=new FileWriter("aktoreenzerrenda.txt",false); //append=false eginez, ez da azkenean idazten; dena ezabatzen da eta berriro idazten da
            BufferedWriter bfwriter=new BufferedWriter(fitxategia);
            Iterator<Aktorea> itr = this.lista.iterator();//TODO
            Aktorea unekoa;
            while(itr.hasNext()){
                unekoa = itr.next();
                bfwriter.write("· "+unekoa.getIzena()+" --->>> " + unekoa.lortuAktorearenPeli().toString() +"\n");
            }
            bfwriter.close();
            System.out.println("Fitxategia sortu da.");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
