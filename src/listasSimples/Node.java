package listasSimples;

public class Node<T> {
		public T data; 			// dato del nodo
		public Node<T> next; 	// puntero al siguiente nodo de la lista
		public Node<T> prev; 	// puntero al anterior nodo de la lista
		// -------------------------------------------------------------

		public Node(T dataa) 		// constructor
		{
			data = dataa;
			next = null;
			prev = null;
		}
}