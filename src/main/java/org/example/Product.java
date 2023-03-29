/**
 * @author <Dinh Le Hong Tin - s3932134>
 */
package org.example;

public abstract class Product {
    //Attributes
    private String name;
    private String description;
    private int quantity;
    private double price;
    private String message;


    //Constructor
    public Product(String name, String description, int quantity, double price) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public Product(String name, double price, double weight) {
    }

    public abstract String getType();

    public String toString() {
        return name + " - " + description + " - " + quantity + " available - $" + price + " - " + getType();
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
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
