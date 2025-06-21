public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Fashion"),
            new Product(103, "Watch", "Accessories"),
            new Product(104, "Phone", "Electronics"),
            new Product(105, "T-Shirt", "Clothes"),
            new Product(106, "Headphones", "Electronics"),
            new Product(107, "Backpack", "Travel"),
            new Product(108, "Sunglasses", "Fashion"),
            new Product(109, "Camera", "Electronics"),
            new Product(110, "Book", "Stationery")
        };

        long linearStart = System.nanoTime();
        int linearIndex = LinearSearch.search(products, "Book");
        long linearEnd = System.nanoTime();
        long linearDuration = linearEnd - linearStart;

        System.out.println("Linear Search: 'Book' found at index: " + linearIndex);
        System.out.println("Linear Search took: " + linearDuration + " nanoseconds");

        BinarySearch.sortProducts(products);

        long binaryStart = System.nanoTime();
        int binaryIndex = BinarySearch.search(products, "Book");
        long binaryEnd = System.nanoTime();
        long binaryDuration = binaryEnd - binaryStart;

        System.out.println("Binary Search: 'Book' found at index: " + binaryIndex);
        System.out.println("Binary Search took: " + binaryDuration + " nanoseconds");
    }
}