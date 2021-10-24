import listasSimples.*;

class PruebaOrderedDoubleLinkedList {
		
		public static void main(String[] args)  {
			
			OrderedDoubleLinkedList<Integer> l = new OrderedDoubleLinkedList<Integer>();
			l.add(1);
			l.add(3);
			l.add(6);
			l.add(7);
			l.add(9);
			l.add(0);
			l.add(20);
			l.remove(7);

			
			System.out.print(" Lista ...............");
			l.adabegiakInprimatu();
			System.out.println("Elementu-kopurua: " + l.size());
					
			
			System.out.println("\nProba Find ...............");
			System.out.println("20? " + l.find(20));
			System.out.println("9? " + l.find(9));
			System.out.println("9? " + l.find(9));
			System.out.println("0? " + l.find(0));
			System.out.println("7? " + l.find(7));
			
			
			
			OrderedDoubleLinkedList<Pertsona> l2 = new OrderedDoubleLinkedList<Pertsona>();
			l2.add(new Pertsona("jon", "1111"));
			l2.add(new Pertsona("ana", "7777"));
			l2.add(new Pertsona("amaia", "3333"));
			l2.add(new Pertsona("unai", "8888"));
			l2.add(new Pertsona("pedro", "2222"));
			l2.add(new Pertsona("olatz", "5555"));

			l2.remove(new Pertsona("", "8888"));

			
			System.out.print(" Lista ...............");
			l2.adabegiakInprimatu();
			System.out.println("Elementu-kopurua: " + l2.size());
					
			
			System.out.println("\nProba Find ...............");
			System.out.println("2222? " + l2.find(new Pertsona("", "2222")));
			System.out.println("5555? " + l2.find(new Pertsona("", "5555")));
			System.out.println("7777? " + l2.find(new Pertsona("", "7777")));
			System.out.println("8888? " + l2.find(new Pertsona("", "8888")));

			System.out.println("\nProba merge ..............."); //elementu guztiak lista originalaren bi elementuen artean
			OrderedDoubleLinkedList<Integer> l3 = new OrderedDoubleLinkedList<>();
			l3.add(3);
			l3.add(15);
			l3.add(1);
			System.out.println("Hasierako lista:");
			l3.adabegiakInprimatu();
			OrderedDoubleLinkedList<Integer> l4 = new OrderedDoubleLinkedList<>();
			l4.add(5);
			l4.add(9);
			l4.add(8);
			System.out.println("Hartuko dituen elementu berriak:");
			l4.adabegiakInprimatu();
			l3.merge(l4);
			System.out.println("merge() aplikatu eta gero:");
			l3.adabegiakInprimatu();

			System.out.println("\nProba merge 2..............."); //elementuak listaren hasieran, erdian eta amaieran
			OrderedDoubleLinkedList<Integer> l5 = new OrderedDoubleLinkedList<>();
			l5.add(10);
			l5.add(15);
			l5.add(2);
			l5.add(5);
			System.out.println("Hasierako lista:");
			l5.adabegiakInprimatu();
			OrderedDoubleLinkedList<Integer> l6 = new OrderedDoubleLinkedList<>();
			l6.add(6);
			l6.add(3);
			l6.add(4);
			l6.add(1);
			l6.add(20);
			System.out.println("Hartuko dituen elementu berriak:");
			l6.adabegiakInprimatu();
			l5.merge(l6);
			System.out.println("merge() aplikatu eta gero:");
			l5.adabegiakInprimatu();

			System.out.println("\nProba merge 3..............."); //elementuak listaren hasieran, erdian eta amaieran
			OrderedDoubleLinkedList<Integer> l7 = new OrderedDoubleLinkedList<>();
			System.out.println("Hasierako lista:");
			l7.adabegiakInprimatu();
			OrderedDoubleLinkedList<Integer> l8 = new OrderedDoubleLinkedList<>();
			l8.add(6);
			l8.add(3);
			l8.add(4);
			l8.add(1);
			l8.add(20);
			System.out.println("Hartuko dituen elementu berriak:");
			l8.adabegiakInprimatu();
			l7.merge(l8);
			System.out.println("merge() aplikatu eta gero:");
			l7.adabegiakInprimatu();
	}
}
