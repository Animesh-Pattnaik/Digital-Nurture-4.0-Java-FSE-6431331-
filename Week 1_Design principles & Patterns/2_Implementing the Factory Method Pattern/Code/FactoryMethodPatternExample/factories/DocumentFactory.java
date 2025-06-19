package factories;
import documents.Document;

// Abstract Factory class
public abstract class DocumentFactory {
    public abstract Document createDocument();
}