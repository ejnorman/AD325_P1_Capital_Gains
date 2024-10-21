package StockLedger;

import Deque.LinkedDeque;

public class LedgerEntry{
    private String symbol;
    private LinkedDeque<Integer> purchases;

    public LedgerEntry(String symbol, LinkedDeque<Integer> purchases){
        this.symbol = symbol;
        this.purchases = purchases;
    }

    public String getSymbol(){
        return symbol;
    }

    public LinkedDeque<Integer> getPurchases(){
        return purchases;
    }


}
