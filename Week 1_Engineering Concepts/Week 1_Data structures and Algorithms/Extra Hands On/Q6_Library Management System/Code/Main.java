public class Main {
    public static void main(String[] args) {
        LibraryManager library = new LibraryManager(5);

        library.addBook(new Book("B101", "Java Programming", "Hari Nayak"));
        library.addBook(new Book("B102", "Python Basics", "Devansh Bansal"));
        library.addBook(new Book("B103", "Data Structures", "Adi Pattnaik"));

        library.displayAllBooks();

        Book book1 = library.linearSearchByTitle("Python Basics");
        System.out.println("\nLinear Search Result: " + (book1 != null ? book1 : "Not Found"));

        Book book2 = library.binarySearchByTitle("Data Structures");
        System.out.println("\nBinary Search Result: " + (book2 != null ? book2 : "Not Found"));
    }
}
