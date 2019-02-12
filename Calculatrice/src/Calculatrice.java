import java.io.InputStreamReader;
import java.util.Objects;
import java.io.BufferedReader;
import java.io.IOException;

public class Calculatrice {
    public static void main(String args[]) {
        try {
            int result = 0, value1 = 0, value2 = 0;
            String operation = "";
            Boolean endOperation = false;

            InputStreamReader isr = new InputStreamReader(System.in); 
            BufferedReader br = new BufferedReader (isr);

            System.out.print("Value 1 : ");
            value1 = Integer.parseInt(br.readLine());
            System.out.print("Value : 2 ");
            value2 = Integer.parseInt(br.readLine());
            System.out.print("Operation : ");
            operation = br.readLine();

            do {
                switch (operation) {
                    case "+" : 
                        result = plus(value1, value2);
                        break;
                    case "-" : 
                        result = minus(value1, value2);
                        break;
                    case "*" : 
                        result = mul(value1, value2);
                        break;
                    case "/" : 
                        result = div(value1, value2);
                        break;
                    default:
                        throw new IllegalArgumentException("Operation is unknown");
                }

                System.out.print("Operation : ");
                operation = br.readLine();

                if (Objects.equals(operation, "quit")) {
                    endOperation = true;
                } else {
                    System.out.print("Value : ");
                    value2 = Integer.parseInt(br.readLine());
                    value1 = result;
                }

            } while (!endOperation);

            System.out.println("Result = " + result);

            br.close();
            isr.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
        catch (NumberFormatException e) {
            System.out.println(e);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        catch (ArithmeticException e) {
            System.out.println(e);
        }
    }

    public static int plus(int value1, int value2) {
        return value1 + value2;
    }

    public static int minus(int value1, int value2) {
        return value1 - value2;
    }

    public static int mul(int value1, int value2) {
        return value1 * value2;
    }

    public static int div(int value1, int value2) {
        return value1 / value2;
    }
}