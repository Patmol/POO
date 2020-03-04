package Exceptions;

public class NegativeArgumentException extends RuntimeException {
	
	public NegativeArgumentException() {
		super();
	}
	
	public NegativeArgumentException(String string) {
		super(string);
	}

}
