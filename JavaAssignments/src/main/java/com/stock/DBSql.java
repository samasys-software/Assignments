package com.stock;

import org.springframework.stereotype.Component;

/**
 * Created by SamayuSoftcorp on 28-07-2017.
 */
@Component
public class DBSql {
    public final static String SAVE_STOCKQUOTES="insert into ramya_stock_quotes(date,fileName,close) values (?,?,?)";
 // public final static String SAVE_STOCKQUOTES="insert into ramya_stock_quotes(date,close) values (?,?)";
}
