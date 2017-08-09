package com.stock;


import com.stock.bussinessobjects.StockQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;


/**
 * Created by SamayuSoftcorp on 08-08-2017.
 */
@Component
public class StockQuoteRest {


 private final DatabaseManager databaseManager;


@Autowired
public StockQuoteRest(DatabaseManager manager) {
    databaseManager = manager;
}

    StockQuote stockQuote=new StockQuote();
    public StockQuoteDTO getStockSymbol() throws ParseException {
        StockQuoteDTO dto=new StockQuoteDTO();
     List stockSymbol=databaseManager.fetchStockSymbol();
     dto.setResult(stockSymbol);
     return dto;
    }
    public StockQuoteDTO getStockquotes(){

        StockQuoteDTO dto1=new StockQuoteDTO();

       // String stockSymbol=stockQuote.getStockSymbol();

        List stockQuotes=databaseManager.fetchStockQuotes(stockQuote.getStockSymbol());
        System.out.println(stockQuote.getStockSymbol());
        dto1.setResult(stockQuotes);
        return dto1;
    }
    public StockQuoteDTO getAverageForStockSymbol(){
        StockQuoteDTO dto2=new StockQuoteDTO();
        //String stockSymbol=dto2.getStockSymbol();
        List average=databaseManager.fetchAverageForStockSymbol(stockQuote.getStockSymbol());
        dto2.setResult(average);
        return dto2;
    }
}




