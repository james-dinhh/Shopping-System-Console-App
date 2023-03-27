package org.example;

public class PhysicalProduct extends Product{
    private double weight;
    public PhysicalProduct(String name, String description, int quantity, double price) {
        super(name, description, quantity, price);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String getType() {
        return "Physical - " + getName();
    }

    @Override
    public String toString() {
        return "PhysicalProduct{" +
                "weight=" + weight +
                '}';
    }
    public boolean isGift() {
        return false;
    }
}
