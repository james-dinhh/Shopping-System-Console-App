/**
 * @author <Dinh Le Hong Tin - s3932134>
 */
package org.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ShoppingCart implements Comparable<ShoppingCart> {
    private HashSet<String> cart;
    private Set<String> items;
    private ProductService productService;
    private static Scanner scanner = new Scanner(System.in);

    public ShoppingCart(ProductService productService) {
        this.cart = new HashSet<>();
        this.items = new HashSet<>();
        this.productService = productService;
    }

    public boolean addItem(String productName) {
        Product product = productService.getProductByName(productName);
        if (product == null || product.getQuantity() == 0 || cart.contains(productName)) {
            return false;
        }
        product.setQuantity(product.getQuantity() - 1);
        cart.add(productName);
        return true;
    }



    public boolean removeItem(String productName) {
        Product product = productService.getProductByName(productName);
        if (product == null || !cart.contains(productName)) {
            return false;
        }
        product.setQuantity(product.getQuantity() + 1);
        cart.remove(productName);
        return true;
    }

    public double cartAmount() {
        double total = 0.0;
        double totalWeight = 0.0;
        double shippingFee = 0.0;
        for (String productName : cart) {
            Product product = productService.getProductByName(productName);
            if (product instanceof PhysicalProduct) {
                totalWeight += ((PhysicalProduct) product).getWeight();
            }
            total += product.getPrice();
        }
        shippingFee = total + totalWeight * 0.1;
        return shippingFee;
    }

    public double getTotalWeight() {
        double total = 0.0;
        for (String itemName : items) {
            Product product = productService.getProductByName(itemName);
            if (product instanceof PhysicalProduct) {
                PhysicalProduct physicalProduct = (PhysicalProduct) product;
                total += physicalProduct.getWeight();
            }
        }
        return total;
    }

    @Override
    public int compareTo(ShoppingCart o) {
        double weight1 = this.getTotalWeight();
        double weight2 = o.getTotalWeight();
        return Double.compare(weight1, weight2);
    }
}
