package com.stock;


import com.stock.bussinessobjects.AverageStockQuote;
import com.stock.bussinessobjects.StockQuote;
import com.stock.bussinessobjects.StockSymbol;
import com.stock.dto.StockQuoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.inject.Named;

import javax.ws.rs.*;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.util.List;


/**
 * Created by SamayuSoftcorp on 08-08-2017.
 */
@Named
@Path("/stockquote/")
@Component
public class StockQuoteRest {



 private final DatabaseManager databaseManager;


@Autowired
public StockQuoteRest(DatabaseManager manager) {
    databaseManager = manager;
}

    @GET
    @Path("getStockSymbol")
    @Produces(MediaType.APPLICATION_JSON)

    public StockQuoteDTO getStockSymbol() throws Exception {
        StockQuoteDTO dto = new StockQuoteDTO();
    try {

        List<StockSymbol> stockSymbol = databaseManager.fetchStockSymbol();
        System.out.println(stockSymbol.get(0).getStockSymbol());
        System.out.println(stockSymbol.get(1).getStockSymbol());
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
    @Path("getStockQuotes")
    @Produces(MediaType.APPLICATION_JSON)
    public StockQuoteDTO getStockQuotes(@QueryParam("stockSymbol") String stockSymbol) throws Exception {

                StockQuoteDTO dto=new StockQuoteDTO();
                try {

                        List<StockQuote> stockQuotelist = databaseManager.fetchStockQuotesForTicker(stockSymbol);
                        System.out.println(stockSymbol);
                    System.out.println(stockQuotelist.get(0).getDate());
                    System.out.println(stockQuotelist.get(0).getQuoteId());
                    System.out.println(stockQuotelist.get(0).getStockSymbol());
                    System.out.println(stockQuotelist.get(0).getClose());
                    System.out.println(stockQuotelist.get(1).getQuoteId());

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
    @Path("getAverageForStockSymbol")
    @Produces(MediaType.APPLICATION_JSON)
    public StockQuoteDTO getAverageForStockSymbol(@QueryParam("stockSymbol") String stockSymbol) throws Exception{

        StockQuoteDTO dto=new StockQuoteDTO();
        try {
            List<AverageStockQuote> average = databaseManager.fetchAverageForStockSymbol(stockSymbol);
            System.out.println(average.get(0).getAveragevalue());
            System.out.println(average.get(0).getStockSymbol());
            System.out.println(average.get(0).getDate());
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




//  List<StockSymbol> stockSymbol = databaseManager.fetchStockSymbol();
//  for(int i=0;i<stockSymbol.size();i++) {
// StockQuote stockQuote=new StockQuote();
// List<StockSymbol> stockSymbol = databaseManager.fetchStockSymbol();
// StockSymbol  stock=stockSymbol.get(i);
//List stockSymbol = databaseManager.fetchStockSymbol();
//  System.out.println(stockSymbol);
//for(int i=0;i<stockSymbol.size();i++) {

// }