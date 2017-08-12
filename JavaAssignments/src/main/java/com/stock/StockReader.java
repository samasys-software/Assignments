package com.stock;

import com.stock.bussinessobjects.StockQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by SamayuSoftcorp on 28-07-2017.
 */
@Component// spring bean component

public class StockReader {

@Autowired
CSVReader csvReader;
   public final static String DATE_FORMAT = "yyyy-MM-dd";


  public List<StockQuote> parseCSVFileToObject() throws ParseException {
      List<StockQuote> stockQuotes = new LinkedList<StockQuote>();
      List<String[]> lists = csvReader.read();
      for (int i = 1; i < lists.size(); i++) {
          String[] line = lists.get(i);
          StockQuote stockQuote = new StockQuote();
          DateFormat df = new SimpleDateFormat(DATE_FORMAT);

          stockQuote.setDate(df.parse(line[0]));
          stockQuote.setClose(Double.parseDouble(line[1]));
          stockQuote.setStockSymbol(csvReader.getStockSymbol());

          stockQuotes.add(stockQuote);
          System.out.println(lists);
      }
      return stockQuotes;
  }
  public String getStockSymbol(){
     return csvReader.getStockSymbol();
  }

}
