import java.util.ArrayList;

public class StockMarket implements Stock {
    private ArrayList<Observer> observers;
    private String stockName;
    private double stockPrice;
    
    public StockMarket() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(stockName, stockPrice);
        }
    }

    public void setStock(String stockName, double stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;

        System.out.println("\nStock Updated:");
        System.out.println("Name: " + stockName);
        System.out.println("Price: " + stockPrice);

        notifyObserver();
    }
}
