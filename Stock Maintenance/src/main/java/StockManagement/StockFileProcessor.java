package StockManagement;

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

    public void process() throws NullPointerException, ParseException {

        List<StockQuote> stocks = stockReader.parseCSVFileToObject();

        for(int i=0; i< stocks.size(); i++)
        {
            StockQuote stockLists = stocks.get(i);

            //System.out.println(stockLists);

            databaseManager.insertStock(stockLists);
        }

        System.out.println("Run Stock File Processor");
    }
}