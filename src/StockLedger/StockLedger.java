package StockLedger;

import java.util.ArrayList;

public class StockLedger implements StockLedgerInterface {

    private ArrayList<LedgerEntry> stocks;

    public void buy(String stockSymbol, int sharesBought, double pricePerShare){
        if (contains(stockSymbol)){

        }
    }
    public double sell(String stockSymbol, int sharesSold, double pricePerShare){
        if (contains(stockSymbol)){}
    }
    public boolean contains(String stockSymbol){
        boolean hasSymbol = false;
        for(LedgerEntry entry : stocks){
            if(entry.getSymbol().equals(stockSymbol)){
                hasSymbol = true;
            }
        }
        return hasSymbol;
    }
    public LedgerEntry getEntry(String stockSymbol){

    }
    public void print(){

    }
}
