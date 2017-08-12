package StockManagement.dto;

import java.util.List;

public class SymbolDTO
{
    /*public List<StockSymbol> getStockSymbol()
    {
        return stockSymbol;
    }

    public void setStockSymbol(List<StockSymbol> stockSymbol)
    {
        this.stockSymbol = stockSymbol;
    }*/

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    //private List<StockSymbol> stockSymbol;

    public List getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(List stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    private List stockSymbol;
    private Boolean error;
    private String errorMessage;

}
