/**
 * @author <Dinh Le Hong Tin - s3932134>
 */
package org.example;

public class DigitalProduct extends Product implements GiftProduct {
    public DigitalProduct(String name, String description, int quantity, double price) {
        super(name, description, quantity, price);
    }

    @Override
    public String getType() {
        return "DIGITAL - " + getName();
    }
}
