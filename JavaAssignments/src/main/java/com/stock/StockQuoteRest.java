package com.stock;


import com.stock.bussinessobjects.StockQuote;
import com.stock.dto.StockQuoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.util.List;


/**
 * Created by SamayuSoftcorp on 08-08-2017.
 */

@Path("/stockquote/")
@Component
public class StockQuoteRest {



 private final DatabaseManager databaseManager;


@Autowired
public StockQuoteRest(DatabaseManager manager) {
    databaseManager = manager;
}

    @Path("getStockDetails")
    @Produces(MediaType.APPLICATION_JSON)

    public StockQuoteDTO getStockSymbol() throws ParseException {
          StockQuoteDTO dto=new StockQuoteDTO();
          String stockSymbol=databaseManager.fetchStockSymbol();
          System.out.println(stockSymbol);
          dto.setStockSymbol(stockSymbol);

          return dto;
    }
    public StockQuoteDTO getStockquotes() throws ParseException {

        StockQuoteDTO dto1=new StockQuoteDTO();

        StockQuote stockQuote=new StockQuote();
                String stocklist=databaseManager.fetchStockSymbol();
                List stockQuotelist=databaseManager.fetchStockQuotes(stocklist);
                System.out.println(stocklist);
                dto1.setResult(stockQuotelist);
                return dto1;
       }
    public StockQuoteDTO getAverageForStockSymbol(){

        StockQuoteDTO dto2=new StockQuoteDTO();
        String stocklist=databaseManager.fetchStockSymbol();
        System.out.println(stocklist);
        List average=databaseManager.fetchAverageForStockSymbol(stocklist);
        dto2.setAverages(average);
        return dto2;
    }
}




