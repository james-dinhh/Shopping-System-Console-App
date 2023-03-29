/**
 * @author <Dinh Le Hong Tin - s3932134>
 */
package org.example;

public class PhysicalProduct extends Product implements GiftProduct {
    //Attributes
    private double weight;
    //Constructor
    public PhysicalProduct(String name, String description, int quantity, double price, double weight) {
        super(name, description, quantity, price);
        this.weight = weight;
    }

    //Getter and Setter methods
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String getType() {
        return "PHYSICAL - " + getName();
    }
}
