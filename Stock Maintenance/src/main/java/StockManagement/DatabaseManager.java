package StockManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DatabaseManager
{
    private final JdbcTemplate template;

    @Autowired
    public DatabaseManager(JdbcTemplate template)
    {
        this.template = template;
    }

    public int insertStock(StockQuote stockLists)
    {
        Object[] args = new Object[] {stockLists.getStock(), stockLists.getDate(),stockLists.getClose()};
        return template.update(DBSQL.CREATE_STOCK_SQL, args);
    }

    public List<StockQuote> fetchStockDetails(String getSymbol)
    {
        Object[] args = new Object[] {getSymbol};
        return template.query(DBSQL.FETCH_STOCK_DETAILS, args, new StockMapper());
    }

    public int insertStockAvg(Double Average, String stock, Date date)
    {
        Object[] args = new Object[] {stock,date,Average};
        return template.update(DBSQL.INSERT_STOCK_AVG, args);
    }
}