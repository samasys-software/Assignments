package StockProduct;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Thiru on 10/8/2017.
 */
@Component
public class MovStockQuote
{
    private Date date;
    private Long avgId;
    private String stock;
    private Double averagevalue;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }


    public Long getAvgId() {
        return avgId;
    }

    public void setAvgId(Long avgId) {
        this.avgId = avgId;
    }

    public Double getAveragevalue() {
        return averagevalue;
    }

    public void setAveragevalue(Double averagevalue) {
        this.averagevalue = averagevalue;
    }
}
