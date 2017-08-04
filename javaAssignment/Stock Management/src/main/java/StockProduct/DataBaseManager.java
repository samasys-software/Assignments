package StockProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Thiru on 31/7/2017.
 */

@Component
public class DataBaseManager {

    private final JdbcTemplate template;

    @Autowired
    public DataBaseManager(JdbcTemplate template) {
        this.template = template;
    }

    public int createStoke(StockQuote s) {
       // DateFormat df = new SimpleDateFormat(DATE_FORMAT);

        Object[] arg = new Object[]{s.getSymbol(),s.getDate(),s.getAdjclose()};
        return template.update(DbSql.CREATE_STOCK_QUOTE, arg);

    }
    public List<StockQuote> getStockQuotes(String fileName) {
        Object[] args=new Object[]{fileName};

        return template.query(DbSql.FETCH_STOCK_QUOTE, args, new StockFileMapper());


    }
    public int movStockQuote(String fileName,Date date,double avg)
    {
        Object[] arg = new Object[]{fileName,date,avg};
        return template.update(DbSql.MOVE_STOCK_QUOTE, arg);

    }

}