/**
 * @author <Dinh Le Hong Tin - s3932134>
 *     Sources: https://github.com/TriDang/cosc2440-2023-s1
 *     https://www.jetbrains.com/help/idea/class-diagram.html
 *
 */
package ASM1;
import java.util.*;

public class Main {
    public static void welcomeScreen() {
        System.out.println();
        System.out.println("------------------------------");
        System.out.println("COSC2440 | FURTHER PROGRAMMING | INDIVIDUAL PROJECT");
        System.out.println("WELCOME TO ONLINE SHOPPING SERVICE");
        System.out.println("Instructor: Mr. Tri Dang");
        System.out.println("s3932134, Dinh Le Hong Tin");
    }
    public static void menuUI() {
        System.out.println("-".repeat(30));
        System.out.println("Please select an option:");
        System.out.println("1. Create new product");
        System.out.println("2. Edit product");
        System.out.println("3. Create new shopping cart");
        System.out.println("4. Add product to shopping cart");
        System.out.println("5. Remove product from shopping cart");
        System.out.println("6. Display cart amount");
        System.out.println("7. Display all shopping carts based on total weight");
        System.out.println("0. Exit");
        System.out.println("-".repeat(30));
    }

    private static ProductService productService = new ProductService();
    private static ArrayList<ShoppingCart> shoppingCartList = new ArrayList<ShoppingCart>();
    private static ShoppingCart shoppingCart = new ShoppingCart(productService);
    private static ArrayList<Product> productList = new ArrayList<Product>();


    public static void main(String[] args) {

        welcomeScreen();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            menuUI();
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("-".repeat(30));
                    System.out.println("YOU ARE CREATING A PRODUCT ...");
                    System.out.println("-".repeat(30));
                    ProductService.createProduct();
                    break;
                case 2:
                    System.out.println("-".repeat(30));
                    System.out.println("YOU ARE EDITING THE PRODUCT ...");
                    System.out.println("-".repeat(30));
                    ProductService.editProduct();
                    break;
                case 3:
                    System.out.println("-".repeat(30));
                    System.out.println("YOU ARE CREATING A SHOPPING CART ...");
                    System.out.println("-".repeat(30));
                    createShoppingCart();
                    break;
                case 4:
                    System.out.println("-".repeat(30));
                    System.out.println("YOU ARE ADDING A PRODUCT TO THE SHOPPING CART ...");
                    System.out.println("-".repeat(30));
                    addItemToCurrentCart();
                    break;
                case 5:
                    System.out.println("-".repeat(30));
                    System.out.println("YOU ARE REMOVING A PRODUCT FROM THE SHOPPING CART ...");
                    System.out.println("-".repeat(30));
                    removeItemFromCurrentCart();
                    break;
                case 6:
                    System.out.println("-".repeat(30));
                    System.out.println("Display the cart amount");
                    System.out.println("-".repeat(30));
                    calculateCartAmount();
                    break;
                case 7:
                    System.out.println("-".repeat(30));
                    System.out.println("Display all shopping carts based on total weight");
                    System.out.println("-".repeat(30));
                    displayAllShoppingCart();
                    break;
                case 0:
                    System.out.println("Exiting ...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

    }

    public static void createShoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart(productService);
        shoppingCartList.add(shoppingCart);
        System.out.println("New shopping cart created!");
    }
    public static void addItemToCurrentCart() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        ShoppingCart lastShoppingCart = shoppingCartList.get(shoppingCartList.size() - 1);

        if (lastShoppingCart.addItem(productName)) {
            System.out.println("Item added to shopping cart.");
            System.out.println("Remaining quantities of product is: " + shoppingCart.getProductService().getProductByName(productName).getQuantity());

            return;
        }
        System.out.println("Unable to add item to shopping cart.");
    }

    public static void removeItemFromCurrentCart() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();
        for (ShoppingCart shoppingCart : shoppingCartList) {
            if (shoppingCart.removeItem(productName)) {
                System.out.println("Item removed from shopping cart.");
                System.out.println("Remaining quantities of product is: " + shoppingCart.getProductService().getProductByName(productName).getQuantity());
                return;
            }
        }
        System.out.println("Unable to remove item from shopping cart.");
    }

    public static void calculateCartAmount() {
        for (ShoppingCart shoppingCart : shoppingCartList) {
            double totalAmount = shoppingCart.cartAmount();
            System.out.println("Total cart amount: " + totalAmount);
        }
    }
    public static void displayAllShoppingCart() {
        // Sort ascending
        Collections.sort(shoppingCartList, new Comparator<ShoppingCart>() {
            @Override
            public int compare(ShoppingCart cart1, ShoppingCart cart2) {
                return Double.compare(cart1.getTotalWeight(), cart2.getTotalWeight());
            }
        });

        for (ShoppingCart shoppingCart : shoppingCartList) {
            System.out.println(shoppingCart.toString());
        }
    }
}




