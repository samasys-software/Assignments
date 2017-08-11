package com.stock.dto;

import com.stock.bussinessobjects.AverageStockQuote;
import com.stock.bussinessobjects.StockQuote;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by SamayuSoftcorp on 08-08-2017.
 */
@Component
public class StockQuoteDTO extends StockErrorDTO{

    public List getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(List stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    private List stockSymbol;
    private List<StockQuote> result;
    private List<AverageStockQuote> averages;

    public void setAverages(List<AverageStockQuote> averages) {
        this.averages = averages;
    }



    public void setResult(List<StockQuote> result) {
        this.result = result;
    }

}
