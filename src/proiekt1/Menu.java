package proiekt1;

import java.util.Iterator;
import java.util.Scanner;
import java.io.*;
import java.util.HashMap;

public class Menu {
    private static ListaAktoreak listaA;
    //Bi HashMap dauden pelikula eta aktore guztiak gordetzen dituztenak:
    private static HashMap<String, Aktorea> lA; //Aktoreen katalogoa
    private static HashMap<String, Pelikula> lP; //Pelikulen katalogoa



    public static void main(String[] args){
        lA=new HashMap<String, Aktorea>();
        lP=new HashMap<String, Pelikula>();
        listaA=new ListaAktoreak();
        int e;
        do{
            e= menuaInprmimatu();
        }while(e!=9);
    }

    private static void listaIrakurri(){
        String helbide="datu_basea"+File.separator+"FilmsActors20212022.txt";
        try{
            Scanner sarrera = new Scanner(new FileReader(helbide)); //"sarrera" aldagaiak datu-basea izango du testu moduan
            String linea;
            while (sarrera.hasNext()) {//O(n), n:"pelikula kopurua"
                linea = sarrera.nextLine(); //"linea" aldagaiak, pelikula bakoitza eta bere aktoreak izango ditu
                String[] parts=linea.split(" --->>> "); //"parts" array-a, bi elementu izango ditu. 1: pelikularen izena. 2: aktore guztiak
                if (!lP.containsKey(parts[0])) { //TODO no se puede hacer algo para ponerlo fuera porque sino el coste es lineal??
                    Pelikula p = new Pelikula(parts[0]); //kontuan izan behar da pelikula hori oraindik ez dela sortu, hau da, fitxategian ez daude bi pelikula errepikatuta baina bai aktoreak
                    lP.put(parts[0], p);
                    String[] aktoreLista = parts[1].split(" ##### "); //"aktoreLista" array-ak, p Pelikula-ren aktore guztiak gordeko ditu
                    for (int i = 0; i < aktoreLista.length; i++) { //O(m), m:"pelikula bakoitzeko aktore kopurua"
                        if (!lA.containsKey(aktoreLista[i])) { //O(1) listan Aktorea oraindik ez bada agertzen, aktore berria sortu behar da. HashMap erabiltzen da bilaketa, kostu konstantea izateko.
                            Aktorea a = new Aktorea(aktoreLista[i]);
                            a.gehituPelikula(p); //O(1)
                            lA.put(aktoreLista[i], a); //O(1)
                            listaA.gehituAktorea(a); //O(1)
                        } else {
                            lA.get(aktoreLista[i]).gehituPelikula(p);
                        }
                        //aktoreari pelikula gehitu behar zaio (listan jada badago edo ez badago)
                        //O(1) HashMap-ean egin da azkarrago topatzeko
                    }
                }
            }
            sarrera.close();
            System.out.println("Datu basea ondo kargatu da.");
        }
        catch(IOException e) {
            System.out.println("Errorea lista kargatzean");
            e.printStackTrace();}
    }

    private static int menuaInprmimatu(){
        System.out.println("\n\n\n\n---HASIERAKO MENUA---\n" +
                "Hautatu aukerak:\n"+
                "   0: Datu basea kargatu\n"+
                "   1: Aktorea bilatu\n"+
                "   2: Aktorea gehitu\n"+
                "   3: Aktore baten pelikuak bueltatu\n"+
                "   4: Pelikula baten aktoreak bueltatu\n"+
                "   5: Pelikula baten dirua gehitu\n"+
                "   6: Aktore bat ezabatu\n"+
                "   7: Aktoreen zerrenda fitxategi batean gorde\n"+
                "   8: Aktoreen zerrenda ordenatua lortu\n"+
                "   9: Amaitu programa"
        );
        return aukeraIrakurri();
    }

