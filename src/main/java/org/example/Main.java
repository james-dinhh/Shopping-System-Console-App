/**
 * @author <Dinh Le Hong Tin - s3932134>
 */
package org.example;
import java.util.*;

public class Main {
    public static void welcomeScreen() {
        System.out.println();
        System.out.println("------------------------------");
        System.out.println("COSC2440 | FURTHER PROGRAMMING | INDIVIDUAL PROJECT");
        System.out.println("WELCOME TO ONLINE SHOPPING SERVICE");
        System.out.println("Instructor: Mr. Tri Dang");
        System.out.println("s3932134, Dinh Le Hong Tin");
        System.out.println("------------------------------");

    }

    private static ProductService productService = new ProductService();
    private static Set<ShoppingCart> shoppingCarts = new HashSet<>();
    private static ArrayList<Product> productList;

    public static void main(String[] args) {

        welcomeScreen();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Please select an option:");
            System.out.println("1. Create new product");
            System.out.println("2. Edit product");
            System.out.println("3. Create new shopping cart");
            System.out.println("4. Add product to shopping cart");
            System.out.println("5. Remove product from shopping cart");
            System.out.println("6. Display cart amount");
            System.out.println("7. Display all shopping carts based on total weight");
            System.out.println("8. Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("YOU ARE CREATING A PRODUCT ...");
                    ProductService.createProduct();
                    break;
                case 2:
                    System.out.println("YOU ARE EDITING THE PRODUCT ...");
                    ProductService.editProduct();
                    break;
                case 3:
                    System.out.println("YOU ARE CREATING A SHOPPING CART ...");
                    createShoppingCart();
                    break;
                case 4:
                    System.out.println("YOU ARE ADDING A PRODUCT TO THE SHOPPING CART ...");
                    addItem();
                    break;
                case 5:
                    System.out.println("YOU ARE REMOVING A PRODUCT FROM THE SHOPPING CART ...");
                    removeItem();
                    break;
                case 6:
                    System.out.println("Display the cart amount");
                    calculateCartAmount();
                    break;
                case 7:
                    System.out.println("Display all shopping carts based on total weight");

                    break;
                case 8:
                    System.out.println("Exiting ...");
                    isRunning = false;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

    }
    private static void createShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart(productService);
        shoppingCarts.add(shoppingCart);
        System.out.println("New shopping cart created!");
    }
    private static void addItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        for (ShoppingCart shoppingCart : shoppingCarts) {
            if (shoppingCart.addItem(productName)) {
                System.out.println("Item added to shopping cart.");
                return;
            }
        }
        System.out.println("Unable to add item to shopping cart.");
    }
    private static void removeItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        for (ShoppingCart shoppingCart : shoppingCarts) {
            if (shoppingCart.removeItem(productName)) {
                System.out.println("Item removed from shopping cart.");
                return;
            }
        }
        System.out.println("Unable to remove item from shopping cart.");
    }
    public static void calculateCartAmount() {
        for (ShoppingCart shoppingCart : shoppingCarts) {
            double totalAmount = shoppingCart.cartAmount();
            System.out.println("Total cart amount: " + totalAmount);
            }
        }
    }


