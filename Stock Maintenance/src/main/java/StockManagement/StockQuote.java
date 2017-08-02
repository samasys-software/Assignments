package StockManagement;

import java.util.Date;

public class StockQuote
{

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public double getOpen()
    {
        return open;
    }

    public void setOpen(double open)
    {
        this.open = open;
    }

    public double getLow()
    {
        return low;
    }

    public void setLow(double low)
    {
        this.low = low;
    }

    public double getClose()
    {
        return close;
    }

    public void setClose(double close)
    {
        this.close = close;
    }

    public double getAdjclose()
    {
        return adjclose;
    }

    public void setAdjclose(double adjclose)
    {
        this.adjclose = adjclose;
    }

    public double getVolume()
    {
        return volume;
    }

    public void setVolume(double volume)
    {
        this.volume = volume;
    }

    public double getHigh()
    {
        return high;
    }

    public void setHigh(double high)
    {
        this.high = high;
    }

    public String getStock()
    {
        return stock;
    }

    public void setStock(String stock)
    {
        this.stock = stock;
    }

    private Date date;
    private double open;
    private double high;
    private double low;
    private double close;
    private double adjclose;
    private double volume;
    private String stock;

}