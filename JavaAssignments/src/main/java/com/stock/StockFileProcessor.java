package com.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Created by SamayuSoftcorp on 28-07-2017.
 */
@Component
public class StockFileProcessor {
@Autowired
DatabaseManager databaseManager;

   StockReader reader;


    public void process() throws ParseException {

       List<StockQuote> stockQuoteList= reader.parseCSVFileToObject();



        for(int i=0;i<stockQuoteList.size();i++) {
          StockQuote datas= stockQuoteList.get(i);
          System.out.println(datas);
            databaseManager.saveStockQuotes(datas);

        }


    }

}


