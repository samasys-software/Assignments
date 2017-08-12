package StockManagement;

import StockManagement.dao.DatabaseManager;
import StockManagement.dto.MovAverageDTO;
import StockManagement.dto.StockDTO;
import StockManagement.dto.SymbolDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@Named
@Path("/stockManagement/")
public class StockManagementRest
{
    private final DatabaseManager databaseManager;

    @Autowired
    public StockManagementRest(DatabaseManager manager)
    {
        databaseManager = manager;
    }

    @GET
    @Path("stockSymbol")
    @Produces(MediaType.APPLICATION_JSON)
    public SymbolDTO stockSymbol()
    {
        SymbolDTO dto1 = new SymbolDTO();

        try
        {
            List stockSymbol = databaseManager.fetchStockSymbol();
            //dto1.setResult(stockSymbol);
            dto1.setStockSymbol(stockSymbol);
            System.out.println(stockSymbol);
        }
        catch(Exception er)
        {
            er.printStackTrace();
            dto1.setError( true );
            dto1.setErrorMessage( er.toString() );
        }

        return dto1;
    }

    @GET
    @Path("stockQuote")
    @Produces(MediaType.APPLICATION_JSON)
    public StockDTO stockQuotes(@QueryParam("stock") String stockSymbol)
    {
        StockDTO dto2 = new StockDTO();

        try
        {
            List stockQuoteList = databaseManager.fetchStockQuotes(stockSymbol);
            dto2.setResult(stockQuoteList);
        }
        catch(Exception er)
        {
            er.printStackTrace();
            dto2.setError( true );
            dto2.setErrorMessage( er.toString() );
        }

        return dto2;
    }

    @GET
    @Path("movAverage")
    @Produces(MediaType.APPLICATION_JSON)
    public MovAverageDTO movAverage(@QueryParam("stock") String stockSymbol)
    {
        MovAverageDTO dto3 = new MovAverageDTO();

        try
        {
            List movAvg = databaseManager.fetchMovAverage(stockSymbol);
            dto3.setResult(movAvg);
        }
        catch(Exception er)
        {
            er.printStackTrace();
            dto3.setError( true );
            dto3.setErrorMessage( er.toString() );
        }

        return dto3;
    }
}