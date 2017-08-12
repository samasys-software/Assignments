package com.stock;

import com.stock.bussinessobjects.StockQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by SamayuSoftcorp on 28-07-2017.
 */
@Component
public class StockFileProcessor {
    @Autowired
    DatabaseManager databaseManager;
    @Autowired
    StockReader reader;
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public void process() throws ParseException {

        List<StockQuote> stockQuoteList = reader.parseCSVFileToObject();



        for (int i = 0; i < stockQuoteList.size(); i++) {
            StockQuote datas = stockQuoteList.get(i);
           databaseManager.saveStockQuotes(datas);
        }

       // String stockSymbol=stockQuoteList.get(0).getStockSymbol();
        String stockSymbol=reader.getStockSymbol();
        List<StockQuote> stockQuotes= databaseManager.fetchStockQuotes(stockSymbol);


       for(int i=9;i<stockQuotes.size();i++) {

           StockQuote result = stockQuotes.get(i);
         //  System.out.println(result.getDate()+" "+result.getClose());
           double sum=0.00;

           for(int j=1;j<=10;j++) {

               sum = sum + result.getClose();
           }
           double average=sum/10;
           databaseManager.saveAverageStockQuotes(average,result.getDate(),result.getStockSymbol());
                 }

    }


}


