import java.util.HashMap;

public class InventoryManager {
    private HashMap<String, Product> inventory;

    public InventoryManager() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("Product added: " + product);
    }

    public void updateProduct(String productId, String newName, int newQuantity, double newPrice) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setProductName(newName);
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
            System.out.println("Product updated: " + product);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public void deleteProduct(String productId) {
        Product removed = inventory.remove(productId);
        if (removed != null) {
            System.out.println("Product removed: " + removed);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    public void displayAllProducts() {
        System.out.println("\n=== Current Inventory ===");
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }
}