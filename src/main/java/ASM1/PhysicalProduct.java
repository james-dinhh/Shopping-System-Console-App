/**
 * @author <Dinh Le Hong Tin - s3932134>
 */
package ASM1;

/**
 * The type Physical product.
 */
public class PhysicalProduct extends Product {
    private String type = "physical";
    //Attributes
    private double weight;

    /**
     * Instantiates a new Physical product.
     *
     * @param name        the name
     * @param description the description
     * @param quantity    the quantity
     * @param price       the price
     * @param weight      the weight
     */
//Constructor
    public PhysicalProduct(String name, String description, int quantity, double price, double weight) {
        super(name, description, quantity, price);
        this.weight = weight;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
//Getter and Setter methods
    public double getWeight() {
        return weight;
    }

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String toString() {

        return "PHYSICAL - " + this.getName();
    }
}
