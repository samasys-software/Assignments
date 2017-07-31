package com.stock;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Date;

/**
 * Created by SamayuSoftcorp on 28-07-2017.
 */
@Component
public class StockQuote {



    private String fileName;
    private Date date;
    private double open;
    private double high;
    private double low;
    private double close;
    private double volume;
    private double adjclose;
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

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

}