    private static int aukeraIrakurri(){
        int erantzuna;
        boolean denaOK;
        do{
            denaOK=true;
            erantzuna=osokoaIrakurri();
            switch (erantzuna){
                case 0://datu basea kargatu
                    System.out.println("Itxaron 30 segundo lista kargatu arte");
                    listaIrakurri();
                    break;
                case 1://aktorea bilatu
                    String eran=stringIrakurri("Sartu bilatu nahi duzun aktorearen izena (abizena, izena)");
                    if(lA.containsKey(eran)) System.out.println(eran+" aurkitu da");
                    else System.out.println("Ez da exisititzen "+eran);
                    break;
                case 2://aktorea gehitu
                    String eran2=stringIrakurri("Sartu gehitu nahi duzun aktorearen izena (abizena, izena)");
                    if(!lA.containsKey(eran2)){
                        Aktorea ak=new Aktorea(eran2);
                        lA.put(eran2, ak); //HashMap-ean sartu
                        listaA.gehituAktorea(ak); //lista-n sartu
                    } else System.out.println("Jadanik existitzen da aktore hori");
                    break;
                case 3://aktore baten pelikulak bueltatu
                    String eran3=stringIrakurri("Sartu aktorearen izena (abizena, izena)");
                    if(lA.containsKey(eran3)) {
                        Aktorea akt = lA.get(eran3);
                        //System.out.println(eran3+" aktorearen pelikulak hauek dira:");
                        akt.lortuAktorearenPeli();//.inprimatu();
                    }
                    else System.out.println("Ez da exisititzen aktorerik izen horrekin.");
                    break;
                case 4://pelikula baten aktoreak bueltatu
                    String eran31=stringIrakurri("Sartu pelikula bat");
                    if(lP.containsKey(eran31)){
                        //System.out.println(eran31+" pelikularen aktoreak hauek dira:");
                        listaA.pelikularenAktoreak(lP.get(eran31));//.inprimatu();
                    } else System.out.println("Ez da exisistitzen pelikularik izen horrekin");
                    break;
                case 5://pelikula baten dirua gehitu
                    String eran4=stringIrakurri("Sartu pelikularen izena");
                    Pelikula pelikula=lP.get(eran4);
                    if(pelikula!=null){
                        System.out.println("Sartu pelikularen dirua");
                        int eran41=osokoaIrakurri();
                        pelikula.setDirua(eran41);
                    }
                    else System.out.println("Ez da exisititzen pelikularik izen horrekin.");
                    break;
                case 6://aktorea ezabatu
                    String eran5=stringIrakurri("Sartu ezabatu nahi duzun aktorearen izena (abizena, izena)");
                    if(lA.containsKey(eran5)) {
                        listaA.aktoreaEzabatu(lA.get(eran5));
                        lA.remove(eran5);
                        System.out.println(eran5+" listatik ezabatu da.");
                    }
                    else System.out.println("Ez da exisititzen aktorerik izen horrekin.");
                    break;
                case 7://aktoreen zerrenda fitxategi batean gorde
                    listaA.fitxategiaSortu();
                    break;
                case 8://aktoreen zerrenda ordenatua lortu
                    listaA.ordenatu();
                    break;
                case 9://amaitu programa
                    System.out.println("Agur");
                    System.exit(0);
                    break;
                default:
                    denaOK=false;
                    System.out.println("Sartu zenbaki egoki bat");
                    break;
            }
        }while(!denaOK);
        return erantzuna;
    }

    private static String stringIrakurri(String pAurrekoMezua){
        System.out.println(pAurrekoMezua);
        Scanner scan=new Scanner(System.in);
        return scan.nextLine();
    }

    private static int osokoaIrakurri(){
        Scanner sc=new Scanner(System.in);
        String scan;
        int erantzuna=0;
        boolean ondo=false;
        do{
            try {
                scan=sc.nextLine();
                erantzuna=Integer.parseInt(scan);
                ondo=true;
            } catch (NumberFormatException e){
                System.out.println("Zenbakia ez den zerbait sartu duzu. Sartu zenbaki bat, mesedez");
            }
        }while(!ondo);
        return erantzuna;
    }
}
