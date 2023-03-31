/**
 * @author <Dinh Le Hong Tin - s3932134>
 */
package org.example;

import java.util.*;

public class ProductService {
    private static ArrayList<Product> productList;

    private static Scanner scanner = new Scanner(System.in);


    public ProductService() {
        this.productList = new ArrayList<Product>();
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
        System.out.println("Product added successfully.");
    }

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

    public Product getProductByName(String productName) {
        for (Product p : productList) {
            if (p.getName().equals(productName)) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }


    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }
}

