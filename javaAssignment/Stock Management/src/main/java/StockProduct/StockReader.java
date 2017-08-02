package StockProduct;

/**
 * Created by Thiru on 28/7/2017.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author Thiru
 *
 */
@Component
public class StockReader

{
    @Autowired
    StockCSVReader csvReader;

    public final static String DATE_FORMAT = "dd/MM/yyyy";

    public List<StockQuote> parseCSVFileToObject() throws ParseException {


            List<String[]> list = csvReader.read();


        List<StockQuote> stock=new LinkedList<StockQuote>();


            for (int i = 0; i < list.size(); i++) {

                String[] arr = list.get(i);

                StockQuote stockQuote = new StockQuote();
                DateFormat df = new SimpleDateFormat(DATE_FORMAT);
                stockQuote.setDate(df.parse(arr[0]));
                stockQuote.setHigh(Double.parseDouble(arr[1]));
                stockQuote.setLow(Double.parseDouble(arr[2]));
                stockQuote.setOpen(Double.parseDouble(arr[3]));
                stockQuote.setClose(Double.parseDouble(arr[4]));
                stockQuote.setAdjclose(Double.parseDouble(arr[5]));
                stockQuote.setVolume((Double.parseDouble(arr[6])));
                stockQuote.setSymbol(csvReader.getSymbol());
                stock.add(stockQuote);
                System.out.println(stock);
            }
            return stock;
        }

}