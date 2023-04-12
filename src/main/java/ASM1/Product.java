/**
 * @author <Dinh Le Hong Tin - s3932134>
 *     Sources: https://github.com/TriDang/cosc2440-2023-s1
 *     https://www.jetbrains.com/help/idea/class-diagram.html
 *
 */
package ASM1;

/**
 * The type Product.
 */
public abstract class Product implements GiftProduct {
    /**
     * The Name.
     */
//Attributes
    protected String name;
    /**
     * The Description.
     */
    protected String description;
    /**
     * The Quantity.
     */
    protected int quantity;
    /**
     * The Price.
     */
    protected double price;
    /**
     * The Message.
     */
    protected String message;


    /**
     * Instantiates a new Product.
     *
     * @param name        the name
     * @param description the description
     * @param quantity    the quantity
     * @param price       the price
     */
//Constructor
    public Product(String name, String description, int quantity, double price) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.message = "";
    }


    /**
     * Gets type.
     *
     * @return the type
     */
    public abstract String getType();

    public String toString() {
        return "Name: " + this.name + " - Description: " + this.description + " - Quantity: " + this.quantity + " - Price: " + this.price;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets quantity.
     *
     * @param quantity the quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
