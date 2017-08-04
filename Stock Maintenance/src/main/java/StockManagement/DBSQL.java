package StockManagement;

import org.springframework.stereotype.Component;

@Component
public class DBSQL
{
    public static final String CREATE_STOCK_SQL = "insert into girish_stock_quotes (stock,date,price) values(?,?,?)";

    public static final String FETCH_STOCK_DETAILS = "select * from girish_stock_quotes where stock=? order by date";

    public static final String INSERT_STOCK_AVG = "insert into girish_mov_average (stock,date,averagevalue) values(?,?,?)";
}