package com.stock.fgs;

/**
 * Created by SamayuSoftcorp on 27-07-2017.
 */
public class StockReader {
    public static void main(String args[]) {
        StockQuote ar = (StockQuote) CSVReader.read();
        System.out.println(ar);
    }

}
