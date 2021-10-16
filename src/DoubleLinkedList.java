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
		if(!this.isEmpty()){ //lista hutsa badago ez da ezer egin behar
			if(this.size()==1){ //elementu bakarra badago last null-eri begiratu
				this.last=null;
			}
			//TODO
		}
	}

	public T removeLast() {
	// listako azken elementua kendu da
	// Aurrebaldintza: 
		// KODEA OSATU ETA KOSTUA KALKULATU
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
		      if (isEmpty())
		          return false;

		      		// KODEA OSATU ETA KOSTUA KALKULATU
		   }

	public T find(T elem) {
	// Elementua bueltatuko du aurkituz gero, eta null bestela

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
			return "DoubleLinkedList " + result + "]";
		}

}
