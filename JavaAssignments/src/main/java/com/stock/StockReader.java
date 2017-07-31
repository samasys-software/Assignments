package com.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by SamayuSoftcorp on 28-07-2017.
 */
@Component// spring bean component

public class StockReader {
    public final static String DATE_FORMAT = "YYYY-MM-dd";
@Autowired



    CSVReader csvReader;

  public List<StockQuote> parseCSVFileToObject() throws ParseException {
      List<StockQuote> stockQuotes = new LinkedList<StockQuote>();
      List<String[]> list = csvReader.read();
      for (int i = 1; i < list.size(); i++) {
          String[] line = list.get(i);
          StockQuote stockQuote = new StockQuote();
          DateFormat df = new SimpleDateFormat(DATE_FORMAT);

          stockQuote.setDate(df.parse(line[0]));

          stockQuote.setClose(Double.parseDouble(line[1]));

          stockQuotes.add(stockQuote);
          System.out.println(stockQuotes);
      }
      return stockQuotes;
  }


}
