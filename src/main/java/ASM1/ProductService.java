/**
 * @author <Dinh Le Hong Tin - s3932134>
 *     Sources: https://github.com/TriDang/cosc2440-2023-s1
 *     https://www.jetbrains.com/help/idea/class-diagram.html
 *
 */
package ASM1;

import java.util.*;

/**
 * The type Product service.
 */
public class ProductService {
    private static ArrayList<Product> productList;

    private static Scanner scanner = new Scanner(System.in);


    /**
     * Instantiates a new Product service.
     */
    public ProductService() {
        this.productList = new ArrayList<Product>();
    }


    /**
     * Is product existed boolean.
     *
     * @param name the name
     * @return the boolean
     */
    public static boolean isProductExisted(String name) {
        for (Product product : productList) {
            if (product.getName().equals(name)) {
                System.out.println("Product already exists");
                return true;
            }
        }
        return false;
    }

    /**
     * Create product.
     */
    public static void createProduct() {
        String name = "";
        while (name.equals("")) {
            System.out.print("Enter product name: ");
            name = scanner.nextLine().trim();
            if (name.equals("")) {
                System.out.println("Product name cannot be empty.");
            }
        }

        if (isProductExisted(name)) {
            System.out.println("Product with name " + name + " already exists.");
            return;
        }

        System.out.print("Enter product description: ");
        String description = scanner.nextLine().trim();

        int quantity = 0;
        while (quantity <= 0) {
            System.out.print("Enter product quantity: ");
            try {
                quantity = Integer.parseInt(scanner.nextLine().trim());
                if (quantity <= 0) {
                    System.out.println("Quantity must be a positive integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity.");
            }
        }

        double price = 0;
        while (price <= 0) {
            System.out.print("Enter product price: ");
            try {
                price = Double.parseDouble(scanner.nextLine().trim());
                if (price <= 0) {
                    System.out.println("Price must be a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid price.");
            }
        }

        System.out.print("Is this a physical product? (y/n): ");
        String isPhysicalString = scanner.nextLine().trim();
        boolean isPhysical = isPhysicalString.equalsIgnoreCase("y");

        if (isPhysical) {
            double weight = 0;
            while (weight <= 0) {
                System.out.print("Enter product weight: ");
                try {
                    weight = Double.parseDouble(scanner.nextLine().trim());
                    if (weight <= 0) {
                        System.out.println("Weight must be a positive number.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid weight.");
                }
            }
            productList.add(new PhysicalProduct(name, description, quantity, price, weight));
        } else {
            productList.add(new DigitalProduct(name, description, quantity, price));
        }
        System.out.println("Product added successfully. \nIf you want to set a message for your new product, please enter number 2.");
    }

    /**
     * Edit product.
     */
    public static void editProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the product you want to edit:");
        String productName = scanner.nextLine();

        // Check if product exists
        Product productToEdit = null;
        for (Product product : productList) {
            if (product.getName().equals(productName)) {
                productToEdit = product;
                break;
            }
        }
        if (productToEdit == null) {
            System.out.println("Product not found.");
            return;
        }

        // Get new product information from user
        System.out.println("Enter the new description of the product:");
        String newDescription = scanner.nextLine();

        System.out.println("Enter the new quantity of the product:");
        int newQuantity = scanner.nextInt();

        System.out.println("Enter the new price of the product:");
        double newPrice = scanner.nextDouble();

        // Update product information
        productToEdit.setDescription(newDescription);
        productToEdit.setQuantity(newQuantity);
        productToEdit.setPrice(newPrice);

        if (productToEdit instanceof GiftProduct) {
            System.out.println("Do you want to set a greeting message for this gift product? (y/n)");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("y")) {
                System.out.println("Enter the greeting message:");
                String message = scanner.next();
                ((GiftProduct) productToEdit).setMessage(message);
            }

        }

        System.out.println("Product updated.");
    }

    /**
     * Gets product by name.
     *
     * @param productName the product name
     * @return the product by name
     */
    public static Product getProductByName(String productName) {
        for (Product p : productList) {
            if (p.getName().equals(productName)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Gets product list.
     *
     * @return the product list
     */
    public static ArrayList<Product> getProductList() {
        return productList;
    }


    /**
     * Sets product list.
     *
     * @param productList the product list
     */
    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
}

