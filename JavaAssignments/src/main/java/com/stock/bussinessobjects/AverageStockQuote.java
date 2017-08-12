package com.stock.bussinessobjects;

import java.util.Date;

/**
 * Created by SamayuSoftcorp on 10-08-2017.
 */
public class AverageStockQuote {
    private Date date;
    private double averagevalue;
    private Long avgId;
    private String stockSymbol;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAveragevalue() {
        return averagevalue;
    }

    public void setAveragevalue(double averagevalue) {
        this.averagevalue = averagevalue;
    }




    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }




    public Long getAvgId() {
        return avgId;
    }

    public void setAvgId(Long avgId) {
        this.avgId = avgId;
    }



}
