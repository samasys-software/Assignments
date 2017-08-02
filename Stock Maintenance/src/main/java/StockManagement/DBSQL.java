package StockManagement;

import org.springframework.stereotype.Component;

@Component
public class DBSQL
{
    public static final String CREATE_STOCK_SQL = "insert into girish_stock_quotes (stock,date,price) values(?,?,?)";
}