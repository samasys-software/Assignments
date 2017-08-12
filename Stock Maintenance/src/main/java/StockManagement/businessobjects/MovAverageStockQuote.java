package StockManagement.businessobjects;

import java.util.Date;

public class MovAverageStockQuote
{
    private long avgId;
    private String stock;
    private Date date;
    private double average;

    public long getAvgId(long avg_id)
    {
        return avgId;
    }

    public void setAvgId(long avgId)
    {
        this.avgId = avgId;
    }

    public String getStock()
    {
        return stock;
    }

    public void setStock(String stock)
    {
        this.stock = stock;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public double getAverage()
    {
        return average;
    }

    public void setAverage(double average)
    {
        this.average = average;
    }
}
