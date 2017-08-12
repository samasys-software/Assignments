package com.stock.dao;


import com.stock.bussinessobjects.StockSymbol;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by SamayuSoftcorp on 10-08-2017.
 */
public class StockSymbolMapper implements RowMapper<StockSymbol> {
    @Override
    public StockSymbol mapRow(ResultSet resultSet, int i) throws SQLException {
        StockSymbol ticker=new StockSymbol();

        ticker.setStockSymbol(resultSet.getString("stock"));

        return ticker;
    }


}
