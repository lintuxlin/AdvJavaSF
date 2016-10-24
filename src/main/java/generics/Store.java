package generics;

import java.awt.Color;
import java.time.LocalDate;

public class Store {

	public static void main(String[] args) {
		// Pair<String> p = new Pair<>("Fred", "Jones");
		//// p.setRight(LocalDate.of(2016, 10, 21));
		// String s = p.getRight();

		Pair<Shoe, Object> pShoe = new Pair<>(new Shoe(Color.RED, 10), new Shoe(Color.RED, 11));
		System.out.println("matched? " + pShoe.isMatching());

		pShoe = new Pair<>(new Shoe(Color.RED, 10), new Shoe(Color.RED, 10));
		System.out.println("matched? " + pShoe.isMatching());

		Shoe a = new Shoe(Color.RED, 10);
		Shoe b = new Shoe(Color.RED, 11);
		
		System.out.println("Match (static)? " + Pair.match(a, b));
	}

}
