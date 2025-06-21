import java.util.Arrays;
import java.util.Comparator;

public class BinarySearch {
    public static int search(Product[] products, String productName) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compareResult = products[mid].getProductName().compareToIgnoreCase(productName);

            if (compareResult == 0) {
                return mid;
            } else if (compareResult < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void sortProducts(Product[] products) {
        Arrays.sort(products, Comparator.comparing(Product::getProductName));
    }
}