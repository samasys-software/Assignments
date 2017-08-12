package com.stock;
import com.stock.bussinessobjects.AverageStockQuote;
import com.stock.bussinessobjects.StockQuote;
import com.stock.bussinessobjects.StockSymbol;
import com.stock.dto.StockQuoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Named;

import javax.ws.rs.*;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.List;


/**
 * Created by SamayuSoftcorp on 08-08-2017.
 */
@RestController
@Named

public class StockQuoteRest {

 private final DatabaseManager databaseManager;


@Autowired
public StockQuoteRest(DatabaseManager manager) {
    databaseManager = manager;
}

    @GET
    @RequestMapping("getStockSymbols")
    @Produces(MediaType.APPLICATION_JSON)

    public StockQuoteDTO getStockSymbol() throws Exception {
        StockQuoteDTO dto = new StockQuoteDTO();
    try {

        List<StockSymbol> stockSymbol = databaseManager.fetchStockSymbol();
        dto.setStockSymbol(stockSymbol);
    }
    catch (Exception er){
        er.printStackTrace();
        dto.setError(true);
        dto.setErrorMessage(er.toString());

    }
           return dto;
        }


    @GET
    @RequestMapping("getStockQuotes")
    @Produces(MediaType.APPLICATION_JSON)
    public StockQuoteDTO getStockQuotes(@QueryParam("stockSymbol") String stockSymbol) throws Exception {

                StockQuoteDTO dto=new StockQuoteDTO();
                try {
                    List<StockQuote> stockQuotelist = databaseManager.fetchStockQuotesForTicker(stockSymbol);

                     dto.setResult(stockQuotelist);

                }
                catch (Exception e){
                    e.printStackTrace();
                    dto.setError(true);
                    dto.setErrorMessage(e.toString());
                }
                return dto;
       }

    @GET
    @RequestMapping("getAverageForStockSymbol")
    @Produces(MediaType.APPLICATION_JSON)
    public StockQuoteDTO getAverageForStockSymbol(@QueryParam("stockSymbol") String stockSymbol) throws Exception{

        StockQuoteDTO dto=new StockQuoteDTO();
        try {
            List<AverageStockQuote> average = databaseManager.fetchAverageForStockSymbol(stockSymbol);
            dto.setAverages(average);

        }
        catch (Exception e){
            e.printStackTrace();
            dto.setError(true);
            dto.setErrorMessage(e.toString());
        }
        return dto;
    }
}




