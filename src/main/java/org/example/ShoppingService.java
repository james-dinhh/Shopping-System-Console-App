//package org.example;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.Scanner;
//
//public class ShoppingService implements Comparator<ShoppingCart> {
//    private ProductService productService = new ProductService();
//    private ArrayList<ShoppingCart> shoppingCartList = new ArrayList<ShoppingCart>();
//    private ShoppingCart shoppingCart = new ShoppingCart(productService);
//
////    private ArrayList<Product> productList = new ArrayList<Product>();
//    public void createShoppingCart() {
//        ShoppingCart shoppingCart = new ShoppingCart(productService);
//        shoppingCartList.add(shoppingCart);
//        System.out.println("New shopping cart created!");
//    }
//
//    public void addItem() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter product name: ");
//        String productName = scanner.nextLine();
//        for (ShoppingCart shoppingCart : shoppingCartList) {
//            if (shoppingCart.addItem(productName)) {
//                System.out.println("Item added to shopping cart.");
//                return;
//            }
//        }
//        System.out.println("Unable to add item to shopping cart.");
//    }
//
//    public void removeItem() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter product name: ");
//        String productName = scanner.nextLine();
//        for (ShoppingCart shoppingCart : shoppingCartList) {
//            if (shoppingCart.removeItem(productName)) {
//                System.out.println("Item removed from shopping cart.");
//                return;
//            }
//        }
//        System.out.println("Unable to remove item from shopping cart.");
//    }
//
//    public void calculateCartAmount() {
//        for (ShoppingCart shoppingCart : shoppingCartList) {
//            double totalAmount = shoppingCart.cartAmount();
//            System.out.println("Total cart amount: " + totalAmount);
//        }
//    }
//    public void displayAllShoppingCart() {
//        // Sort ascending
//        Collections.sort(shoppingCartList, new Comparator<ShoppingCart>() {
//            @Override
//            public int compare(ShoppingCart cart1, ShoppingCart cart2){
//                return Double.compare(cart1.getTotalWeight(), cart2.getTotalWeight());
//            }
//        });
//
//        for (ShoppingCart shoppingCart : shoppingCartList) {
//            System.out.println(shoppingCart.toString() + "Total weight: " + this.shoppingCart.getTotalWeight());
//        }
//    }
//    public double getTotalWeight() {
//        double total = 0.0;
//
//        for (Product product : productService.getProductList()) {
//            if (product instanceof PhysicalProduct ) {
//                PhysicalProduct physicalProduct = (PhysicalProduct) product;
//                total += physicalProduct.getWeight();
//            }
//        }
//        return total;
//    }
//
//
////    @Override
////    public int compare(ShoppingCart o1, ShoppingCart o2) {
////        double weight1 = o1.getTotalWeight();
////        double weight2 = o2.getTotalWeight();
////        return Double.compare(weight1, weight2);
////    }
//}
