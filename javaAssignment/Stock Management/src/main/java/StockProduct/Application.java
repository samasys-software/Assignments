package StockProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.text.ParseException;

@SpringBootApplication

public class Application implements CommandLineRunner
{
    @Autowired
    StockFileProcessor processor;
    // StockCSVReader reader;
   //StockReader stockReader;

    public void run(String...strings) throws ParseException, FileNotFoundException//varible argument=array
    {
        processor.process();
      // reader.read();
       // stockReader.parseCSVFileToObject();
        System.out.println("welcome to SpringBoot");

}

    public static void main(String[] args)
    {

                org.springframework.boot.SpringApplication.run(Application.class,args);//instead of java class we can run as spring class


    }
}
