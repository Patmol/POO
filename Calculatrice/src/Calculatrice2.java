import java.io.InputStreamReader;
import java.util.*;
import java.util.function.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.AutoCloseable;

public class Calculatrice2 {
    public static void main(String args[]) { 
        try {
            // Reader
            try (InputStreamReader isr = new InputStreamReader(System.in))
            {
                try (BufferedReader br = new BufferedReader(isr))
                {
                    Map<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<String, BiFunction<Integer, Integer, Integer>>();
                    operations.put("+", Calculatrice2::plus);
                    operations.put("-", Calculatrice2::minus);
                    operations.put("*", Calculatrice2::mul);
                    operations.put("/", Calculatrice2::div);

                    int value1 = 0, value2 = 0, result = 0; 
                    String operation;

                    System.out.print("Value : ");
                    value1 = Integer.parseInt(br.readLine());
                    System.out.print("Operation : ");
                    operation = br.readLine();
                    System.out.print("Value : ");
                    value2 = Integer.parseInt(br.readLine());

                    result = operations.get(operation).apply(value1, value2);

                    while (!Objects.equals(operation, "=")) {
                        System.out.print("Operation : ");
                        operation = br.readLine();
                        
                        if (!Objects.equals(operation, "=")) {
                            System.out.print("Value : ");
                            value2 = Integer.parseInt(br.readLine());
                            result = operations.get(operation).apply(result, value2);
                        }
                    }

                    System.out.println("Result = " + result);
                }
            }
        }
        catch (NullPointerException e) {
            System.out.println(e);
        }
        catch (IOException e) {
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