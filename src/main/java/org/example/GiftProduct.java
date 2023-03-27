package org.example;

public class GiftProduct extends Product {
    public GiftProduct(String name, String description, int quantity, double price, String message) {
        super(name, description, quantity, price);
        setMessage(message);
    }

    @Override
    public String getType() {
        return "GIFT";
    }

    @Override
    public String toString() {
        return getType() + " - " + getName();
    }
}

