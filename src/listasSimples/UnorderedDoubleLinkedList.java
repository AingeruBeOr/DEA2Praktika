package listasSimples;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) {
	// hasieran gehitu
		Node<T> berria=new Node<T>(elem);
		Node<T> hurrengoa= last.next;
		berria.next=hurrengoa;
		hurrengoa.prev=berria;
		berria.prev=last;
		last.next=berria;
		count++;
		// KODEA OSATU ETA KOSTUA KALKULATU

	}

	public void addToRear(T elem) {
	// bukaeran gehitu
		Node<T> berria=new Node<T>(elem);
		berria.next=last.next;
		berria.prev=last;
		last.next=berria;
		last.next.prev=berria;
		last=berria;
		count++;
		// KODEA OSATU ETA KOSTUA KALKULATU

	}
	
	public void addAfter(T elem, T target) {
		// KODEA OSATU ETA KOSTUA KALKULATU (AUKERAZKOA)
		if(super.contains(target)){
			Node<T> unekoa=last;
			while (!unekoa.data.equals(target)){
				unekoa=unekoa.next;
			}
			if (unekoa==last){
				this.addToRear(elem);
			}else{
				Node<T> berria=new Node<T>(elem);
				Node<T> hurrengoa=unekoa.next;
				berria.next=hurrengoa;
				hurrengoa.prev=berria;
				berria.prev=unekoa;
				unekoa.next=berria;
				count++;
			}
		}else{
			System.out.println("Ezin da gehitu."+target+" ez baita existitzen.");
		}
	}

}
