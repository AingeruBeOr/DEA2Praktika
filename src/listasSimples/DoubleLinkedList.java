package listasSimples;

import listasSimples.Node;

import java.util.Iterator;


public class DoubleLinkedList<T> implements ListADT<T> {

	// Atributuak
	protected Node<T> last;  // azkenengoaren erreferentzia
	protected String deskr;  // deskribapena
	protected int count; // elementu kopurua

	public DoubleLinkedList() {
		last = null;
		deskr = "";
		count = 0;
	}
	
	public void setDeskr(String izena) {
	  this.deskr = izena;
	}

	public String getDeskr() {
	  return this.deskr;
	}

	/**
	 * Aurrebaldintza:
	 * listako lehen elementua kendu da
	 * @return
	 */
	public T removeFirst() {
		// KODEA OSATU ETA KOSTUA KALKULATU
		T emaitza=null;
		if(!this.isEmpty()){ //lista hutsa badago ez da ezer egin behar
			emaitza=last.next.data;
			if(count==1){ //elementu bakarra badago last null-eri begiratu
				this.last=null;
			}else{
				Node<T> unekoa= last.next.next;
				last.next=unekoa;
				unekoa.prev=last;
			}
			count--;	//count atrib eguneratu
		}return emaitza;
	}

	public T removeLast() {
		// KODEA OSATU ETA KOSTUA KALKULATU
		T emaitza=null;
		if (!this.isEmpty()) {
			emaitza=last.data;
			if (count == 1) { //elementu bakarra badago last null-eri begiratu
				this.last = null;
			} else {
				Node<T> aurrekoa = last.prev;
				last.next.prev = aurrekoa;
				aurrekoa.next = last.next;
				last = aurrekoa;    //last eguneratu
			}
			count--; //count atrib eguneratu
		}
		return emaitza;
    }


	/**
	 *  Aurrebaldintza:
	 * 	 Balio hori listan baldin badago, bere lehen agerpena ezabatuko dut. Kendutako objektuaren erreferentzia
	 *           bueltatuko du (null ez baldin badago)
	 * @param elem
	 * @return
	 */
	public T remove(T elem) {
		// KODEA OSATU ETA KOSTUA KALKULATU
		Node<T> unekoa=last.next;
		Node<T> aurrekoa;
		if (!this.contains(elem)){
			return null;
		}else{
			while (!unekoa.data.equals(elem)) {
				unekoa = unekoa.next;
			}if (unekoa==last) {
				this.removeLast();
			}else {
				aurrekoa = unekoa.prev;
				unekoa.next.prev=aurrekoa;
				aurrekoa.next=unekoa.next;
				return unekoa.data;
			}
		}
	}

	/**
	 *
	 * @return listako lehen elementua ematen du
	 */
	public T first() {
	      if (isEmpty())
	          return null;
	      else return last.next.data;
	}

	/**
	 *
	 * @return listako azken elementua ematen du
	 */
	public T last() {
	      if (isEmpty())
	          return null;
	      else return last.data;
	}

	public boolean contains(T elem) {
	// Egiazkoa bueltatuko du aurkituz gero, eta false bestela
		      if (isEmpty() || elem == null) {
				  return false;
			  }else{
				  Node<T> unekoa= last;
				  boolean barruan=false;
				  while (unekoa!=last || !barruan){
					  barruan=true;
					  if(unekoa.data.equals(elem)){
						  return true;
					  }
					 unekoa=unekoa.next;
				  }
				  if (unekoa==last && barruan){		//elem ez badago
					  return false;
				  }
			  }
		      		// KODEA OSATU ETA KOSTUA KALKULATU
		   }

	public T find(T elem) {
		// Elementua bueltatuko du aurkituz gero, eta null bestela
		Node<T> unekoa=last.next;
		if (!contains(elem)){	//elem ez badago
			return null;
		}else{
			while (!unekoa.data.equals(elem)) {
				unekoa = unekoa.next;
			}return unekoa.data;
		}


		// KODEA OSATU ETA KOSTUA KALKULATU
	}

	public boolean isEmpty() { return last == null;}
	
	public int size() { return count;}
	
	/** Return an iterator to the stack that iterates through the items . */ 
	   public Iterator<T> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> { 

		// KODEA OSATU 
	   } // private class
		
		
		public void adabegiakInprimatu() {
			System.out.println(this.toString());
		}

		
		@Override
		public String toString() {
			String result = new String();
			Iterator<T> it = iterator();
			while (it.hasNext()) {
				T elem = it.next();
				result = result + "[" + elem.toString() + "] \n";
			}	
			return "listasSimples.DoubleLinkedList " + result + "]";
		}

}
