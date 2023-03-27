package org.example;

import java.util.*;

public class ProductService {
    private Set<Product> products;

    public ProductService() {
        products = new HashSet<>();
    }

    public boolean addProduct(Product product) {
        return products.add(product);
    }

    public boolean removeProduct(Product product) {
        return products.remove(product);
    }

    public boolean updateProductQuantity(String productName, int newQuantity) {
        for (Product p : products) {
            if (p.getName().equals(productName)) {
                p.setQuantity(newQuantity);
                return true;
            }
        }
        return false;
    }

    public Product getProductByName(String productName) {
        for (Product p : products) {
            if (p.getName().equals(productName)) {
                return p;
            }
        }
        return null;
    }

    public Set<Product> getAllProducts() {
        return products;
    }
}

