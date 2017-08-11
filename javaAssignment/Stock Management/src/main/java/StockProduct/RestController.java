package StockProduct;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;


import java.util.List;
import javax.inject.Named;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Thiru on 8/8/2017.
 */
@Component
@Named
@Path("/stock/")

public class RestController {
    DataBaseManager databaseManager;
    @Autowired


    public RestController(DataBaseManager manager)
    {
        databaseManager = manager;
    }
    @GET
    @Path("getSymbol")
    @Produces(MediaType.APPLICATION_JSON)
    public StockDTO getStockSymbol()
    {
        StockDTO dto = new StockDTO();

        try {
          List stocksymbol = databaseManager.getStockSymbol();
          dto.setResult(stocksymbol);
            }
      catch (Exception er)
      {
          er.printStackTrace();

      }

        return dto;
    }
    @GET
    @Path("getStockQuote")
    @Produces(MediaType.APPLICATION_JSON)
    public StockDTO getStockQuote(@QueryParam("stock")String stockSymbol)
    {

        StockDTO dto=new StockDTO();
        try {
            List stockquote = databaseManager.getStockQuote(stockSymbol);
            dto.setResult(stockquote);
        }
        catch (Exception er)
        {
            er.printStackTrace();
        }

        return dto;
    }
    @GET
    @Path("getAverage")
    @Produces(MediaType.APPLICATION_JSON)
    public StockDTO movAverage(@QueryParam("stock") String stockSymbol)

    {
       StockDTO dto=new StockDTO();
        try {
            List averagevalue=databaseManager.getMovAverage(stockSymbol);
            dto.setMovStockQuotes(averagevalue);
        }
        catch (Exception er)
        {
            er.printStackTrace();
        }
        return dto;

    }

}