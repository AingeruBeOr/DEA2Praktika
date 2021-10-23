package listasSimples;

public class OrderedDoubleLinkedList<T extends Comparable<T>> extends DoubleLinkedList<T>  implements OrderedListADT<T>  {

	public void add(T elem){
		// KODEA OSATU ETA KOSTUA KALKULATU
		Node<T> unekoa=last;
		Node<T> aurrekoa;
		Node<T> berria= new Node<T>(elem);
		boolean pasa=false;
		if (elem!=null){
			if (last==null){	//orain arte lista hutsa
				last=berria;
				last.next=last;	//Node<T>-ren atrib eguneratu
				last.prev=last;
			}else{
				while((unekoa!=last|| !pasa) && unekoa.data.compareTo(elem) >=0  ){	//unekoa-elem
					pasa=true;
					unekoa=unekoa.next;
				}
				if (unekoa==last && pasa){	//azken posizioan sartu behar
					aurrekoa=unekoa;
					unekoa=unekoa.next;	//first dagoen elem hartu
					last=berria;
				}else{	// aurrekoa-elem-unekoa
					aurrekoa= unekoa.prev;
				}
				aurrekoa.next=berria;
				berria.prev=aurrekoa;
				berria.next=unekoa;
				unekoa.prev=berria;
			}
			count++;
		}

	}

	public void merge(DoubleLinkedList<T> zerrenda){
		// KODEA OSATU ETA KOSTUA KALKULATU
		mergeSort(zerrenda, 0, zerrenda.count-1);
	}
	private void mergeSort(DoubleLinkedList<T> z, int hasiera, int bukaera){
		if (hasiera<bukaera){
			mergeSort(z, hasiera, (hasiera+bukaera)/2);
			mergeSort(z, ((hasiera+bukaera)/2)+1, bukaera);
			bateratze(z, hasiera, (hasiera+bukaera)/2, bukaera);
		}
	}
	private void bateratze(DoubleLinkedList<T> z, int i, int erdikoa, int f){
		DoubleLinkedList<T> bateratua=new DoubleLinkedList<T>();
		DoubleLinkedList<T> eskuin=new DoubleLinkedList<T>();
		Node<T> pos=z.last.next;
		for(int j=0; j<=erdikoa; j++){
			pos=pos.next;
		}
		Node<T> gorde=pos.prev;
		Node<T> berria=new Node<>(pos.data);
		eskuin.last=berria;
		pos=pos.next;
		while(pos!=null){
			berria=new Node<>(pos.data);
			berria.prev= eskuin.last;
			berria.next=last.next;
			last.next=berria;
			berria.next.prev=berria;
			last=berria;
			pos=pos.next;
		}
		z.last.next.prev=gorde;
		gorde.next= z.last.next;
		gorde=z.last;
		int eskuin=erdikoa+1;
		int k=0; //bateratua taula betetzeko indizea
		while(ezker<=erdikoa &&eskuin<=f){
			if(z)
		}
	}


}
