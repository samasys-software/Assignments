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


        for (int i = 0; i < stockQuoteList.size(); i++) {
            StockQuote datas = stockQuoteList.get(i);
            databaseManager.saveStockQuotes(datas);
        }

        String stockSymbol="AAPL";
        List<StockQuote> stockQuotes= databaseManager.fetchStockQuotes(stockSymbol);


       for(int i=0;i<stockQuotes.size();i++) {

           StockQuote result = stockQuotes.get(i);
           System.out.println(result.getDate()+" "+result.getClose()) ;
                       if(i<=9 ){
                           continue;
                       }
                      else{
                           double sum=0.00;

                           for(int j=1;j<=10;j++) {

                               sum = sum + stockQuotes.get(i-j).getClose();
                              }
                        double average=sum/10;
                        databaseManager.saveAverageStockQuotes(average,result.getDate(),result.getStockSymbol());

                       }

                 }

    }


}


//  System.out.println("out="+ stockQuotes.get(0).getDate() +","+ stockQuotes.get(1).getDate() +","+ stockQuotes.get(2).getDate() +","+ stockQuotes.get(3).getDate() +","+ stockQuotes.get(4).getDate() +","+ stockQuotes.get(5).getDate() +","+ stockQuotes.get(6).getDate() +","+ stockQuotes.get(7).getDate() +","+ stockQuotes.get(8).getDate()+"");

//   System.out.println("out="+ stockQuotes.get(0).getClose() +","+ stockQuotes.get(1).getClose() +","+ stockQuotes.get(2).getClose() +","+ stockQuotes.get(3).getClose() +","+ stockQuotes.get(4).getClose() +","+ stockQuotes.get(5).getClose() +","+ stockQuotes.get(6).getClose() +","+ stockQuotes.get(7).getClose() +"");
 /*for(int i=0;i<stockQuotes.size();i++) {

        StockQuote result = stockQuotes.get(i);
        System.out.println(result.getDate()+" "+result.getClose()) ;
        if(i==0|| i==1 || i==2 ||i==3||i==4||i==5||i==6||i==7||i==8||i==9 ){
        continue;

        }
        else{


        double sum=(stockQuotes.get(i-1).getClose()+stockQuotes.get(i-2).getClose()+stockQuotes.get(i-3).getClose()+stockQuotes.get(i-4).getClose()+stockQuotes.get(i-5).getClose()
        +stockQuotes.get(i-6).getClose()+ stockQuotes.get(i-7).getClose()+stockQuotes.get(i-8).getClose()+stockQuotes.get(i-9).getClose()+stockQuotes.get(i-10).getClose());
        System.out.println(sum);
        double average=sum/10;*/