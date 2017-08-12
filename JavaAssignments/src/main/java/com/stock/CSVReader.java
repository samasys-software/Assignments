package com.stock;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by SamayuSoftcorp on 28-07-2017.
 */
@Component
public class CSVReader {

    public  String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    private  String stockSymbol;

  public   List<String[]> read(){

         String csvFile="d:/fgs/AAPL.csv";
         String filename=csvFile.substring(7,11);
         setStockSymbol(filename);
         String delimiter=",";
             String line="";
        try{

            BufferedReader br=new BufferedReader(new FileReader(csvFile));
            List<String[]> lines=new LinkedList<String[]>();

            while((line=br.readLine())!=null ){
                String[] names= line.split(delimiter);
                lines.add(names);
               // System.out.println("out="+names[0]+","+names[1]+","+names[2]+","+names[3]+","+names[4]+","+names[5]+","+names[6]+"");
                System.out.println(lines);

            }
            return lines;

        }  catch (IOException e) {
            e.printStackTrace();
          return null;
        }

       }


}
