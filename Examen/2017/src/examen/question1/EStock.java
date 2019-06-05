package examen.question1;

public class EStock {

    private String code;
    private String idAction;

    /**
     * @throws NullPointerException si codeCours == null ou idAction == null
     * @effects crée un EStock tel que this.code et this.id = idAction
     */
    public EStock(String codeCours, String idAction) throws NullPointerException 
    { 
        this.code = codeCours;
        this.idAction = idAction;
    }

    /**
     * @return this.code
     */
    public String donneCode() { return this.code; }

    /**
     * @return this.idAction
     */
    public String donneId() { return this.idAction; }

    @Override
    public boolean equals(Object o) { return true; }

    @Override
    public int hashCode() { return 0; }

    @Override
    public String toString() { return ""; }
}