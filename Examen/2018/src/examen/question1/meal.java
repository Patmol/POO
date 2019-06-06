package examen.question1;

import java.util.List;

import javafx.util.Pair;

public class Meal implements Cloneable {
    // FA(c) : Un repas r tel quel
    // r.ordered est la liste des plats commandés ainsi que pour chaque plat, le nombre de plat commandé. 
    //  Les plats sont distinct. Si r.status 
    // r.status = c.dessertOrdered

    // IR(c) :
    // r.ordered != null && r.ordered.size >= 0
    // Il n'y a pas de Course doublons dans r.ordered
    // Si un dessert a été commande, dessertOrdered est à true

    private List<Course> ordered;
    private boolean dessertOrdered;

    /**
     * @effects Crée un repas avec une liste de plat commandé vide et un status MAIN.
     */
    public Meal() {
        this.ordered = new ArrayList<Course>();
        this.dessertOrdered = false;
    }

    /**
     * @modifies this
     * @effects
     *  si on est au status DESSERT this_post.ordered = this.ordered U {c} si le plat est un dessert
     *  sinon, si on est au status MAIN, this_post.ordered = this.ordered U {c}
     * @throws CourseTypeException si on essaye d'ajouter un repas principal alors qu'on est en status DESSERT
     * @throws NullPointerException si on essaye d'ajouter un repas null
     */
    public void order(Course c) throws CourseTypeException, NullPointerException {
        if (c == null) {
            throw new NullPointerException("order(Course)");
        }

        if (this.dessertOrdered && !c.isDessert()) {
            throw new CourseTypeException("order(Course)");
        }

        if (c.isDessert()) {
            this.dessertOrdered = true;
        }

        this.ordered.add(c);
    }

    /**
     * @return le prix total du repas
     */
    public float price() {
        float sum = 0;

        for (int i = 0; i < this.ordered.size(); i++) {
            sum += this.ordered.get(i).getPrice();
        }

        return sum;
    }

    public Meal clone() {
        Meal meal = new Meal();
        meal.dessertOrdered = this.dessertOrdered;
        
        for (int i = 0; i < this.ordered.size(); i++) {
            meal.ordered.add(this.ordered.get(i));
        }

        return meal;
    }
}