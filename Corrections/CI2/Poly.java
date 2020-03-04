package CI2;

import Exceptions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @overview Les Poly sont des polynomes à coefficients entiers.
 * Ils sont immutables.
 * De manière générale, un Poly est défini comme c0 + c1 x + c2 x^2 ... + cn x^n 
 * où chaque ci est un int (pour 0 <= i <= n) 
 */
public class Poly implements Iterable<Poly> {

	// la représentation
	private int[] trms; 
	private int deg;

	/**
	 * FA(c)= c0+c1x1+c2x2+...+cnxn
	 *			tq ci = c.terms[i] si 0<=i<=c.trms.size
	 *			= 0 sinon  
	 */

	/**
	 * IR : c.trms != null &&
	 * 		c.trms.length =>1 &&
	 * 		c.deg = c.trms.length-1 &&
	 * 		c.deg>0 -> c.trms[deg]!= 0
	 */
	

	// Constructeurs
	/**
	 * @effects initialise this au polynome nul
	 */
	public Poly() { 
		trms = new int[1]; 
		deg = 0; 
	}

	/**
	 * @throws NegativeExponentException si n < 0
	 * @effects sinon, initialise this au polynome c.x^n 
	 */
	public Poly(int c, int n) throws NegativeExponentException { 
		if (n<0)
			throw new NegativeExponentException("Poly.Poly(int,int)");
		if (c==0) { 
			trms=new int[1]; 
			deg=0; 
			return; 
		}
		trms = new int[n+1];
		for (int i=0; i<n; i++) trms[i]=0;
		trms[n]=c;
		deg = n; 
	}

	private Poly (int n) { 
		trms = new int[n+1]; 
		deg = n; 
	}


	// Méthodes
	/**
	 * @return renvoie le degré de this, càd son plus grand
	 * exposant à coefficient non nul. Si this est le polynome
	 * nul, renvoie 0.
	 */
	public int degree () { return deg; }

	/**
	 * @return renvoie le coefficient du terme de this d’exposant d.
	 */
	public int coeff (int d) { if (d < 0 || d > deg) return 0; else return trms[d]; }

	/**
	 * @throws NullPointerException si q == null
	 * @return un nouveau polynome t.q. this + q sinon
	
	 */
	public Poly add(Poly q) throws NullPointerException { 
		Poly la, sm;
		if (deg > q.deg) {la = this; sm = q;} else {la = q; sm = this;}
		int newdeg = la.deg; // le nouveau degré est le plus grand des 2
		if (deg == q.deg) {  // sauf si les coeff des derniers deg sont 0
			for (int k = deg; k > 0; k--) {
				if (trms[k] + q.trms[k] != 0) { break; } else { newdeg--; }
			}
		}
		Poly r = new Poly(newdeg); //crée un nouveau Poly
		int i;
		for (i=0; i<= sm.deg && i<= newdeg; i++) { 
			r.trms[i]= sm.trms[i] + la.trms[i];
		}
		for (int j=i; j<= newdeg; j++) {
			r.trms[j]= la.trms[j];
		}
		return r;
	}
	
	
	/**
	 * @throws NullPointerException si q == null
	 * @return le polynome this * q sinon
	 */
	public Poly mul(Poly q) throws NullPointerException { 
		if ((q.deg==0 && q.trms[0]==0) || (deg==0 && trms[0]==0)) {
			return new Poly();
		}
		Poly r = new Poly(deg+q.deg);
		r.trms[deg+q.deg] = 0; // prepare le calcul des coeff
		for (int i = 0; i <= deg; i++) {
			for (int j = 0; j <= q.deg; j++) { 
				r.trms[i+j] = r.trms[i+j] + trms[i]* q.trms[j];
			}
		}
		return r; 
	}

	/**
	 * @throws NullPointerException si q == null
	 * @return le polynome this - q sinon
	 */
	public Poly sub(Poly q) throws NullPointerException { return add (q.minus()); }

	/**
	 * @return le polynome -this
	 */
	public Poly minus() { 
		Poly r = new Poly(deg);
		for (int i=0; i<=deg; i++) { r.trms[i]= - trms[i]; }
		return r;
	}

	public boolean equals(Poly q){
		if (q == null || deg != q.deg) return false;
		for (int i=0; i<=deg; i++) {
			if (trms[i]!=q.trms[i]) return false;
		}
		return true; }

	@Override
	public boolean equals(Object o){
		if (o == null || !o.getClass().equals(getClass())) { 
			return false;
		}
		return equals((Poly) o); 
	}

	/**
	 * @return true si l’IR est satisfait pour this;
	 *  	   sinon, renvoie false. 
	 */
	public boolean repOK() {
		if (trms  == null) return false;
		if (deg != trms.length-1) return false;
		if (trms.length == 0) return false;
		if (deg==0) return true;
		return (trms[deg] != 0);
	}


	@Override public String toString() {
		StringBuilder sb = new StringBuilder("Poly : ");
		for (int i=0; i < trms.length; i++) {
			if (trms[i] == 0) continue;
			sb.append(trms[i] + "x^" + i + " + ");
		}
		sb.delete(sb.length()-3, sb.length());
		return sb.toString();
	}
	
	/**
	 * 
	 * @return un générateur produisant chaque monome de this
	 *         en ordre croissant de degré
	 */
	@Override
	public Iterator<Poly> iterator(){
		return new GenMonomes(false);
	}
	
	
	/**
	 * 
	 * @return un générateur produisant chaque monome de this
	 *         en ordre décroissant de degré
	 */
	public Iterator<Poly> monomes(){
		return new GenMonomes(true);
	}
	
	private class GenMonomes implements Iterator<Poly>{
		private int currentDeg;
		private Poly monomeEnCache;
		private boolean reversed;
		
		GenMonomes(boolean reversed){
			if (reversed) {
				currentDeg = deg;
			}
			else {
				currentDeg=0;
			}
			monomeEnCache = null;
			this.reversed = reversed;
		}
		
		@Override
		public boolean hasNext() {
			if(monomeEnCache== null) {
				try {
					monomeEnCache = next();
				}
				catch(NoSuchElementException e) {
					return false;
				}	
			}
			if(monomeEnCache != null) return true;
			else return false;
		}
		
		@Override
		public Poly next() {
			if(monomeEnCache != null) {
				Poly tmp = monomeEnCache;
				monomeEnCache = null;
				return tmp;
			}
			if(!reversed) {
				if(currentDeg > deg) {
					throw new NoSuchElementException("Poly.GenMonomes.next()");
				}
				else {
					if (currentDeg < 0) {
						throw new NoSuchElementException("Poly.genMonomes.next()");
					}
				}
			}
			if(deg == 0) {
				updateCurrentDeg();
				try {
					return new Poly(trms[0],0);
				}
				catch (NegativeExponentException e) {
					// on construit nous même le Poly,
					// on est donc certain que le degré n'est pas 
					throw new FailureException("Poly.monomes()");
				}
			}	
			if (trms[currentDeg] != 0) {
				Poly returnedMonome;
				try {
					returnedMonome = new Poly(trms[currentDeg],currentDeg);
				}
				catch(NegativeExponentException e) {
					// on construit nous même le Poly,
					// on est donc certain que le degré n'est pas négatif
					throw new FailureException("Poly.monomes()");
				}
				updateCurrentDeg();
				return returnedMonome;
			}
			else
			{
				updateCurrentDeg();
				return next();
			}
		}
		
		private void updateCurrentDeg() {
			if (reversed) currentDeg --;
			else currentDeg++;
		}	
	}	
}