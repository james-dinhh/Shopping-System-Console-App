/**
 * @author <Dinh Le Hong Tin - s3932134>
 *     Sources: https://github.com/TriDang/cosc2440-2023-s1
 *     https://www.jetbrains.com/help/idea/class-diagram.html
 *
 */
package ASM1;

import java.util.*;

/**
 * The type Shopping cart.
 */
public class ShoppingCart implements Comparable<ShoppingCart> {
    private HashSet<String> cart;
    private ProductService productService;

    /**
     * Instantiates a new Shopping cart.
     *
     * @param productService the product service
     */
    public ShoppingCart(ProductService productService) {
        this.cart = new HashSet<>();
//        this.items = new HashSet<>();
        this.productService = productService;
    }

    /**
     * Gets cart.
     *
     * @return the cart
     */
    public HashSet<String> getCart() {
        return cart;
    }

    /**
     * Sets cart.
     *
     * @param cart the cart
     */
    public void setCart(HashSet<String> cart) {
        this.cart = cart;
    }

    /**
     * Gets product service.
     *
     * @return the product service
     */
    public ProductService getProductService() {
        return productService;
    }

    /**
     * Sets product service.
     *
     * @param productService the product service
     */
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Check existed product on cart boolean.
     *
     * @param productName the product name
     * @return the boolean
     */
    public boolean checkExistedProductOnCart(String productName) {
        for (String item : cart) {
            if (item.equals(productName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Add item boolean.
     *
     * @param productName the product name
     * @return the boolean
     */
    public boolean addItem(String productName) {
        Product product = productService.getProductByName(productName);
        if (product == null || product.getQuantity() == 0 || cart.contains(productName)) {
            return false;
        }
        Set<String> newCart = new HashSet<>(cart);
        newCart.add(productName);
        product.setQuantity(product.getQuantity() - 1);
        cart.add(productName);
        return true;
    }


    /**
     * Remove item boolean.
     *
     * @param productName the product name
     * @return the boolean
     */
    public boolean removeItem(String productName) {
        Product product = productService.getProductByName(productName);
        if (product == null || !cart.contains(productName)) {
            return false;
        }
        product.setQuantity(product.getQuantity() + 1);
        cart.remove(productName);
        return true;
    }

    /**
     * Cart amount double.
     *
     * @return the double
     */
    public double cartAmount() {
        double total = 0.0;
        double totalWeight = 0.0;
        for (String productName : cart) {
            Product product = productService.getProductByName(productName);
            if (product instanceof PhysicalProduct && checkExistedProductOnCart(product.getName())) {
                totalWeight += ((PhysicalProduct) product).getWeight();
            }
            total += product.getPrice();
        }
        return total + totalWeight * 0.1;
    }

    /**
     * Gets total weight.
     *
     * @return the total weight
     */
    public double getTotalWeight() {
        double total = 0.0;

        for (Product product : productService.getProductList()) {
            if (product instanceof PhysicalProduct && checkExistedProductOnCart(product.getName()) ) {
                PhysicalProduct physicalProduct = (PhysicalProduct) product;
                total += physicalProduct.getWeight();
            }
        }
        return total;
    }

    @Override
    public String toString() {

        return "This cart includes: " + this.cart + "\nTotal weight: "
                + this.getTotalWeight() + "\nTotal payment : " + this.cartAmount() + "\n     --------    ";
    }

    @Override
    public int compareTo(ShoppingCart cart) {
        double weight1 = this.getTotalWeight();
        double weight2 = cart.getTotalWeight();
        return Double.compare(weight1, weight2);
    }

}
