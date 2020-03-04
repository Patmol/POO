package Tp3;

import Exceptions.NegativeArgumentException;
import Exceptions.NotFoundException;

/** 
 * @overview Classe permettant différentes choses...
 * 
 */

public class Num {
	/**
	 * @requires n et d > 0
	 * @return le pgcd de n et d
	 */  
	public static int pgcd(int n, int d) {
		if (d == 0) {
			return n;  
		}
		if (n < 0 || d < 0) {
			// Exception non vérifiée, attention, à l'examen toute exception non vérifiée 
			// doit se retrouver dans la spe et la signature !!!
			// Refuser par le require mais cela ne coûte rien !
			throw new NegativeArgumentException("Num.pgcd(int,int)");
		}
        else {
        		return pgcd (d, n % d);
        }
		
	}
	
	/**
	 * @requires  a est un tableau d'entiers non null et non vide
	 * @return un entier correspondant à l'élément le plus haut de a
	 */
	public static int greatest (int[] a){
		int max=a[0];
		for(int i=0; i<a.length; i++){
			if(max<a[i]){
				max=a[i];
			}
		}
		return max;
	}
	
	 /**
	 * @requires  a est un tableau d'entiers non null
	 * @return un entier correspondant à la somme des éléments de a
	 */
	public static int sum (int[] a){
		int total=0;
		for(int i=0; i<a.length; i++){
			total=total+a[i]; 
		}
		return total;
	}
	
	/**
	 * @requires p est un naturel positif
	 * @return true si p est un nombre pair, false sinon
	 */
	public static boolean isEven (int p){
		if(p%2==0)return true;
		return false;
	}
	
	/**
	 * @requires p est un naturel positif
	 * @return true si p est un nombre premier, false sinon
	 */
	public static boolean isPrime (int p){
		if(p<=1) {
			return false;
		}
        for(int i = 2;i*i<=p;i++)
        {
            if (p%i ==0)
            return false;
            i++;
        }
        return true;
	}
	
	/**
	  * @requires a et b sont deux tableaux d'entiers non null.
	  * @modifies a
	  * @effects a_post où chaque éléments de a est multiplié par la somme des éléments de b.
	  */
	public static void combine(int[] a, int[] b){
		int totalB=sum(b);
		for(int i=0; i<a.length; i++){
			a[i]=a[i]*totalB;
		}
	}
	
	/**
	   * @requires a est trie de manière croissante
	   * @return i tel que a[i] == x sinon 
	   * @throws NotFoundException si x n'appartient pas à a 
	   */
	public static int search(int[] a, int x)  throws NotFoundException{
		for(int i=0; i<a.length; i++){
			if(a[i]==x){		
				return i;
			}
		}
		throw new NotFoundException("Num.search()");
	}
}



















