package listasSimples;

public interface OrderedListADT<T>  extends ListADT<T> {
	
	public void add(T elem);
	// elementu bat gehitzen du listan (dagokion tokian)

	public void merge(DoubleLinkedList<T> zerrenda);

}
