package StockLedger;

public class StockPurchase {
    private String symbol;
    private double cost;

    public StockPurchase(String symbol, double cost) {
        this.symbol = symbol;
        this.cost = cost;
    }

    /**
     * Gets stock symbol of the share
     * @return four letter symbol of share
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Gets price of share
     * @return price of share
     */
    public double getCost() {
        return cost;
    }
}
