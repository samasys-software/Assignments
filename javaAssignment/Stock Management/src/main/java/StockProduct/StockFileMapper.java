package StockProduct;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Thiru on 2/8/2017.
 */
@Component
public class StockFileMapper implements RowMapper<StockQuote>
{
public StockFileMapper()
{

}
    public StockQuote mapRow(ResultSet rs, int rowNum) throws SQLException {
        StockQuote stockQuote = new StockQuote();

        stockQuote.setQuoteId(rs.getLong("quoteId"));
        stockQuote.setDate(rs.getDate("date"));
        stockQuote.setSymbol(rs.getString("stock"));
        stockQuote.setAdjclose(rs.getDouble("price"));



        return stockQuote;
    }

}
