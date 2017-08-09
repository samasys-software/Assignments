package com.stock;


import com.stock.bussinessobjects.StockQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
    @Produces(MediaType.APPLICATION_JSON)

    public StockQuoteDTO getStockSymbol() throws ParseException {
        StockQuoteDTO dto=new StockQuoteDTO();
     String stockSymbol=databaseManager.fetchStockSymbol();
     System.out.println(stockSymbol);
     dto.setStockSymbol(stockSymbol);

     return dto;
    }
    public StockQuoteDTO getStockquotes(){

        StockQuoteDTO dto1=new StockQuoteDTO();
        StockQuote stockQuote=new StockQuote();
       // String stockSymbol=stockQuote.getStockSymbol();

        List stockQuotes=databaseManager.fetchStockQuotes(stockQuote.getStockSymbol());
        System.out.println(stockQuote.getStockSymbol());
        dto1.setResult(stockQuotes);
        return dto1;
    }
    public StockQuoteDTO getAverageForStockSymbol(){
        StockQuoteDTO dto2=new StockQuoteDTO();
        StockQuote stockQuote=new StockQuote();
        //String stockSymbol=dto2.getStockSymbol();
        List average=databaseManager.fetchAverageForStockSymbol(stockQuote.getStockSymbol());
        dto2.setResult(average);
        return dto2;
    }
}




