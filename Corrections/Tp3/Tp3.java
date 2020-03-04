package Tp3;

import Exceptions.*;


public class Tp3 {
	public static void main(String[] args) {

	
		int[] tab1 = new int[] {1,2,3,4};
		
		
		System.out.println("PGCD de de 96 et 16 est :" + Num.pgcd(96, 16));
		
		System.out.println("Le plus haut élément du tableau [75,1234,3,937] est " + Num.greatest(new int[] {75,1234,3,937}));
		System.out.println("La somme des élément du tableau [1,2,3,4] vaut " + Num.sum(tab1));
		System.out.println("1234 est pair. " + Num.isEven(1234));
		System.out.println("146 est un nombre premier. " + Num.isPrime(146));
		System.out.println("147 est un nombre premier. " + Num.isPrime(147));
		System.out.println("Tableau 1 = [1,2,3,4] et tableau 2 = [1,2,3,4]");
		System.out.println("Elément de tableau 1 mutliplié par la somme du tableau 2 :");
		
		for(int i=0; i<tab1.length;i++) {
			System.out.println(tab1[i]); 
		}
		
		Num.combine(tab1, tab1);
		
		for(int i=0; i<tab1.length;i++) {
			System.out.println(tab1[i]); 
		}
		
		try {
			System.out.println("L'élément 20 est à l'indice " + Num.search(tab1, 25) +" du tableau tab1.");
		}
		catch(NullPointerException e) {
			System.out.println("tab1 est null : " + e.toString());
		}
		catch(NotFoundException e) {
			System.out.println("L'élément 20 n'est pas présent dans tab1 ! " + e.toString());
		}

		System.out.println("MultiSet mutable");
		MultiSetImpl myMultiSet01=new MultiSetImpl();
		myMultiSet01.insert(1);
		myMultiSet01.insert(2);
		myMultiSet01.insert(3);
		myMultiSet01.insert(4);
		
		System.out.println("MultiSet immutable");
		ImmutableMultiSetImpl myMultiSet02 = new ImmutableMultiSetImpl();
		myMultiSet02.insert(1);
		myMultiSet02.insert(2);
		myMultiSet02.insert(3);
		myMultiSet02.insert(4);
		try {
			System.out.println("Elément pris au hasard : " + myMultiSet02.choose());
		} 
		catch (EmptyException e) {
			System.out.println("Mais que se passe-t-il ? " + e.toString());
		}
		
		System.out.println("A mais oui !");
		myMultiSet02 = (ImmutableMultiSetImpl) myMultiSet02.insert(1);
		myMultiSet02 = (ImmutableMultiSetImpl) myMultiSet02.insert(2);
		myMultiSet02 = (ImmutableMultiSetImpl) myMultiSet02.insert(3);
		myMultiSet02 = (ImmutableMultiSetImpl) myMultiSet02.insert(4);
		try {
			System.out.println("Elément pris au hasard : " + myMultiSet02.choose());
		} 
		catch (EmptyException e) {
			System.out.println("Mais que se passe-t-il ? " + e.toString());
		}
		System.out.println(myMultiSet01.toString());
		System.out.println(myMultiSet02.toString());

	}	
}
