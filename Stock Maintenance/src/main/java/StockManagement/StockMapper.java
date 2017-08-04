package StockManagement;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StockMapper implements RowMapper<StockQuote>
{
    public StockQuote mapRow(ResultSet resultSet, int i) throws SQLException
    {
        StockQuote getStocksDetails = new StockQuote();

        getStocksDetails.setQuoteId(resultSet.getLong("quoteId"));
        getStocksDetails.setStock(resultSet.getString("stock"));
        getStocksDetails.setDate(resultSet.getDate("date"));
        getStocksDetails.setClose(resultSet.getDouble("price"));

        return getStocksDetails;
    }
}
