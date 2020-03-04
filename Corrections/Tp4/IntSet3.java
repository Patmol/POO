package Tp4;

import java.util.ArrayList;
import java.util.List;
import Exceptions.EmptyException;

/**
 * @overview Les IntSets sont des ensembles non bornés d'entiers.
 * Ils sont mutables.
 * De manière générale, un IntSet est défini comme {x1, xi,...,xn} 
 * avec 0 < i <= n et n = size où size = cardinalité de l'IntSet 
 * @invariant size >= 0
 */
public class IntSet3  {

	private boolean[] els = new boolean[100];
	private List<Integer> otherEls;
	private int sz;
	
	
	/**
	 * FA(c) : { c.otherEls[i].intValue | 0 <= i < c.otherEls.size() }
	 * 			&
	 * 			{ j | 0 <= j < 100 && c.els[j] }
	 * 
	 */

	/**
	 * IR(c) : c.els != null && 
	 * 		c.otherEls != null &&
	 * 		c.els.size = 100
	 *  		all elements of c.otherEls are Integer  && 
	 *  		all elements of c.otherEls are not in the range 0 to 99 &&
	 *  		there are no duplicates in c.otherEls &&
	 *  		c.sz = c.otherEls.size + (count of true entries in c.els)
	 * 
	 */
	
	
	/**
	 * @effects initialise this à l'ensemble vide
	 */
	public IntSet3() { 
		// TODO
		otherEls = new ArrayList<Integer>();
	}

	/**
	 * @modifies this
	 * @effects this_post = this U {x}
	 */
	public void insert (int x) {
		if(x<=100) {
			els[x]=true;
		}
		else {
			otherEls.add(x);
		}
		sz++;	
	}

	/**
	 * @modifies this
	 * @effects this_post = this \ {x}
	 */
	public void remove (int x) {
		if(x<=100) {
			els[x]=false;
		}
		else {
			otherEls.remove((Object)x);
		}
		sz--;
	}

	/**
	 * @return true si x appartient à this; renvoie false sinon
	 */
	public boolean isIn (int x) { 
		if(x<=100) {
			return els[x];
		}
		else {
			return otherEls.contains((Object)x);
		}
	}

	/**
	 * @return la cardinalité de this.
	 */
	public int size () { 
		return sz;
	}

	/**
	 * @return x t.q. x appartient à this.
	 * @throws EmptyException  si this = {}
	 */
	public int choose () throws EmptyException { 
		if(otherEls.size()!=0) {
			return otherEls.get(0);
		}
		else
		{
			for(int i=0; i<=100;i++) {
				if(els[i]) {
					return i;
				}
			}
		}
		throw new EmptyException("IntSet3.choose()");
	}
	
	public boolean repOK() {
		if(els == null)return false;
		if(otherEls == null)return false;
		if (els.length!=100)return false;
		for(Object i: otherEls) {
			if ( i instanceof Integer == false) {
				return false;
			}
			else {
				if ((int)i>0 && (int)i<=100)return false;
			}
		}
		int count=0;
		for (Boolean b : els) {
			if(b) {
				count++;
			}
		}
		if (sz!=otherEls.size()+count) {
			return false;
		}
		return true;
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("IntSet:{");
		if(size()==0) {
			return sb.append("}").toString();
		}
		else {
			for(int i=0;i<100;i++) {
				if(els[i]) {
					sb.append(i+",");
				}
			}
		}
		sb= new StringBuilder(sb.substring(0, sb.length()-1).toString());
		for(Integer i : otherEls) {
			sb.append(","+i);
		}
		return sb.append("}").toString();
	}
	
	
}