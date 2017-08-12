package com.stock;

import com.stock.bussinessobjects.AverageStockQuote;
import com.stock.bussinessobjects.StockQuote;
import com.stock.bussinessobjects.StockSymbol;
import com.stock.dao.AverageStockQuoteMapper;
import com.stock.dao.StockFileMapper;
import com.stock.dao.StockSymbolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by SamayuSoftcorp on 28-07-2017.
 */
@Component
public class DatabaseManager {
    private  final JdbcTemplate template;


    @Autowired
    public DatabaseManager(JdbcTemplate template) {
        this.template = template;
    }


    public  int  saveStockQuotes(StockQuote stockQuote){
       Object[] args=new Object[]{stockQuote.getStockSymbol(),stockQuote.getDate(),stockQuote.getClose()};
        return template.update(DBSql.SAVE_STOCKQUOTES,args);
     }
     public List<StockSymbol> fetchStockSymbol(){
        try {
            return template.query(DBSql.FETCH_STOCKSYMBOL, (Object[]) null, new StockSymbolMapper());
        }catch(Exception e)
        {
            System.out.println(e.toString());
            return null;
        }
     }
     public List<StockQuote> fetchStockQuotes(String stockSymbol){
        Object[] args=new Object[]{stockSymbol};
        return template.query(DBSql.FETCH_STOCKQUOTES,args,new StockFileMapper());
     }
    public List<StockQuote> fetchStockQuotesForTicker(String stockSymbol){
         try {
             Object[] args = new Object[]{stockSymbol};
             return template.query(DBSql.FETCH_STOCKQUOTES, args, new StockFileMapper());
         }
         catch(Exception e){
             return null;
         }
    }
    public int saveAverageStockQuotes(double average, Date date, String stockSymbol) {
         Object[] args=new Object[]{stockSymbol,date,average};
         return template.update(DBSql.SAVE_AVERAGE_STOCKQUOTES,args);
    }



    public List<AverageStockQuote> fetchAverageForStockSymbol(String stockSymbol) {
        try {
            Object[] args = new Object[]{stockSymbol};
            return template.query(DBSql.FETCH_AVERAGEFORSTOCKSYMBOL, args, new AverageStockQuoteMapper());
        }
        catch(Exception e){
            return null;
        }
    }


}
