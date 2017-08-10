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
public class StockQuoteDTO {

    private String stockSymbol;
    private List<StockQuote> result;
    private List<AverageStockQuote> averages;

    public void setAverages(List<AverageStockQuote> averages) {
        this.averages = averages;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public void setResult(List<StockQuote> result) {
        this.result = result;
    }

}
