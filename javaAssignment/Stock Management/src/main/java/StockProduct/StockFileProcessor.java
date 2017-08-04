package StockProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Thiru on 28/7/2017.
 */

@Component


public class StockFileProcessor
{
    @Autowired
     DataBaseManager databaseManager;
    @Autowired
    StockReader stockReader;



    public void process() throws ParseException
    {
    System.out.println("welcome");
   // stockReader.parseCSVFileToObject();

        List<StockQuote> list=stockReader.parseCSVFileToObject();
        for(int i=0;i<list.size();i++)
        {


            StockQuote s = list.get(i);


            databaseManager.createStoke(s);
        }
        List<StockQuote> stockQuotes = null;


        String fileName=list.get(0).getSymbol();



        stockQuotes=databaseManager.getStockQuotes(fileName);
        for(int x=9;x<stockQuotes.size();x++)
        {
            StockQuote stockQuote = stockQuotes.get(x);


                double sum = 0.0;
                for (int y = 1; y <= 10; y++)
                {

                    sum = sum + stockQuote.getAdjclose();
                }


                double avg = sum / 10;
                databaseManager.movStockQuote(fileName, stockQuote.getDate(), avg);



        }


    }

}
