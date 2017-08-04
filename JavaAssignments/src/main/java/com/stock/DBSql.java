package com.stock;

import org.springframework.stereotype.Component;

/**
 * Created by SamayuSoftcorp on 28-07-2017.
 */
@Component
public class DBSql {

   public final static String SAVE_STOCKQUOTES="insert into ramya_stock_quotes(stock,date,price) values (?,?,?) ";
   public final static String FETCH_STOCKQUOTES="select * from ramya_stock_quotes  where stock=? order by date";
   public final static String SAVE_AVERAGE_STOCKQUOTES="insert into ramya_mov_average(stock,date,averagevalue ) values(?,?,?)";

}
