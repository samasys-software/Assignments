package com.stock;

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
    private Date date;
    private double open;
    private double high;
    private double low;
    private double close;
    private double volume;
    private double adjclose;

    public Long getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(Long quoteId) {
        this.quoteId = quoteId;
    }

    private Long quoteId;


    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public  String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }


    public List<StockQuote> getResult() {
        return result;
    }

    public void setResult(List<StockQuote> result) {
        this.result = result;
    }

    private List<StockQuote> result;

}
