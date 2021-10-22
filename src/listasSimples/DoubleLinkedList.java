package listasSimples;

import listasSimples.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;


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
				last.next=last.next.next;
				last.next.prev=last;
			}
			count--;	//count atrib eguneratu
		} return emaitza;
	}

	public T removeLast() {
		// KODEA OSATU ETA KOSTUA KALKULATU
		T emaitza=null;
		if (!this.isEmpty()) {
			emaitza=last.data;
			if (count == 1) { //elementu bakarra badago last null-eri begiratu
				this.last = null;
			} else {
				last=last.prev;
				last.next=last.next.next;//last eguneratu
				last.next.prev=last;
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
		T emaitza=null;
		if (this.contains(elem)){
			while (!unekoa.data.equals(elem)) {
				unekoa = unekoa.next;
			}if (unekoa==last) {
				emaitza=last.data;
				this.removeLast();
			}else {
				emaitza= unekoa.data;
				aurrekoa = unekoa.prev;
				unekoa.next.prev=aurrekoa;
				aurrekoa.next=unekoa.next;
			}
			count--;
		}
		return emaitza;
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
		      		// KODEA OSATU ETA KOSTUA KALKULATU
		boolean emaitza=false;
		      if (!isEmpty() && elem != null) {
				  Node<T> unekoa= last;
				  boolean barruan=false;
				  while ((unekoa!=last || !barruan) && !emaitza){
					  barruan=true;
					  if(unekoa.data.equals(elem)){
						  emaitza= true;
					  }
					 unekoa=unekoa.next;
				  }
			  }
			  return emaitza;
		   }

	public T find(T elem) {
		// KODEA OSATU ETA KOSTUA KALKULATU
		// Elementua bueltatuko du aurkituz gero, eta null bestela
		Node<T> unekoa=last.next;
		T emaitza=null;
		if (contains(elem)){	//elem ez badago
			while (!unekoa.data.equals(elem)) {
				unekoa = unekoa.next;
			}
			emaitza=unekoa.data;
		}
		return emaitza;
	}

	public boolean isEmpty() { return last == null;}
	
	public int size() { return count;}
	
	/** Return an iterator to the stack that iterates through the items . */ 
	   public Iterator<T> iterator() { return new ListIterator(); } 

	   // an iterator, doesn't implement remove() since it's optional 
	   private class ListIterator implements Iterator<T> {

		   private Node<T> unekoa;
		   private boolean lehenengoAldia;

		   public ListIterator (){
			   lehenengoAldia = false;
			   unekoa = last.next;
		   }

		   @Override
		   public boolean hasNext() {
			   boolean emaitza=true;
			   if(unekoa == last.next && lehenengoAldia){
				   emaitza = false;
			   }
			   lehenengoAldia = true;
			   return emaitza;
		   }

		   @Override
		   public T next() {
			   if(!hasNext()){
				   throw new NoSuchElementException();
			   }
			   T emaitza = unekoa.data;
			   unekoa = unekoa.next;
			   return emaitza;
		   }

		   // KODEA OSATU
	   }
		
		
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
