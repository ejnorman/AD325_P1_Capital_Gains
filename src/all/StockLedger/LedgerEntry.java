package StockLedger;

import Deque.LinkedDeque;

import java.util.Iterator;

public class LedgerEntry {
    private String symbol;
    private LinkedDeque<StockPurchase> purchases;

    public LedgerEntry(String symbol){
        purchases = new LinkedDeque<StockPurchase>();
        this.symbol = symbol;
    }

    /**
     * Gets stock symbol of ledger
     * @return four letter stock symbol
     */
    public String getSymbol(){
        return symbol;
    }

    /**
     * Adds a single StockPurchase object into ledger whenever a stock is bought
     * @param price price of stock
     */
    public void addPurchase(double price){
        StockPurchase stock = new StockPurchase(symbol, price);
        purchases.addToFront(stock);
    }

    /**
     * Removes StockPurchase object from the end of the ledger
     * @return price of the removed stock
     */
    public double sellPurchase(){
        StockPurchase stock = purchases.removeBack();
        return stock.getCost();
    }

    /**
     * Amount of each stock, according to price, in String form
     * @return String representation of ledger
     */
    //note: it is ordered like how they appear in the list, not first, second, etc. like in the example
    public String toString(){
        Iterator<StockPurchase> iterator = purchases.iterator();
        String ledgerShares = symbol + ":";
        double prevPrice = 0;
        int shareAmount = 0;
        while(iterator.hasNext()){
            StockPurchase stock = iterator.next();
            if(prevPrice == 0){ //if first value in list
                prevPrice = stock.getCost(); //set new previous value
            }
            //if there is a new share price, add amount of shares at prevPrice
            if(prevPrice != stock.getCost() && prevPrice != 0){
                ledgerShares += " " + prevPrice + " (" + shareAmount + " shares)";
                prevPrice = stock.getCost();
                shareAmount = 1;
            } else { //otherwise add to share amount
                shareAmount++;
            }
        }
        //add the last share price and the amount of it
        ledgerShares += " " + prevPrice + " (" + shareAmount + " shares)";
        return ledgerShares;
    }

}
