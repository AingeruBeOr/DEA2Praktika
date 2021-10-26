package proiekt1;

import listasSimples.UnorderedDoubleLinkedList;

import java.util.ArrayList;
import java.util.Iterator;

public class ListaPelikulak {
    private UnorderedDoubleLinkedList<Pelikula> lista;

    public ListaPelikulak()
    {
        this.lista=new UnorderedDoubleLinkedList();
    }

    public boolean badago(Pelikula pIzen){
        return this.lista.contains(pIzen);
    }

    /*public void inprimatu()
    {
        Iterator<Pelikula> itr= this.lista.iterator();
        Pelikula p=null;
        while (itr.hasNext())
        {
            p= itr.next();
            System.out.println(p.getIzena());
        }
    }*/

    public void gehituPelikula(Pelikula p) {
            this.lista.addToRear(p);
    }

    @Override
    public String toString() {
        String emaitza=null;
        Iterator<Pelikula> itr=this.lista.iterator();
        if(itr.hasNext()){ //lista hutsa ez bada. Hau egin behar da emaitza null-ekin hasieratu dugulako
            emaitza=itr.next().getIzena();
        }
        while (itr.hasNext()){ //listak elementu bat baino gehiago badu
            emaitza=emaitza+ " ##### ";
            emaitza=emaitza+(itr.next().getIzena());
        }
        if(emaitza==null){
            return "(Aktore honek ez dauka pelikularik)";
        } else {
            return emaitza;
        }
    }
}