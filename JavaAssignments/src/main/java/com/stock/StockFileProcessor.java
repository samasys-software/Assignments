package com.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        //  StockQuote stockQuote=StockQuote.getStockS(stockQuoteList)

        for (int i = 0; i < stockQuoteList.size(); i++) {
            StockQuote datas = stockQuoteList.get(i);
            System.out.println(datas);
            System.out.println(stockQuoteList.get(0).getDate());
            System.out.println(stockQuoteList.get(1).getDate());
            databaseManager.saveStockQuotes(datas);


        }

       String stockSymbol="AAPL";
      List result= databaseManager.fetchStockQuotes(stockSymbol);
      System.out.println(result);
        Date today=new Date();
        System.out.println(dateFormat.format(today));





    }
}


