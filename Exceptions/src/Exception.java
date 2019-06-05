public class IncorrectNumberException {
    public NotIntegerException() {
        super();
    }

    public NotIntegerException(String message) {
        super(message);
    }
}

public class Calculator {
    public double divide(double a, double b) throws IncorrectNumberException {
        if (b == 0) {
            throw IncorrectNumberException("Calculator.divide()");
        }

        return a / b;
    }
}

public main(String args[]) {
    try {
        Calculator calculator = new Calculator();

        calculator.divide(12, 0);
    } finally {
        System.out.println("The program is finish.");
    } catch (IncorrectNumberException ex) {
        System.out.println(ex);
    }
}