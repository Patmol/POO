import java.lang.*;
import java.util.*;

/**
 * @overview Les MultiSets sont des ensembles non bornés d'entiers qui * peuvent contenir des doublons.
 * Ils sont immutables.
 * De manière générale, un MultiSet est défini comme {x1,...,xn}
 * où x1,...,xn sont des entiers.
 * @invariant size = #this
 */
public class MultisetImmutable {
    private List<Integer> list; 

    /**
     * @effects initialise this à l'ensemble vide
     */
    public MultisetImmutable() {
        this.list = new ArrayList<Integer>();
    }

    /**
     * @effects initialise this avec une copie du multiset passé en paramètre
     */
    private MultisetImmutable(MultisetImmutable set) {
        this.list = new ArrayList<Integer>();

        for(int i = 0; i < this.list.size(); i++) {
            this.list.add(set.get(i));
        }
    }

    /**
     * @return un nouveau mutliset avec l'élement i en plus
     */
    public MultisetImmutable insert(int i) { 
        MultisetImmutable set = new MultisetImmutable(this);

        set.list.add(i);

        return set;
    }

    /**
     * @return un nouveau mutliset avec l'élement i en moins
     */
    public MultisetImmutable remove(int i) { 
        MultisetImmutable set = new MultisetImmutable(this);

        set.list.remove(i);

        return set;
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

    private boolean equals(MultisetImmutable set) {
        if (this.list.size() != set.list.size()) {
            return false;
        }

        for(int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i) != set.list.get(i)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MultisetImmutable)) {
            return false;
        }

        return this.equals((MultisetImmutable)obj);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.list.hashCode();
        return result;
    }
}