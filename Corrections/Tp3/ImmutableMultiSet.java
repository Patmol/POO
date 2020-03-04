package Tp3;

import Exceptions.*;

/**
 * @overview Les ImmutableMultiSets sont des ensembles non bornés d'entiers.
 * Ils sont immutables.
 * De manière générale, un ImmutableMultiSet est défini comme {x1, xi,...,xn} 
 * 
 * @invariant size = #this
 */
public interface ImmutableMultiSet  {
	
	/**   
	 * @return new ImmutableMultiSet = this U {i}
	 */
	public ImmutableMultiSet insert(int i);
	
	/**
	 * @return new multiSet = this \ {i}
	 */
	public ImmutableMultiSet remove(int i);
	
	/**
	 * 
	 * @return true si i appartient à this, sinon false
	 */
	public boolean isIn(int i);
	
	/**
	 * 
	 * @return le nombre d'élément de this
	 */
	public int size();
	
	/**
	 * 
	 * @return un élément au hasard appartenant à this
	 * @throws EmptyException si this est vide
	 */
	public int choose() throws EmptyException;

	/**
	 * 
	 * @return le nombre d'occurences de l'élément i dans this
	 */
	public int numberOfOccurence(int i);
}
