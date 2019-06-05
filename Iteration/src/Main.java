import java.util.Iterator;

public class Main {
    public static void main(String args[]) {
        NumTP num = new NumTP();

        Iterator<Integer> evenNum = num.getAllEven();

        while(evenNum.hasNext()) {
            int next = evenNum.next();
            
            if (next > 100) {
                break;
            }
            
            System.out.print(next + " ");
        } 
        System.out.println();
    }
}