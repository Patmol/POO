package CI2;

import Exceptions.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @overview Classe permettant de tester si un nombre est pair ou premier.
 *
 */
public class Num {	
	
	/**
	 * @return un générateur de nombre pair
	 */
	public static Iterator<Integer> allEven() { return new GenEven(); }
	
	private static class GenEven implements Iterator<Integer>{
		private int p=0;
		
		@Override
		public boolean hasNext() {
			return true;
		}

		@Override
		public Integer next() {
			Integer integer = new Integer(p);
			p = p+2;
			return integer;
		}

		@Override
		public void remove() { 
			throw new UnsupportedOperationException("Num.GenEven.remove()");
		}
		
	}
	
	
	
	/**
	 * @requires num is a natural number > 0
	 * @return: true, if num is prime (no positive divisors other than 1 and itself);
	 * 			else return false;
	 */
	public static boolean isPrimeNew(int num) {
		
		if (num <= 0) throw new FailureException("Num.isPrime(int num)");
		
		Iterator<Integer> g = allPrimes();
		
		while (g.hasNext())  {
			int currentPrime = (g.next()).intValue(); 
			if (num == currentPrime) return true;
			if (num < currentPrime) return false;
		}
		
		return false;
	}

	
	/**
	 * @return un générateur de nombres premiers qui génère tous les nombres
	 * premiers (de classe Integer) une seule fois dans l'ordre croissant
	 */
	private static Iterator<Integer> allPrimes() { return new GenPrimes(); }
	
	
	// static nested class (we do not declare a non-static nested class 
	// because the iterator method is a static procedure)
	private static class GenPrimes implements Iterator<Integer>{
		private ArrayList<Integer> ps; // primes yielded
		private int p; // next candidate to try
		
		GenPrimes() {
			p=2;
			ps = new ArrayList<>();
		}
		
		@Override
		public boolean hasNext() {
			return true;
		}

		@Override
		public Integer next() {
			if (p == 2) {
				p = 3; 
				ps.add(new Integer(2));
				return new Integer(2);
			}
			
			for (int n=p; true; n = n +2 ) {
			
				for (int i=0; i < ps.size(); i++) {
					int el = ((Integer) ps.get(i)).intValue();
					if (n%el == 0) break; // not a prime
					if(el*el > n) { // have a prime
						ps.add(new Integer(n));
						p = n+2;
						return new Integer(n);
					}
				}			
			}
		}

		@Override
		public void remove() { 
			throw new UnsupportedOperationException("Num.GenPrimes.remove()");
		}
		
	}
}
