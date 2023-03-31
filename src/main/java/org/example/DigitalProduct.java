/**
 * @author <Dinh Le Hong Tin - s3932134>
 */
package org.example;

public class DigitalProduct extends Product {
    public DigitalProduct(String name, String description, int quantity, double price) {
        super(name, description, quantity, price);
    }

    @Override
    public String getType() {
        return "DIGITAL - " + this.getName();
    }

    @Override
    public void displayInfo() {
        System.out.println("Name: " + this.name + " - Description: " + this.description + " - Quantity: " + this.quantity + " - Price: " + this.price);
    }
}
