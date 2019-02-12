import java.lang.Exception;

/**
 * @overview Contient les méthodes du TP trois (partie 1)
 */
public class Num {
    /**
     * @requires a et b doivent être supérieur à 0
     * @param a Le premier nombre supérieur à 0
     * @param b Le deuxième nombre supérieur à 0
     * @return Le PGCD de a et de b
     */
    public static int pdgc(int a, int b) {
        int r, q = 0;
    
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }

        for(;;) {
            r = a % b;
            q = (a-r)/b;

            if (r==0) { 
                break;
            }

            a = b;
            b = r;
        }
    
        return b;
    }

    /**
     * @requires Le tableau doit posséder au moins un élément.
     * @param a Le tableau dans lequel if faut rechercher le plus grand élément
     * @return Le plus grand entier du tableau a
     * @throws ArrayIndexOutOfBoundsException si le tableau ne possède pas d'élément 
     */
    public static int greatest(int[] a) throws ArrayIndexOutOfBoundsException {
        if (a.length == 0) {
            throw new ArrayIndexOutOfBoundsException("Le tableau ne contient pas d'élément");
        }

        int greatest = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] > greatest) {
                greatest = a[i];
            }
        }

        return greatest;
    }

    /**
     * @requires a est un tableau d'entiers non null
     * @param a Le tableau à additionner
     * @return La somme des éléments du tableau
     */
    public static int sum(int[] a) {
        int sum = 0;

        if (a == null) {
            return sum;
        }

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        return sum;
    }

    /**
     * @requires p est un naturel
     * @param p Le nombre à vérifier
     * @return true si le nombre est pair, false dans le cas contraire.
     */
    public static boolean isEven(int p) {
        return p % 2 == 0;
    }

    /**
     * @requires p est un naturel
     * @param p Le nombre à vérifier
     * @return true si le nombre est premier, false dans le cas contraire.
     */
    public static boolean isPrim(int p) {
        boolean isPrim = true;

        for (int i = p - 1; i > 1 && isPrim; i--) {
            isPrim = !(p % i == 0);
        } 

        return isPrim;
    }

    /**
     * @requires a et b sont deux tableaux d'entiers non null.
     * @modifies a
     * @effects Multiplie chaque élément de a par la somme des éléments de b.
     *  Exemple: a = [ 5, 12, 3 ] et b = [ 5, 10 ] nous avons a' = [ 75, 180, 35 ]
     */
    public static void combine(int[] a, int[] b) {
        int sum = Num.sum(b);

        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] * sum;
        }
    }

    /**
     * Affiche un tableau
     * @param a Le tableau à afficher
     */
    private static void printArray(int[] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        
        System.out.println();
    }

    public static void main(String args[]) {
        int[] array = { 5, 15 };
        int[] arrayB = { 5, 15 };

        System.out.println("Le PGCD est de : " + Num.pdgc(6, 11));
        System.out.println("Le plus grand élément du tableau est : " + Num.greatest(array));
        System.out.println("La somme du tableau est de : " + Num.sum(array));
        System.out.println("Le nombre 4 est pair ? " + Num.isEven(4));
        System.out.println("Le nombre 11 est pair ? " + Num.isEven(11));
        System.out.println("Le nombre 4 est premier ? " + Num.isPrim(4));
        System.out.println("Le nombre 11 est premier ? " + Num.isPrim(11));
        System.out.println("Le nombre 27 est premier ? " + Num.isPrim(27));
        System.out.println("Le nombre 31 est premier ? " + Num.isPrim(31));

        System.out.println("Le tableau a :");
        Num.printArray(array);
        System.out.println("Le nouveau tableau a :");
        Num.combine(array, arrayB);
        Num.printArray(array);
    }
} 