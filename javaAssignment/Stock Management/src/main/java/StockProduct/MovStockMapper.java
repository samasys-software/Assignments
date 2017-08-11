package StockProduct;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Thiru on 10/8/2017.
 */
@Component
public class MovStockMapper implements RowMapper<MovStockQuote>
{

    public MovStockMapper()
    {

    }
    public MovStockQuote mapRow(ResultSet rs, int rowNum) throws SQLException {
        MovStockQuote movStockQuote = new MovStockQuote();

        movStockQuote.setAvgId(rs.getLong("avg_id"));
        movStockQuote.setDate(rs.getDate("date"));
        movStockQuote.setStock(rs.getString("stock"));
        movStockQuote.setAveragevalue(rs.getDouble("averagevalue"));



        return movStockQuote;
    }
}
