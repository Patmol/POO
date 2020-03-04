package Tp3;
import java.util.ArrayList;
import Exceptions.EmptyException;

/**
 * @overview Les MultiSetImpls sont des MultiSets implémentés 
 * sous la forme d'une ArrayList d'Integer.
 * Ils sont mutables.
 * 
 * @invariant size >= 0
 */
public class MultiSetImpl implements MultiSet, Cloneable{

	// Mutables -> possibilité de clone 
	
	private ArrayList<Integer> elts;
	
	public MultiSetImpl() {
		elts = new ArrayList<Integer>();
	}
	
	@Override
	public void insert(int i) {
		this.elts.add(i);
	}
	
	@Override
	public void remove(int i) {
		while(this.isIn(i)) {
			this.elts.remove(elts.indexOf(i));
		}
	}

	@Override
	public boolean isIn(int i) {
		return this.numberOfOccurence(i) > 0;
	}

	@Override
	public int size() {
		return this.elts.size();
	}

	@Override
	public int choose() throws EmptyException {
		if (this.size()!=0) {
			return this.elts.get(0);
		}
		else {
			throw new EmptyException("MultiSetImpl.choose()");
		}
	}

	@Override
	public int numberOfOccurence(int i) {
		int compteur=0;
		for (Integer integer : this.elts) {
			if(integer == i) {
				compteur++;
			}
		}
		return compteur;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (this.size() == 0 ) {
			sb.append("MultiSet : {}");
		}
		else {
			sb.append("MultiSet : {");
			for(Integer i : this.elts) {
				sb.append(i+","); 
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append("}");
		}
		return sb.toString();
	}
	
	public MultiSetImpl clone() {
		MultiSetImpl result = new MultiSetImpl();		
		for(Integer elt : this.elts) {
			result.elts.add(elt);
		}
		return result;
	}
}
