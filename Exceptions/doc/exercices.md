# Exercices 1

Créer une class reprenant les informations sur un _eleve_ (nom et prénom) ainsi que les notes qu'ils ont reçu dans différents cours. Une note de cours est représenter par un _cours_ ainsi qu'une valeur entière indiquant la note reçu par l'élève (la note est sur 20).

Le programme devra contenir un menu permettant à l'utilisateur d'encoder des cours et les notes d'élèves. Lors de l'encodage d'une note, il faut commencer par entrer le nom et prénom de l'élève et récupérer celui-ci, il est ajouté à l'application. Pour encoder la note pour un cours, l'utilisateur doit indiquer le nom du cours puis la note de l'élève. Si la note est incorrect ou si le cours n'existe pas, une exception doit être générée et traitée.

# Exercice 2

Trouver l' (ou les) erreur(s) dans le programme

```Java
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
```