package StockLedger;

import java.util.ArrayList;

public class StockLedger implements StockLedgerInterface {

    private ArrayList<LedgerEntry> stocks;
    private double profit;

    public StockLedger() {
        stocks = new ArrayList<LedgerEntry>();
    }

    public void buy(String stockSymbol, int sharesBought, double pricePerShare) {
        if (!contains(stockSymbol)) {
            stocks.add(new LedgerEntry(stockSymbol));
        }
        getEntry(stockSymbol).addPurchases(sharesBought, pricePerShare);
    }

    public double sell(String stockSymbol, int sharesSold, double pricePerShare){
        if (!contains(stockSymbol)){
            throw new IllegalArgumentException("Stock symbol does not exist");
        }
        double purchasePrice = getEntry(stockSymbol).sellPurchases(sharesSold);
        double sellPrice = pricePerShare * sharesSold;
        calcProfit(purchasePrice, sellPrice);
        return sellPrice - purchasePrice;
    }

    public boolean contains(String stockSymbol){
        return getEntry(stockSymbol) != null;
    }

    public LedgerEntry getEntry(String stockSymbol){
        if (stocks.isEmpty()) return null;
        for(LedgerEntry entry : stocks){
            if (entry.getSymbol().equals(stockSymbol)) {
                return entry;
            }
        }
        return null;
    }

    public void print(){
        System.out.println("\n----Stock Ledger----");
        for(LedgerEntry entry : stocks){
            System.out.println(entry.toString());
        }
    }

    public double getProfit() {
        return profit;
    }

    public void calcProfit(double soldStock, double purchasedStock) {
        profit += soldStock - purchasedStock;
    }
}
