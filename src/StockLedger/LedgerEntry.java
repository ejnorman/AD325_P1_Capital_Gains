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

    public String getSymbol(){
        return symbol;
    }

    public void addPurchases(int shares, double price){
        StockPurchase stock = new StockPurchase(symbol, price);
        for(int i = 0; i < shares; i++){
            purchases.addToFront(stock);
        }
    }

    public double sellPurchases(int shares){
        double sold = 0;
        for(int i = 0; i < shares; i++){
            StockPurchase stock = purchases.removeBack();
            sold += stock.getCost();
        }
        return sold;
    }

    public String toString(){
        Iterator<StockPurchase> iterator = purchases.iterator();
        String ledgerShares = symbol + ":";
        double prevPrice = 0;
        int shareAmount = 0;
        while(iterator.hasNext()){
            StockPurchase stock = iterator.next();
            if(prevPrice == 0){
                prevPrice = stock.getCost();
            }
            if(prevPrice != stock.getCost() && prevPrice != 0){
                ledgerShares += " " + prevPrice + " (" + shareAmount + " shares)";
                prevPrice = stock.getCost();
                shareAmount = 1;
            } else {
                shareAmount++;
            }
        }
        ledgerShares += " " + prevPrice + " (" + shareAmount + " shares)";
        return ledgerShares;
    }

}
