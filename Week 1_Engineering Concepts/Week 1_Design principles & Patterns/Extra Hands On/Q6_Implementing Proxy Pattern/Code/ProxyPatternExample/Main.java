public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("landscape_photo.jpg");

        image1.display();

        System.out.println("\nTrying to display the same image again...");

        image1.display();

        System.out.println("\nDisplaying a new image...");
        Image image2 = new ProxyImage("city_skyline.png");
        image2.display();
    }
}
