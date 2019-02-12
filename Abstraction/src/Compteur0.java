/**
 * @overview Permet d'incrémenter et de décrémenter un compteur. 
 *  Le compteur est initialiser à 0. Il ne peut pas être décrémenté en deça de 0. 
 */
public class Compteur0 {
    private int valeur;

    /**
     * @effects Initiliaze un nouveau compteur à 0.
     */
    public Compteur0() {
        this.valeur = 0;
    }

    /**
     * @modifiers this
     * @effects Incrémente la valeur du compteur de 1.
     */
    public void incr() {
        this.valeur++;
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