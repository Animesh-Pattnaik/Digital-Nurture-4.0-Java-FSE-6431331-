public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp1 = new MobileApp("MobileApp One");
        Observer webApp1 = new WebApp("WebApp One");

        stockMarket.registerObserver(mobileApp1);
        stockMarket.registerObserver(webApp1);

        stockMarket.setStockPrice(105.50);

        Observer mobileApp2 = new MobileApp("MobileApp Two");
        stockMarket.registerObserver(mobileApp2);

        stockMarket.setStockPrice(112.75);

        stockMarket.deregisterObserver(webApp1);

        stockMarket.setStockPrice(120.10);
    }
}
