package Tp3;
import java.util.ArrayList;
import java.util.List;
import Exceptions.EmptyException;


/**
 * @overview Les ImmutableMultiSetImpls sont des ImmutableMultiSet implémentés 
 * sous la forme de liste d'Integer.
 * Ils sont immutables.
 * 
 * @invariant size >= 0
 */
public class ImmutableMultiSetImpl implements ImmutableMultiSet, Cloneable {

	// Immutables  -> refaire equals -> refaire hashCode
	
	private List<Integer> elts;
	
	public ImmutableMultiSetImpl() {
		elts = new ArrayList<Integer>();
	}
	
	@Override
	public ImmutableMultiSet insert(int i) {
		ImmutableMultiSetImpl result = this.clone();	
		result.elts.add(i);		
		return result;
	}
	
	@Override
	public ImmutableMultiSetImpl clone() {
		ImmutableMultiSetImpl result = new ImmutableMultiSetImpl();		
		for(Integer elt : this.elts) {
			result.elts.add(elt);
		}
		return result;
	}

	@Override
	public ImmutableMultiSet remove(int i) {
		ImmutableMultiSetImpl result = this.clone();
		while(result.isIn(i)) {
			result.elts.remove(result.elts.indexOf(i));
		}
		return result;
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
			throw new EmptyException("ImmutableMultiSetImpl.choose()");
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
	
	private boolean equals(ImmutableMultiSetImpl ims) {
		if ( ims == null || ims.size() != this.size()) {
			return false;
		}
		
		for (int i=0; i<size();i++) {
			if (this.elts.get(i) != ims.elts.get(i)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null || !o.getClass().equals(getClass())) {
			return false;
		}
		return equals((ImmutableMultiSetImpl) o );
	}
	
	public int hashCode() {
		// Algo. de Bloch
		// ***************
		// int result = SEL1
		// pour chaque variable d'instance : result = SEL2*result+ valeur numérique de la variable (si objet var.hashCode() )
		// return result
		int result = 17;
		result = 31 * result + elts.hashCode(); // Ok selon les spe.
		return result;	
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
