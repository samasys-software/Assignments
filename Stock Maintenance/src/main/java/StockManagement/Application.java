package StockManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;

@SpringBootApplication

public class Application implements CommandLineRunner
{
    @Autowired
    StockFileProcessor processor;

    @Autowired
    StockManagementRest stockManagementRest;

    public void run(String...Strings) throws ParseException
    {
        processor.process();

        stockManagementRest.stockSymbol();
        stockManagementRest.stockQuotes("AAPL");
        stockManagementRest.movAverage("AAPL");

        System.out.println("Welcome To SpringBootApplications");
    }
    public static void main(String[] args)
    {
        org.springframework.boot.SpringApplication.run(Application.class,args) ;
    }
}