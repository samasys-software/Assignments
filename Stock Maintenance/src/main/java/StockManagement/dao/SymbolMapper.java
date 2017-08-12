package StockManagement.dao;

import StockManagement.businessobjects.StockSymbol;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SymbolMapper implements RowMapper<StockSymbol>
{

    @Override
    public StockSymbol mapRow(ResultSet resultSet, int i) throws SQLException
    {
        StockSymbol stockSymbol = new StockSymbol();

        stockSymbol.getQuoteId(resultSet.getLong("quoteId"));
        stockSymbol.setStock(resultSet.getString("stock"));

        return stockSymbol;
    }
}
