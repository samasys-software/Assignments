package StockManagement;

import StockManagement.businessobjects.StockQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Component
public class StockReader
{
    @Autowired
    StockCSVReader csvReader;

    public final static String DATE_FORMAT = "yyyy-MM-dd";

    public List<StockQuote> parseCSVFileToObject() throws NullPointerException, ParseException {
        List<String[]> list = csvReader.read();

        List<StockQuote> stocks = new LinkedList<StockQuote>();

        for (int i = 1; i < list.size(); i++)
        {
            String[] lists = list.get(i);

            StockQuote stockQuote = new StockQuote();

            DateFormat dy = new SimpleDateFormat(DATE_FORMAT);

            stockQuote.setDate(dy.parse(lists[0]));
            stockQuote.setOpen(Double.parseDouble(lists[1]));
            stockQuote.setHigh(Double.parseDouble(lists[2]));
            stockQuote.setLow(Double.parseDouble(lists[3]));
            stockQuote.setClose(Double.parseDouble(lists[4]));
            stockQuote.setAdjclose(Double.parseDouble(lists[5]));
            stockQuote.setVolume(Double.parseDouble(lists[6]));
            stockQuote.setStock(csvReader.getStock());

            stocks.add(stockQuote);

            System.out.println(stocks);
        }
        return stocks;
    }
}