/**
 * @overview Permet d'incrémenter et de décrémenter un compteur. 
 *  Le compteur est initialiser à -5. La valeur est incrémenté par pas de 2.
 *  La valeur est décrémenté par 1 sans passer en deça de 0.
 */
public class Compteur2 {
    private int valeur;

    /**
     * @effects Initiliaze un nouveau compteur à 0.
     */
    public Compteur2() {
        this.valeur = 2;
    }

    /**
     * @modifiers this
     * @effects Incrémente la valeur en l'augmentant par pas de 2.
     */
    public void incr() {
        this.valeur *= 2;
    }

    /**
     * @modifiers this
     * @effects Décrémente la valeur du compteur de 1.
     */
    public void decr() {
        this.valeur--;
    }
    
    /**
     * @return Une chaine de caractère donnant la valeur du compteur.
     */
    public String toString() {
        return "La valeur est " + this.valeur;
    }
}