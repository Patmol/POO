package CI2;

import java.util.Iterator;

import Exceptions.*;

public class Start {

	public static void main(String[] args) {

		Iterator<Integer> nombrePairs = Num.allEven();

		System.out.println("Premier nombre pair :" + nombrePairs.next());
		System.out.println("Second nombre pair :" + nombrePairs.next());
		System.out.println("Troisième nombre pair :" + nombrePairs.next());
		System.out.println("Quatrième nombre pair :" + nombrePairs.next());
		System.out.println("3 est un nombre premier. " + Num.isPrimeNew(3));
		System.out.println("4 est un nombre premier. " + Num.isPrimeNew(4));
		System.out.println("5 est un nombre premier. " + Num.isPrimeNew(5));
		System.out.println("6 est un nombre premier. " + Num.isPrimeNew(6));
		System.out.println("7 est un nombre premier. " + Num.isPrimeNew(7));
		
		Poly myPoly = new Poly();
		try {
			myPoly=myPoly.add(new Poly(3,3));
			myPoly=myPoly.add(new Poly(5,5));
			System.out.println(myPoly.toString());
			myPoly=myPoly.add(new Poly(1,1));
			myPoly=myPoly.add(new Poly(2,2));
			myPoly=myPoly.add(new Poly(10,10));
			System.out.println(myPoly.toString());
			System.out.println("Par ordre croissant :");
			// FOR EACH
			for(Poly monome : myPoly) {
				System.out.println(monome.toString());
			}
			System.out.println("Par ordre décroissant, autrement :");
			Iterator<Poly> i2 = myPoly.monomes();
			// UTILISATION CLASSIQUE
			while(i2.hasNext()) {
				Poly p = i2.next();
				System.out.println(p.toString());
			}
		}
		catch(NullPointerException | NegativeExponentException e) {
			System.out.println("Tentative de création d'un polynome incorrect mathématiquement !");
		}
	}
}
