package com.stock;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SamayuSoftcorp on 02-08-2017.
 */
public class StockFileMapper implements RowMapper<StockQuote> {

    @Override
    public StockQuote mapRow(ResultSet resultSet, int i) throws SQLException {
        StockQuote stockQuote=new StockQuote();
        stockQuote.setQuoteId(resultSet.getLong("quoteId"));
        stockQuote.setStockSymbol(resultSet.getString("stock"));
        stockQuote.setDate(resultSet.getDate("date"));
        stockQuote.setClose(resultSet.getDouble("price"));
        return stockQuote;
    }

}
