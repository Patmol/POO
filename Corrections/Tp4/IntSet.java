package Tp4;

import java.util.ArrayList;
import java.util.List;
import Exceptions.EmptyException;

/**
 * @overview Les IntSets sont des ensembles non bornés d'entiers.
 * Ils sont mutables.
 * De manière générale, un IntSet est défini comme {x1, xi,...,xn} 
 * avec 0 < i <= n et n = size où size = cardinalité de l'IntSet 
 * @invariant size toujours positif
 */
public class IntSet  {

	private List<Integer> els;
	/**
	 * FA(c) : { c.els[i].intValue | 0 <= i < c.els.size() }
	 * 
	 
	 * 
	 */

	/**
	 * IR(c) : c.els is not null &&
	 *  		for all integer i, c.els[i] is an Integer  (soit c.els contains only Integers elements )   &&
	 *  		for all i,j | ( 0 <= i < j < c.els.size() => c.els[i] != c.els[j] )         (soit  c.els doesn't allows any duplicate elements)
	 * 
	 */
	
	
	/**
	 * @effects initialise this à l'ensemble vide
	 */
	public IntSet() { 
		els = new ArrayList<>();
	}

	/**
	 * @modifies this
	 * @effects this_post = this U {x}
	 */
	public void insert (int x) {
		if (els.indexOf(x) < 0) els.add(x); 
		
	}

	/**
	 * @modifies this
	 * @effects this_post = this \ {x}
	 */
	public void remove (int x) {
		els.remove((Object)x);
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
	public int size () { return els.size();  }

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
			if (els.indexOf(i) != els.lastIndexOf(i)) return false;
		}
		return true;
	}
	

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (this.size() == 0 ) {
			sb.append("IntSet : {}");
		}
		else {
			sb.append("IntSet : {");
			for(Integer i : this.els) {
				sb.append(i+","); 
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("}");
		}
		return sb.toString();
	}
	
}