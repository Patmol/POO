package examen.question1;

/**
 * Course est une représentation immutable pour un plat.
 * 
 * @specfield price: real;
 * @specfield name: String;
 * @specfield type : { Principal, Dessert }
 */
public class Course {
    private float price;
    private String name;
    private CourseType type;

    public Course(float price, String name, CourseType type) {
        this.price = price;
        this.name = name;
        this.type = type;
    }

    public float getPrice() {
        return this.price;
    }

    public boolean isDessert() {
        return this.type == CourseType.Dessert;
    }

    public boolean equals(Object o) {
        if (o == null || !o.getClass().equals(this.getClass())) {
            return false;
        }

        return this.equals((Course)o);
    }

    public int hashCode() {
        int hash = 17;

        hash += hash * 31 + (int)this.price;
        hash += hash * 31 + this.name.hashCode();
        hash += hash * 31 + this.type.hashCode();
    }

    public boolean repOK() {
        return true;
    }

    public String toString() {
        return "Name: " + this.name 
            + ", Price: " + this.price + ", Type: " 
            + this.type == CourseType.Principal ? "principal" : "dessert";
    } 

    private boolean equals(Course c) {
        return c.name == this.name && c.price == this.price && c.type == this.name;
    }
}