import java.lang.*;
import java.util.*;

/**
 * @overview Les MultiSets sont des ensembles non bornés d'entiers qui * peuvent contenir des doublons.
 * Ils sont mutables.
 * De manière générale, un MultiSet est défini comme {x1,...,xn}
 * où x1,...,xn sont des entiers.
 * @invariant size = #this
 */
public class MultisetMutable {
    private List<Integer> list; 

    /**
     * @effects initialise this à l'ensemble vide
     */
    public MultisetMutable() {
        this.list = new ArrayList<Integer>();
    }

    /**
     * @modifies this
     * @effects this_post = this U {x}
     */
    public void insert(int i) { 
        this.list.add(i);
    }

    /**
     * @modifies this 
     * @effects this_post = this \ {x}
     */
    public void remove(int i) { 
        this.list.remove((Object)i);
    }

    /**
     * @return true sir x appartient à la list, aussi non, false
     */
    public boolean isIn(int i) { 
        return this.list.indexOf(i) != 0;
    }

    /**
     * @return la taille du mutliset
     */
    public int size() { 
        return this.list.size();
    }

    /**
     * @return le nombre d'occurence d'une valeur
     */
    public int numberOfOccurrences(int i) {
        int numberOfOccurences = 0;

        for(int index = 0; index < this.list.size(); index++) {
            if (this.list.get(index) == i) {
                numberOfOccurences++;
            }
        }

        return numberOfOccurences;
    }

    /**
     * @return un élément de la list au hasard
     * @throws NullPointerException si this est vide
     */
    public int choose() throws NullPointerException {
        if (this.list.size() == 0) {
            throw new NullPointerException();
        }

        return this.list.get(0);
    }
}