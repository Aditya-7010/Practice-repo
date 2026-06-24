public class ObserverTest {

    public static void main(String[] args) {

        StockMarket stockMarket = new StockMarket();

        Observer mobileUser = new MobileApp("Aditya");
        Observer webUser = new WebApp("Rahul");

        stockMarket.registerObserver(mobileUser);
        stockMarket.registerObserver(webUser);

   
        stockMarket.setStock("Mahindra", 4200.50);
        stockMarket.setStock("Redmi", 1850.75);


        stockMarket.deregisterObserver(webUser);

        System.out.println("\nWeb User Unsubscribed\n");

        stockMarket.setStock("Tata", 2950.00);
    }
}