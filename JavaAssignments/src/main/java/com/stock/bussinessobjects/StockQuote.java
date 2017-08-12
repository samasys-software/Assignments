package com.stock.bussinessobjects;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Date;

/**
 * Created by SamayuSoftcorp on 28-07-2017.
 */
@Component
public class StockQuote {

    private String stockSymbol;
    private Date date;
    private double open;
    private double high;
    private double low;
    private double close;



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


}

