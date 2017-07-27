package com.stock.fgs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by SamayuSoftcorp on 27-07-2017.
 */
public class DatabaseManager {

    private final JdbcTemplate template;


    @Autowired
    public DatabaseManager(JdbcTemplate template) {
        this.template = template;
    }

    public  int saveStockQuotes(String extension, String date, double volume) {
        Object[] args = {extension, date, volume};
        return template.update(DBSql.SAVE_STOCKQUOTES, args);
    }
}
