import java.util.Iterator;

import listasSimples.*;
public class ProbaDoubleLinkedList {

	public static void adabegiakInprimatu(UnorderedDoubleLinkedList<Integer> l) {
		Iterator<Integer> it = l.iterator();
		System.out.println();
		while (it.hasNext()) {
			Integer num = it.next();
			System.out.println(num);
		}
	}
	
	
	public static void main(String[] args)  {
		
		UnorderedDoubleLinkedList<Integer> l =new UnorderedDoubleLinkedList<Integer>();
		l.addToRear(1);
		l.addToRear(3);
		l.addToRear(6);
		l.addToRear(7);
		l.addToRear(9);
		l.addToRear(0);
		l.addToRear(20);
		l.addToFront(8);
		l.remove(7);


		System.out.print(" Lista ...............");
		adabegiakInprimatu(l);
		System.out.println("Elementu-kopurua: " + l.size());
				
		
		System.out.println("Proba Find ...............");
		System.out.println("9? " + l.find(9));
		System.out.println("0? " + l.find(0));
		System.out.println("7? " + l.find(7));

		System.out.println("\n.......Proba lehenengo elementua.....");
		System.out.println("Lehenengo elementua "+l.first() +" da.");

		System.out.println("\n.......Proba lehenengo elementua lista hutsean.....");
		UnorderedDoubleLinkedList<Integer> lp= new UnorderedDoubleLinkedList<>();
		System.out.println("Lehenengo elementua "+lp.first() +" da.");

		System.out.println("\n.......Proba azkenengo elementua.....");
		System.out.println("Azkenengo elementua "+l.last()+" da.");

		System.out.println("\n.......Proba azkenengo elementua lista hutsean.....");
		System.out.println("Azkenengo elementua "+lp.last()+" da.");

		System.out.println("\n.......Proba deskripzioa......");
		l.setDeskr("Elementuak sartzeko balio duen zerrenda estekatua");
		System.out.println(l.getDeskr());

		System.out.println("\n.........Proba removeFirst()...........");
		System.out.println("Lista lehenengo elementua ezabatu baino lehen:");
		adabegiakInprimatu(l);
		l.removeFirst();
		System.out.println("Lista lehenengo elementua ezabatu eta gero:");
		adabegiakInprimatu(l);

		System.out.println("\n.........Proba removeFirst() elementu bakarreko listan.........");
		UnorderedDoubleLinkedList<Integer> l1=new UnorderedDoubleLinkedList<>();
		l1.addToFront(5);
		System.out.println("Lista lehenengo elementua ezabatu baino lehen:");
		adabegiakInprimatu(l1);
		l1.removeFirst();
		System.out.println("Lista lehenengo elementua ezabatu eta gero:");
		adabegiakInprimatu(l1);


		System.out.println("\n.........Proba removeLast()..........");
		System.out.println("Lista azkeneko elementua ezabatu baino lehen:");
		adabegiakInprimatu(l);
		l.removeLast();
		System.out.println("Lista azkeneko elementua ezabatu eta gero:");
		adabegiakInprimatu(l);

		System.out.println("\n.........Proba removeLast() elementu bakarreko listan.........");
		UnorderedDoubleLinkedList<Integer> l2=new UnorderedDoubleLinkedList<>();
		l2.addToFront(5);
		System.out.println("Lista lehenengo elementua ezabatu baino lehen:");
		adabegiakInprimatu(l2);
		l2.removeLast();
		System.out.println("Lista lehenengo elementua ezabatu eta gero:");
		adabegiakInprimatu(l2);

		System.out.println("\n ......Proba remove() azkenengo elementua.....");
		l.addToRear(8);
		System.out.println("Zerrenda azkenengo elementua ezabatu baino lehen:");
		adabegiakInprimatu(l);
		System.out.println("Zerrenda azkenengo elementua ezabatu eta gero:");
		l.remove(8);
		adabegiakInprimatu(l);

		System.out.println("\n...........Proba addAfter().........");
		UnorderedDoubleLinkedList<Integer> l11 = new UnorderedDoubleLinkedList<>();
		l11.addToRear(1);
		l11.addToRear(2);
		l11.addToRear(3);
		l11.addToRear(4);
		l11.addToRear(5);
		l11.addToRear(6);
		l11.addToRear(7);
		System.out.println("Hau da lista elementua sartu baino lehen:");
		adabegiakInprimatu(l11);
		l11.addAfter(10,3);
		System.out.println("Hau da lista elementua sartu eta gero:");
		adabegiakInprimatu(l11);

		System.out.println("\n...........Proba addAfter() azkenengo elementua.........");
		System.out.println("Hau da lista elementua sartu baino lehen:");
		adabegiakInprimatu(l11);
		l11.addAfter(10,7);
		System.out.println("Hau da lista elementua sartu eta gero:");
		adabegiakInprimatu(l11);
	}
}
