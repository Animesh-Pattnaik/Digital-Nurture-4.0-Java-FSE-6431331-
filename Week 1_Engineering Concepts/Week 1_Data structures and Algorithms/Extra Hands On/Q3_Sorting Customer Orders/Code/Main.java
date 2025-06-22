public class Main {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("O101", "Hari", 4500),
            new Order("O102", "Raju", 8500),
            new Order("O103", "Suresh", 2300),
            new Order("O104", "Ravi", 12900)
        };

        System.out.println("Original Orders:");
        for (Order o : orders) System.out.println(o);

        BubbleSort.bubbleSort(orders);
        System.out.println("\nAfter Bubble Sort (by Total Price):");
        for (Order o : orders) System.out.println(o);

        Order[] quickOrders = {
            new Order("O101", "Hari", 4500),
            new Order("O102", "Raju", 8500),
            new Order("O103", "Suresh", 2300),
            new Order("O104", "Ravi", 12900)
        };

        QuickSort.quickSort(quickOrders, 0, quickOrders.length - 1);
        System.out.println("\nAfter Quick Sort (by Total Price):");
        for (Order o : quickOrders) System.out.println(o);
    }
}
