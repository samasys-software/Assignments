package StockManagement;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Component
public class StockCSVReader
{
    public String getStock()
    {
        return stock;
    }

    public void setStock(String stock)
    {
        this.stock = stock;
    }

    private String stock;

    public List<String[]> read()
    {
        String fileName = "d:/fgs/AAPL.csv";
        String line = "";
        String delimiter = ",";

        String getName = fileName.substring(7,11);

        setStock(getName);

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            List<String[]> lines = new LinkedList<String[]>();

            while ((line = br.readLine()) != null)
            {
                String[] names = line.split(delimiter);

                //System.out.println("out="+names[0]+","+names[1]+","+names[2]+","+names[3]+","+names[4]+","+names[5]+","+names[6]+"");

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