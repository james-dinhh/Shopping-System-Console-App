package org.example;
import java.util.*;

public class ShoppingService {
    public static void welcomeScreen() {
        System.out.println();
        System.out.println("------------------------------");
        System.out.println("COSC2440 | FURTHER PROGRAMMING | INDIVIDUAL PROJECT");
        System.out.println("WELCOME TO ONLINE SHOPPING SERVICE");
        System.out.println("Instructor: Mr. Tri Dang");
        System.out.println("s3932134, Dinh Le Hong Tin");
        System.out.println("------------------------------");
        System.out.println();
    }

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
                    System.out.println("YOU ARE CREATING A PRODUCT");
                    String name;
                    while (true) {
                        System.out.println("What is the name of the product:");
                        name = scanner.nextLine();
                        // Check if product name exist
                        if (isProductExisted(name)) {
                            System.out.println("Product name already exist. Please enter different name");
                            // Stop until product name is valid
                        } else {
                            break;
                        }
                    }
                    System.out.print("Enter product description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.print("Is this a physical product? (y/n): ");
                    boolean isPhysical = scanner.nextLine().equalsIgnoreCase("y");

                    Product product;
                    if (isPhysical) {
                        System.out.print("Enter product weight: ");
                        double weight = Double.parseDouble(scanner.nextLine());

                        product = new PhysicalProduct(name, description, price, weight);
                    } else {
                        product = new DigitalProduct(name, description, price);
                    }

                    break;
                case 2:
                    System.out.println("Enter product name to edit:");

                    break;
                case 3:

                case 4:

                case 5:

                case 6:
                case 7:
                case 8:
                    isRunning = false;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;

            }
        }
    }
//    }
//    private static ArrayList<Product> productList = new ArrayList<Product>();
//    private static ArrayList<ShoppingCart> cartList = new ArrayList<ShoppingCart>();
//    private static ShoppingCart currentCart;

    private static ArrayList<Product> productList;
    private static ArrayList<ShoppingCart> cartList;
    private static ShoppingCart currentCart;

    public ShoppingService() {
        productList = new ArrayList<Product>();
        cartList = new ArrayList<ShoppingCart>();
//        currentCart = new ShoppingCart();
    }

    protected ArrayList<Product> getProductList() {
        return productList;
    }

    public static boolean isProductExisted(String name) {
        for (Product product : productList) {
            if (product.getName().equals(name)) {
                System.out.println("Product already exists");
                return true;
            }
        }
        return false;
    }

    public void createProduct(Product product) {
        productList.add(product);
    }



}

