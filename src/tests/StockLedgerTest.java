import StockLedger.StockLedger;
import StockLedger.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StockLedgerTest {

    @Test
    void buy() {
        StockLedger s = new StockLedger();
        s.buy("AAPL", 20, 65.0);
        LedgerEntry l1 = s.getEntry("AAPL");
        LedgerEntry l2 = new LedgerEntry("AAPL");
        for(int i = 0; i < 20; i++){
            l2.addPurchase(65.0);
        }
        Assertions.assertEquals(l1.toString(), l2.toString());
    }

    @Test
    void sell() {
        StockLedger s = new StockLedger();
        s.buy("AAPL", 20, 65.0);
        double sold = s.sell("AAPL", 10, 50.0);
        assertEquals(500, sold);
        LedgerEntry l1 = s.getEntry("AAPL");
        LedgerEntry l2 = new LedgerEntry("AAPL");
        for(int i = 0; i < 10; i++){
            l2.addPurchase(65.0);
        }
    }

    @Test
    void contains() {
        StockLedger s = new StockLedger();
        s.buy("AAPL", 20, 65.0);
        assertTrue(s.contains("AAPL"));
    }

    @Test
    void getEntry() {
        StockLedger s = new StockLedger();
        s.buy("AAPL", 20, 65.0);
        LedgerEntry l = new LedgerEntry("AAPL");
        for(int i = 0; i < 20; i++){
            l.addPurchase(65.0);
        }
        Assertions.assertEquals(l.toString(), s.getEntry("AAPL").toString());
    }
}
