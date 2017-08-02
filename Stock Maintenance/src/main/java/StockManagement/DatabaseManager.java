package StockManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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
}