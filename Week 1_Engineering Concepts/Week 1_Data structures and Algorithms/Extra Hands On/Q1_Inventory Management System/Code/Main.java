public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        manager.addProduct(new Product("P001", "Keyboard", 50, 799.99));
        manager.addProduct(new Product("P002", "Mouse", 75, 499.50));
        manager.addProduct(new Product("P003", "Monitor", 30, 8999.00));

        manager.updateProduct("P002", "Wireless Mouse", 70, 599.00);

        manager.deleteProduct("P003");

        manager.displayAllProducts();
    }
}