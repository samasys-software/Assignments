package StockProduct;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by thiru on 28-07-2017.
 */
@Component
public class StockCSVReader {

    private String Symbol;
    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }



    public List<String[]> read()
    {
        String csvFile = "D:/fgs/APPL.csv";

        String fileName=csvFile.substring(7,11);
        setSymbol(fileName);
        String delimiter = ",";
        String line = "";


                try
                {
                    BufferedReader br = new BufferedReader(new FileReader(csvFile));
                    List<String[]> lines = new LinkedList<String[]>();


                    while ((line=br.readLine()) != null)
                    {
                        String[] names = line.split(delimiter);


                        lines.add(names);


                    }
                    return lines;
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                    return null;
                }
            }

}








