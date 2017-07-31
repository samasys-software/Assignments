package com.stock;

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

        Object[] args=new Object[]{stockQuote.getDate(),stockQuote.getFileName(),stockQuote.getClose()};
       // Object[] args=new Object[]{stockQuote.getDate(),stockQuote.getClose()};
        return template.update(DBSql.SAVE_STOCKQUOTES,args);
     }


}
