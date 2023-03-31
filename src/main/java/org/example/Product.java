/**
 * @author <Dinh Le Hong Tin - s3932134>
 */
package org.example;

public abstract class Product implements GiftProduct {
    //Attributes
    protected String name;
    protected String description;
    protected int quantity;
    protected double price;
    protected String message;


    //Constructor
    public Product(String name, String description, int quantity, double price) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.message = "";
    }

    public Product(String name, double price, double weight) {
    }

    public abstract String getType();
    public abstract void displayInfo();

    public String toString() {
        return "Name: " + this.name + " - Description: " + this.description + " - Quantity: " + this.quantity + " - Price: " + this.price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

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
