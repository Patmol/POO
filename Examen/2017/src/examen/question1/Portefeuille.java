package examen.question1;

import java.util.*;

/**
 * @overview Un portefeuille sert à contenir un ensemble de EStock détenus par une personne morale ou physique
 * appelée Porteur
 * Un porteur est mutable.
 * @specfield stocks : List<EStock> une liste de EStock
 * @specfield porteur : le Porteur du portefeuille
 * @invariant #this.stock >= 0 et this.porteur != null
 */
public class Portefeuille implements Iterable<EStock> {
    /*
     * FA(c) = c.stocks && c.porteur
     * IR(c) = #c.stocks >= 0 && c.porteur != null
     */

    private List<EStock> stocks;
    private Porteur porteur;
    
    /**
     * @throws NullPointerException si le porteur est == null
     * @effects créé un portefeuille telle que la liste de stocks est vide et this.porteur = porteur
     */
    public Portefeuille(Porteur porteur) throws NullPointerException {
        if (porteur == null) {
            throw new NullPointerException("Portefeuille");
        } 

        this.porteur = porteur;
        this.stocks = new ArrayList<EStock>();
    }

    public Portefeuille(Portefeuille portefeuille) {
        this.porteur = portefeuille.porteur;

        for (EStock stock : portefeuille.stocks) {
            this.stocks.ajouterEStock(new EStock(stock.donneCode(), stock.donneId()));
        }
    }

    /**
     * @modifies this
     * @effects this_post.stock = this.stock U { stock } 
     */
    public void ajouterEStock(EStock stock) {
        this.stocks.add(stock);
    }

    /**
     * @modifies this
     * @effects this_post = this \ { stock }
     */
    public void retirerEStock(EStock stock) {
        this.stocks.remove(stock);
    }

    /**
     * @throws CodeCoursNonValideException si un code d'un stock n'est pas connu
     * @return le total des cours des stocks
     */
    public float donneValeurPortefeuille() throws CodeCoursNonValideException {
        float total = 0;

        for (EStock stock : stocks) {
            try {
                total += Bourse.donneeCours(stock.donneCode());
            } catch(CodeCoursNonValideException ex) {
                throw new CodeCoursNonValideException("donneValeurPortefeuille()");
            }
        }

        return total;
    }

    /**
     * @throws CodeCoursNonValideException si le code du stock n'est pas connu
     * @return le cours du stock
     */
    public float donneValeur(EStock stock) throws CodeCoursNonValideException {
        try {
            return Bourse.donneeCours(stock.donneCode());
        } catch(CodeCoursNonValideException ex) {
            throw new CodeCoursNonValideException("donneValeur(EStock)");
        }
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();

        toString.append(this.porteur);
        toString.append(" Stocks: ");

        for (EStock stock : stocks) {
            toString.append(stock);
            toString.append(" ");
        }

        return toString.toString();
    }

    @Override
    public Portefeuille clone() {
        return new Portefeuille(this);
    }

    public boolean repOK() {
        return this.stocks.size() >= 0 && this.porteur != null;
    }

    /**
     * @return un générateur produisant tous les éléments de this, dans l'ordre d'entrée.
     */
    public Iterator<EStock> elements() {
        return new PortefeuilleIterator();
    }

    private class PortefeuilleIterator implements Iterator<EStock> {
        int i;

        PortefeuilleIterator() { i = 0; }

        @Override public EStock next() { i+= 1; return stocks.get(i); }
        @Override public boolean hasNext() { return i < stocks.size(); }
        @Override public void remove() {
            throw new UnsupportedOperationException("Portefeuille.PortefeuilleIterator.remove()");
        }
    }
}