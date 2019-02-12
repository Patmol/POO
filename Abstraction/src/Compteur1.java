/**
 * @overview Permet d'incrémenter et de décrémenter un compteur. 
 *  Le compteur est initialiser à 2. Lors de l'incrémentation, la valeur est doublé.
 *  La valeur est décrémenté par 1 sans passer en deça de 0.
 */
public class Compteur1 {
    private int valeur;

    /**
     * @effects Initiliaze un nouveau compteur à 0.
     */
    public Compteur1() {
        this.valeur = 2;
    }

    /**
     * @modifiers this
     * @effects Incrémente la valeur en la doublant.
     */
    public void incr() {
        this.valeur *= 2;
    }

    /**
     * @modifiers this
     * @effects Décrémente la valeur du compteur de 1. Si celle-ci est à 0, 
     *  le compteur ne diminue pas en deça et reste à 0.
     */
    public void decr() {
        if (this.valeur > 0) {
            this.valeur--;
        }
    }

    /**
     * @return Une chaine de caractère donnant la valeur du compteur.
     */
    public String toString() {
        return "La valeur est " + this.valeur;
    }
}