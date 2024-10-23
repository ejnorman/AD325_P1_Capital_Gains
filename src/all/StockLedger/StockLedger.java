package StockLedger;

import java.util.ArrayList;

public class StockLedger implements StockLedgerInterface {

    private ArrayList<LedgerEntry> stocks;

    public StockLedger() {
        stocks = new ArrayList<LedgerEntry>();
    }

    /** Records a stock purchase in this ledger.
     @param stockSymbol    The stock's symbol.
     @param sharesBought   The number of shares purchased.
     @param pricePerShare  The price per share. */
    public void buy(String stockSymbol, int sharesBought, double pricePerShare) {
        //if the ledger does not exist create a new one
        if (!contains(stockSymbol)) {
            stocks.add(new LedgerEntry(stockSymbol));
        }
        //entering each share into the ledger
        for (int i = 0; i < sharesBought; i++) {
            getEntry(stockSymbol).addPurchase(pricePerShare);
        }
    }

    /** Removes from this ledger any shares of a particular stock
     that were sold and computes the capital gain or loss.
     @param stockSymbol    The stock's symbol.
     @param sharesSold     The number of shares sold.
     @param pricePerShare  The price per share.
     @return  The capital gain (loss). */
    public double sell(String stockSymbol, int sharesSold, double pricePerShare){
        //if the stock is not in the portfolio throw exception
        if (!contains(stockSymbol)){
            throw new IllegalArgumentException("Stock symbol does not exist");
        }
        //remove sharesSold amount of shares from back of ledger
        for (int i = 0; i < sharesSold; i++) {
            getEntry(stockSymbol).sellPurchase();
        }
        //money made equals shares sold times it's sell price, not bought price
        return sharesSold * pricePerShare;
    }

    /** Returns a boolean on whether the passed in stock symbol is contained in the ledger.
     @param stockSymbol    The stock's symbol.
     @return  Boolean of if the stock exists in the ledger. */
    public boolean contains(String stockSymbol){
        return getEntry(stockSymbol) != null;
    }

    /** Returns a LedgerEntry object based on stock symbol.
     @param stockSymbol    The stock's symbol.
     @return  LedgerEntry object of stock symbol. */
    public LedgerEntry getEntry(String stockSymbol){
        if (stocks.isEmpty()) return null;
        //go through each ledger until one has the stock symbol
        for(LedgerEntry entry : stocks){
            if (entry.getSymbol().equals(stockSymbol)) {
                return entry;
            }
        }
        return null;
    }

    /**
     * Prints the entire stock portfolio
     */
    public void print(){
        System.out.println("\n----Stock Ledger----");
        //for every ledger print it's string format
        for(LedgerEntry entry : stocks){
            System.out.println(entry.toString());
        }
    }
}
