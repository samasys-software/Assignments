package com.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.ParseException;
import java.util.List;


/**
 * Created by SamayuSoftcorp on 28-07-2017.
 */
@SpringBootApplication

public class Application implements CommandLineRunner {
    @Autowired

    StockFileProcessor processor ;

    public void run (String...strings) throws ParseException {

               processor.process();
            System.out.println("Welcome");

    }
    public static void main(String args[]){
        org.springframework.boot.SpringApplication.run(Application.class,args);
    }
}
