// Exemple 1
public class Rectangle {
    private int longueur;
    private int largeur;

    public Rectangle(int longueur, int largeur) {
        // Le this. est obligatoire pour faire la distinction entre longueur en tant que paramètre du constructeur
        //  et longueur en tant que propriété de la classe
        this.largeur = largeur;
        this.longueur = longueur;
    }
}

public class Carre extends Rectangle {
    public Carre(int cote) {
        // L'idée ici est de passer la même valeur pour les deux paramètres du constructeur parent (rectangle)
        super(cote, cote);
    }
}

// Exmple 2
public class Person {
    public String lastName;
    public String firstName;

    Person(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
}

public class Employee extends Person {
    public String departement;

    public Employee(String lastName, String firstName, String departement) {
        // ! Le super doit être la première instruction de constructeur enfant ! 
        super(lastName, firstName);
        this.departement = departement;
    }
}

// Exemple 3a
public class T1 {
    public T() {
        /* ... */
    }
}

public class S1 extends T1 {
    public S() {
        /* Si on ne spécifie pas super(), 
            Java utilise automatiquement le constructeur parent sans paramèter */
    }
}

// Exemple 3b
public class T2 {
    /* Si aucun constructeur n'est présent, le constructeur sans paramètre est
     automatiquement créé */
}

public class S2 extends T2 {
    public S2() {
        super(); // Valide 
    }
}

// Exemple 3c
public class T3 {
    public T(int a) {} 
}

public class S3 extends T3 {
    public S() {
        /* Pas valide, le constructeur parent n'a pas de constructeur par défault
        Il faut donc spécifier quel constructeur on utilise (ici il n'y en a qu'un de disponible) */
        super(5);
    }
}