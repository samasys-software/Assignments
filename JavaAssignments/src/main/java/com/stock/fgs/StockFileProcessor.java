package com.stock.fgs;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by SamayuSoftcorp on 27-07-2017.
 */
public class StockFileProcessor {
    private final DatabaseManager databaseManager;
    @Autowired
    private StockQuote stockQuote;
    public StockFileProcessor(DatabaseManager databaseManager) {
        this.databaseManager = databaseManager;
    }
   /* public StockQuote getStockQuote() {
        return stockQuote;
    }

    public void setStockQuote(StockQuote stockQuote) {
        this.stockQuote = stockQuote;
    }*/

    // private StockQuote stockQuote;
    public static void main(String args[]){
        String date=StockQuote.getDate();
        Double volume=StockQuote.getVolumn();
        int indexOfDot=StockQuote.getCsvFile().lastIndexOf(".");
        String extension=StockQuote.getCsvFile().substring(indexOfDot);
        //  FileInputStream inputStream = new FileInputStream(new File(getCsvFile()));
        // int indexOfDot = getCsvFile().lastIndexOf(".");
        //  String extension = getCsvFile().substring(indexOfDot );

        try {

            String Datas = DatabaseManager.saveStockQuotes(extension,date,Double.parseDouble(volume) );
            System.out.println(Datas);
        }
        catch(Exception er){
            er.printStackTrace();





        }



    }




}
