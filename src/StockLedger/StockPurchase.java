package StockLedger;

public class StockPurchase {
    private String symbol;
    private double cost;

    public StockPurchase(String symbol, double cost) {
        this.symbol = symbol;
        this.cost = cost;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getCost() {
        return cost;
    }
}
