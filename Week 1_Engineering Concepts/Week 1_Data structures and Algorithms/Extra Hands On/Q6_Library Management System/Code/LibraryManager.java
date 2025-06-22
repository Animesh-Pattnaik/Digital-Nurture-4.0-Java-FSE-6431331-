import java.util.Arrays;
import java.util.Comparator;

public class LibraryManager {
    private Book[] books;
    private int count;

    public LibraryManager(int capacity) {
        books = new Book[capacity];
        count = 0;
    }

    public void addBook(Book book) {
        if (count < books.length) {
            books[count] = book;
            count++;
            System.out.println("Added: " + book);
        } else {
            System.out.println("Library is full.");
        }
    }

    public void displayAllBooks() {
        System.out.println("\n=== Book List ===");
        for (int i = 0; i < count; i++) {
            System.out.println(books[i]);
        }
    }

    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public Book binarySearchByTitle(String title) {
        Arrays.sort(books, 0, count, Comparator.comparing(Book::getTitle));

        int left = 0, right = count - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].getTitle().compareToIgnoreCase(title);

            if (cmp == 0) return books[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }
}