package StockManagement.dao;

import StockManagement.businessobjects.MovAverageStockQuote;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovAverageMapper implements RowMapper<MovAverageStockQuote>
{

    public MovAverageStockQuote mapRow(ResultSet resultSet, int i) throws SQLException
    {
        MovAverageStockQuote getMovAverage = new MovAverageStockQuote();

        getMovAverage.getAvgId(resultSet.getLong("avg_id"));
        getMovAverage.setStock(resultSet.getString("stock"));
        getMovAverage.setDate(resultSet.getDate("date"));
        getMovAverage.setAverage(resultSet.getDouble("averagevalue"));

        return getMovAverage;
    }
}
