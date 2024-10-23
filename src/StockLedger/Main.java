package StockLedger;

public class Main {
    public static void main(String[] args) {
        StockLedger stocks = new StockLedger();
        stocks.buy("AAPL", 20, 45.0);
        stocks.buy("AAPL", 20, 75.0);
        stocks.buy("MSFT", 20, 95.0);
        stocks.print();
        stocks.sell("AAPL", 30, 65.0);
        stocks.print();
        stocks.sell("AAPL", 10, 65.0);
        stocks.print();
        stocks.buy("AAPL", 100, 20.0);
        stocks.buy("AAPL", 20, 24.0);
        stocks.buy("TSLA", 200, 36.0);
        stocks.print();
        stocks.sell("AAPL", 10, 65.0);
        stocks.print();
        stocks.sell("TSLA", 150, 30.0);
        stocks.print();
        stocks.buy("MSFT", 5, 60.0);
        stocks.buy("MSFT", 5, 70.0);
        stocks.print();
        stocks.sell("MSFT", 4, 30.0);
        stocks.print();
        stocks.sell("MSFT", 2, 30.0);
        stocks.print();
    }
}
