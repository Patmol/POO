package Tp4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import Exceptions.EmptyException;

/**
 * @overview Les IntSets sont des ensembles non bornés d'entiers.
 * Ils sont mutables.
 * De manière générale, un IntSet est défini comme {x1, xi,...,xn} 
 * avec 0 < i <= n et n = size où size = cardinalité de l'IntSet 
 * @invariant size >= 0
 */
public class IntSet2  {

	private List<Integer> els;	
	
	/*
	 * update des méthodes
	 *  - remove (retirer toutes les occurences de l'integer)
	 *  - insert
	 *  - size (ne pas tenir compte des duplicates)
	 *  - toString ne pas afficher les doublons
	 *  
	 *  Avantage : ajout très rapide (pas de check)
	 *  Désavantage : occupation mémoire dans la List<Integer>; complexification du remove, size et du toString
	 */
	
	/**
	 * FA(c) : { c.els[i].intValue | 0 <= i < c.els.size() 
	 *  => c.els[i].intValue != c.els[j].intValue }
	 *  
	 */

	/**
	 * IR(c) : c.els != null &&
	 *  		&& formel: for all integers i c.els[i] is an Integer  (soit all elements of c.els are Integer )
	 * 
	 */
	
	
	/**
	 * @effects initialise this à l'ensemble vide
	 */
	public IntSet2() { 
		els = new ArrayList<>();
	}

	/**
	 * @modifies this
	 * @effects this_post = this U {x}
	 */
	public void insert (int x) {
		els.add(x); 
	}

	/**
	 * @modifies this
	 * @effects this_post = this \ {x}
	 */
	public void remove (int x) {
		while(isIn(x)) {
			els.remove((Object)x);	
		}
	}

	/**
	 * @return true si x appartient à this; renvoie false sinon
	 */
	public boolean isIn (int x) { 
		return els.contains(x); 
	}

	/**
	 * @return la cardinalité de this.
	 */
	public int size () { 
		LinkedHashSet<Integer> hs = new LinkedHashSet<Integer>();
		hs.addAll(els);
		return hs.size();  
	}

	/**
	 * @return x t.q. x appartient à this.
	 * @throws EmptyException  si this = {}
	 */
	public int choose () throws EmptyException { 
		if (els.size()==0) { throw new EmptyException("IntSet.choose()"); }
		return els.get(0); 
	}
	
	public boolean repOk(){
		if(this.els == null)
			return false;
		for(Object i : els) {
			if ( i instanceof Integer == false) return false;
		}
		return true;
	}
	
	public void checkRep() {
		if(this.els == null)
			throw new RepException("IntSet.repOk() - els non defini");
		for(Object i : els) {
			if ( i instanceof Integer == false) throw new RepException("IntSet.repOk() - els non defini");
		}
	}
	
	@Override
	// Il serait plus judicieux d'effectuer un toString en enlevant les doublons
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (this.size() == 0 ) {
			sb.append("IntSet : {}");
		}
		else {
			// LinkedHashSet to preserve order
			LinkedHashSet<Integer> hs = new LinkedHashSet<Integer>();
			hs.addAll(els);
			
			sb.append("IntSet : {");
			
			for(Integer i : hs) {
				sb.append(i+","); 
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("}");
		}
		return sb.toString();
	}
	
	
	public String contentToString() {
		StringBuilder sb = new StringBuilder();
		if (this.size() == 0 ) {
			sb.append("Real content of the IntSet : {}");
		}
		else {
			sb.append("Real content of the IntSet : {");
			for(Integer i : this.els) {
				sb.append(i+","); 
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("}");
		}
		return sb.toString();
	}
}