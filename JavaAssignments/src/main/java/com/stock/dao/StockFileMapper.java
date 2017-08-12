package com.stock.dao;

import com.stock.bussinessobjects.StockQuote;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SamayuSoftcorp on 02-08-2017.
 */
public class StockFileMapper implements RowMapper<StockQuote> {

    @Override
    public StockQuote mapRow(ResultSet rs, int i) throws SQLException {
        StockQuote stockQuote=new StockQuote();
        stockQuote.setQuoteId(rs.getLong("quoteId"));
        stockQuote.setStockSymbol(rs.getString("stock"));
        stockQuote.setDate(rs.getDate("date"));
        stockQuote.setClose(rs.getDouble("price"));
        return stockQuote;
    }


}
