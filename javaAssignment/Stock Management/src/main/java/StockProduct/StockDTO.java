package StockProduct;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Thiru on 8/8/2017.
 */
public class StockDTO {

    private List<StockQuote> result;
    private List<MovStockQuote> movStockQuotes;





    public List<MovStockQuote> getMovStockQuotes() {
        return movStockQuotes;
    }

    public void setMovStockQuotes(List<MovStockQuote> movStockQuotes) {
        this.movStockQuotes = movStockQuotes;
    }

    public List<StockQuote> getResult() {
        return result;
    }

    public void setResult(List<StockQuote> result) {
        this.result = result;
    }
}