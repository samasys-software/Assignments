package StockManagement.dto;

import StockManagement.businessobjects.StockQuote;

import java.util.List;

public class StockDTO
{
    public List<StockQuote> getResult()
    {
        return result;
    }

    public void setResult(List<StockQuote> result)
    {
        this.result = result;
    }

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

    private List<StockQuote> result;
    private Boolean error;
    private String errorMessage;
}