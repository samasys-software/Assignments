package StockManagement.dao;

import StockManagement.businessobjects.MovAverageStockQuote;
import StockManagement.businessobjects.StockQuote;
import StockManagement.businessobjects.StockSymbol;
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

    public List<StockSymbol> fetchStockSymbol()
    {
        return template.query(DBSQL.FETCH_STOCK_SYMBOL, (Object[]) null, new SymbolMapper());
    }

    public List<StockQuote> fetchStockQuotes(String stockSymbol)
    {
        Object [] args = new Object[] {stockSymbol};
        return template.query(DBSQL.FETCH_STOCK_QUOTES, args, new StockMapper());
    }

    public List<MovAverageStockQuote> fetchMovAverage(String stockSymbol)
    {
        Object [] args = new Object[] {stockSymbol};
        return template.query(DBSQL.FETCH_MOV_AVG, args, new MovAverageMapper());
    }
}