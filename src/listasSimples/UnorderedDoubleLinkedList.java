package listasSimples;

public class UnorderedDoubleLinkedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) { // hasieran gehitu
		// KODEA OSATU ETA KOSTUA KALKULATU
		Node<T> berria=new Node<T>(elem);
		if(!super.isEmpty()){ //super erabili da klase ama-n dagoelako metodo hau eta horrela java klase amatik hasten da bilatzen eta ez klase honetatik
			berria.next=last.next;
			berria.prev=last;
			last.next=berria;
			berria.next.prev=berria;
		} else{
			last=berria;
			berria.next=berria;
			berria.prev=berria;
		}
		count++;
	}

	public void addToRear(T elem) { // bukaeran gehitu
		// KODEA OSATU ETA KOSTUA KALKULATU
		Node<T> berria=new Node<T>(elem);
		if(!super.isEmpty()){
			berria.next=last.next;
			berria.prev=last;
			last.next=berria;
			berria.next.prev=berria;
			last=berria;
		} else{
			last=berria;
			berria.next=berria;
			berria.prev=berria;
		}
		count++;
	}
	
	public void addAfter(T elem, T target) {
		// KODEA OSATU ETA KOSTUA KALKULATU (AUKERAZKOA)
		if(super.contains(target)){ //TODO enuntziatuan esaten du target zerrendan dagoela, ezta? Beraz, ere ez da konpronatu behar lista hutsa den, ezta?
			Node<T> unekoa=last;
			while (!unekoa.data.equals(target)){
				unekoa=unekoa.next;
			}
			if (unekoa==last){
				this.addToRear(elem);
			}else{
				Node<T> berria=new Node<T>(elem);
				berria.next=unekoa.next;
				berria.prev=unekoa;
				unekoa.next.prev=berria;
				unekoa.next=berria;
				count++;
			}
		}else{ //TODO enuntziatuan esaten du target zerrendan dagoela, ezta?
			System.out.println("Ezin da gehitu."+target+" ez baita existitzen.");
		}
	}

}
