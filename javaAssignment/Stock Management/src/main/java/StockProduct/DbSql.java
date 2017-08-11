package StockProduct;

import org.springframework.stereotype.Component;

/**
 * Created by Thiru on 31/7/2017.
 */
@Component
public class DbSql
{
    public final static String CREATE_STOCK_QUOTE="insert into thiru_stock_quote(stock,date,price)values(?,?,?)";


    public final static String FETCH_STOCK_QUOTE="select * from thiru_stock_quote where stock=? order by date";


    public final static String MOVE_STOCK_QUOTE="insert into thiru_mov_average(stock,date,averagevalue)values(?,?,?)";

    public final static String FETCH_STOCK_SYMBOL="select distinct STOCK from thiru_stock_quote";

    public final static String FETCH_STOCK_QUOTES="select * from thiru_stock_quote where stock=?";

    public final static String FETCH_MOVE_AVERAGE="select averagevalue from thiru_mov_average where stock=?";


}
