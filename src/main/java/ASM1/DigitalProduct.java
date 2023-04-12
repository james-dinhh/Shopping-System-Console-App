/**
 * @author <Dinh Le Hong Tin - s3932134>
 *     Sources: https://github.com/TriDang/cosc2440-2023-s1
 *     https://www.jetbrains.com/help/idea/class-diagram.html
 *
 */
package ASM1;

/**
 * The type Digital product.
 */
public class DigitalProduct extends Product {
    private String type = "digital";

    /**
     * Instantiates a new Digital product.
     *
     * @param name        the name
     * @param description the description
     * @param quantity    the quantity
     * @param price       the price
     */
    public DigitalProduct(String name, String description, int quantity, double price) {
        super(name, description, quantity, price);
    }

    @Override
    public String getType() {
        return this.type;
    }
    @Override
    public String toString() {

        return "DIGITAL - " + this.getName();
    }
}
