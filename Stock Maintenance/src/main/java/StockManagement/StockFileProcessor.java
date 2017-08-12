package StockManagement;

import StockManagement.businessobjects.StockQuote;
import StockManagement.dao.DatabaseManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;

@Component
public class StockFileProcessor
{
    @Autowired
    DatabaseManager databaseManager;

    @Autowired
    StockReader stockReader;

    public void process() throws NullPointerException, ParseException
    {

        List<StockQuote> stocks = stockReader.parseCSVFileToObject();

        for(int i=0; i< stocks.size(); i++)
        {
            StockQuote stockLists = stocks.get(i);

            //System.out.println(stockLists);

            databaseManager.insertStock(stockLists);
        }

        String getSymbol = stocks.get(0).getStock();

        List<StockQuote> getStockDetails = databaseManager.fetchStockDetails(getSymbol);

        for(int j=9; j<getStockDetails.size();j++)
        {
            StockQuote getDetails = getStockDetails.get(j);

            Double sum = 0.0;

            for (int k = 1; k <= 10; k++)
            {
                sum = sum + getDetails.getClose();
            }

            Double Average = sum /10;

            databaseManager.insertStockAvg(Average,getDetails.getStock(),getDetails.getDate());
        }

        //System.out.println(getStockDetails);

        System.out.println("Run Stock File Processor");
    }
}