package examen.question1;

public class CodeCoursNonValideException extends Exception {
    private static final long serialVersionUID = 1L;
}

public static class Bourse {
    public static float donneeCours(String codeCours) throws CodeCoursNonValideException {
        return 12;
    }
}