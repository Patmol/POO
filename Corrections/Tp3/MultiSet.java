package Tp3;
import Exceptions.EmptyException;

/**
 * @overview Les MultiSets sont des ensembles non bornés d'entiers.
 * Ils sont mutables.
 * De manière générale, un MultiSet est défini comme {x1, xi,...,xn} 
 * 
 * @invariant size >= 0
 */
public interface MultiSet {

	/**
	 * @modifies this
	 * @effects this_post = this U {i}
	 * @param i l'élément à insérer dans this
	 */
	public void insert(int i);
	
	/**
	 * @modifies this
	 * @effects this_post = this \ {i}
	 * @param i l'élément à retirer de this
	 */
	public void remove(int i);
	
	/**
	 * 
	 * @return retourne true si i appartient à this, sinon false
	 * @param i l'élément recherché dans this
	 */
	public boolean isIn(int i);
	
	/**
	 * 
	 * @return le nombre d'éléments de this
	 */
	public int size();
	
	/**
	 * 
	 * @return un élément au hasard appartenant à this
	 * @throws EmptyException 
	 */
	public int choose() throws EmptyException;

	/**
	 * 
	 * @param i l'élément dont on souhaite obtenir le nombre d'occurrence dans this
	 * @return le nombre d'occurences de l'élément i dans this
	 */
	public int numberOfOccurence(int i);
}
