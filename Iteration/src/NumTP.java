import java.util.Iterator;
import java.util.NoSuchElementException;

public class NumTP {
	
	/**
	 * @return le pgcd de n et d
	 * @throws Exception si n ou d <= 0
	 */  
	public static int pgcd(int n, int d) throws Exception {
		if (d == 0) {
			return n;  
		}
		if (n < 0 || d < 0) {
			throw new Exception();
		}
        else {
        		return pgcd (d, n % d);
        }
		
	}
	
	/**
	 * @requires  a est un tableau d'entiers non null
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
	  * @effects a est multiplié par la somme des éléments de b.
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
	   * @throws Exception si x n'appartient pas a a 
	   */
	public static int search(int[] a, int x)  throws Exception{
		for(int i=0; i<a.length; i++){
			if(a[i]==x){		
				return i;
			}
		}
		throw new Exception("Num.search()");
    }

    public Iterator<Integer> getAllEven() {
        return new EvenNum();
    }
    
    private class EvenNum implements Iterator<Integer> {
        private int num = 0;
        
        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() throws NoSuchElementException {
			int previousNum = num;
            num += 2;
            return previousNum;
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
    }
}
