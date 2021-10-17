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



	}


}
