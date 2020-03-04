package Tp4;

public class Start {

	public static void main(String[] args) {
		IntSet iS = new IntSet();
		iS.remove(1);
		iS.insert(3);
		iS.insert(2);
		iS.insert(1);
		iS.insert(1);
		System.out.println(iS.toString());
		System.out.println("InSet \\ 1");
		iS.remove(1);
		System.out.println(iS.toString());
		
		IntSet2 iS2 = new IntSet2();
		iS2.remove(1);
		iS2.insert(3);
		iS2.insert(2);
		iS2.insert(1);
		iS2.insert(1);
		System.out.println(iS2.contentToString());
		System.out.println(iS2.toString());
		System.out.println("InSet \\ 1");
		iS2.remove(1);
		System.out.println(iS2.contentToString());
		System.out.println(iS2.toString());
		
		
		
		
		
		// TODO : IntSet3 par vous même !
	}
	
	public String test() {
		return new Integer(5) + " force String";
	}

}
