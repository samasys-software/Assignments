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

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    private String fileName;

  public  List<String[]> read(){


        String csvFile="d:/fgs/stock.csv";
        setFileName("stock");
        String delimiter=",";
        String line="";

        try{

            BufferedReader br=new BufferedReader(new FileReader(csvFile));
            List<String[]> lines=new LinkedList<String[]>();

            while((line=br.readLine())!=null ){
                String[] names= line.split(delimiter);
                lines.add(names);
                System.out.println(lines);

            }
            return lines;

        }  catch (IOException e) {
            e.printStackTrace();
          return null;
        }

       }


}
