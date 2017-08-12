package StockManagement.businessobjects;

public class StockSymbol
{
    public String getStock()
    {
        return stock;
    }

    public void setStock(String stock)
    {
        this.stock = stock;
    }

    public Long getQuoteId(long quoteId)
    {
        return this.quoteId;
    }

    public void setQuoteId(Long quoteId)
    {
        this.quoteId = quoteId;
    }

    private Long quoteId;
    private String stock;

}
