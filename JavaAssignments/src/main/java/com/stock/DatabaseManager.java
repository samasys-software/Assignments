package com.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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
     public List<StockQuote> fetchStockQuotes(String stockSymbol){
        Object[] args=new Object[]{stockSymbol};
        return template.query(DBSql.FETCH_STOCKQUOTES,args,new StockFileMapper());
     }
}
