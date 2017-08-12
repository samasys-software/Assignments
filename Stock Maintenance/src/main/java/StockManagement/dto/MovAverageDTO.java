package StockManagement.dto;

import StockManagement.businessobjects.MovAverageStockQuote;

import java.util.List;

public class MovAverageDTO
{
    public List<MovAverageStockQuote> getResult()
    {
        return result;
    }

    public void setResult(List<MovAverageStockQuote> result)
    {
        this.result = result;
    }

    private List<MovAverageStockQuote> result;
    private Boolean error;

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

    private String errorMessage;
}