package com.stock.dao;

import com.stock.bussinessobjects.AverageStockQuote;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SamayuSoftcorp on 10-08-2017.
 */
public class AverageStockQuoteMapper implements RowMapper<AverageStockQuote> {
    @Override
    public AverageStockQuote mapRow(ResultSet resultSet, int i) throws SQLException {
        AverageStockQuote averageStockQuote=new AverageStockQuote();
        averageStockQuote.setAvgId(resultSet.getLong("avg_id"));
        averageStockQuote.setStockSymbol(resultSet.getString("stock"));
        averageStockQuote.setDate(resultSet.getDate("date"));
        averageStockQuote.setAveragevalue(resultSet.getDouble("averagevalue"));
        return averageStockQuote;

    }
}
