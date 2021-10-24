package listasSimples;

public class OrderedDoubleLinkedList<T extends Comparable<T>> extends DoubleLinkedList<T>  implements OrderedListADT<T>  {

	/**
	 * Pasatzen zaion elementua ordenean gehituko du zerrendan.
	 * @param elem
	 */
	public void add(T elem){
		// KODEA OSATU ETA KOSTUA KALKULATU
		if (elem!=null){ //TODO beharrezko da hau konprobatzea
			Node<T> berria= new Node<>(elem);
			if (last==null){	//orain arte lista hutsa
				last=berria;
				last.next=last;	//Node<T>-ren atrib eguneratu
				last.prev=last;
			}else{
				Node<T> unekoa=last.next;
				Node<T> aurrekoa;
				boolean pasa=false;
				while((unekoa!=last|| !pasa) && unekoa.data.compareTo(elem) <=0  ){	//unekoa-elem
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

	/**
	 * Parametro bezala pasatzen zaion zerrendako elementu guztiak, zerrendan gehituko dira
	 * @param zerrenda: DoubleLinkedList motako elementu bat (elementuak txikienetik handienera ordenatuta daude)
	 */
	public void merge(DoubleLinkedList<T> zerrenda) {
		// KODEA OSATU ETA KOSTUA KALKULATU
		//TODO ondo dago??????
		if(!zerrenda.isEmpty()){
			if (last != null) {
				Node<T> unekoaParam = zerrenda.last.next;
				Node<T> unekoa = last.next;
				boolean bukatu=false;
				while(!bukatu){
					while (unekoaParam.data.compareTo(unekoa.data) <= 0 && unekoa != last) {
						unekoa = unekoa.next;
					}
					Node<T> berria = new Node<>(unekoaParam.data);
					if(unekoa!=last){ //azkeneko elementura heldu bada, elementu guztiak unekoaParam.data baino txikiagoak direla esan nahi du
						berria.prev=unekoa;
						berria.next=unekoa.next;
						unekoa.next.prev=berria;
						unekoa.next=berria;
						last=berria;
					} else{ //unekoa baino lehen txertatu behar da
						berria.next = unekoa;
						berria.prev = unekoa.prev;
						unekoa.prev.next = berria;
						unekoa.prev = berria;
					}
					count++;
					if(unekoaParam!= zerrenda.last){
						unekoaParam=unekoaParam.next;
					} else{
						bukatu=true;
					}
				}
			} else{
				last=zerrenda.last;
				count+=zerrenda.size();
			}
		}
	}
}
