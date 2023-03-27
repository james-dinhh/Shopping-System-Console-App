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

        ProductService productService = new ProductService();
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        ShoppingCart currentCart = null;

        Scanner scanner = new Scanner(System.in);

        while (true) {
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
                    System.out.println("Enter product name:");

                    break;
                case 2:
                    System.out.println("Enter product name to edit:");

                    break;
                case 3:

                case 4:

                case 5:
            }
        }
    }
}

