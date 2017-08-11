package com.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.ParseException;



/**
 * Created by SamayuSoftcorp on 28-07-2017.
 */
@SpringBootApplication

public class Application implements CommandLineRunner {
    @Autowired

    StockFileProcessor processor ;
    @Autowired
    StockQuoteRest rest;

    public void run (String...strings) throws Exception {

               processor.process();
            System.out.println("Welcome");
            rest.getStockSymbol();
            rest.getStockQuotes("AAPL");
            rest.getAverageForStockSymbol("AAPL");

    }
    public static void main(String args[]){
        org.springframework.boot.SpringApplication.run(Application.class,args);
    }
}
