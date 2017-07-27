package com.stock.fgs;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by SamayuSoftcorp on 27-07-2017.
 */
public class CSVReader{
    public static List<String[]> read() {
        String csvFile = "D:/FGS/stock.csv";
        String line = "";
        String delimiter = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader(csvFile));
            List<String[]> lines = new LinkedList<String[]>();
            while ((line = br.readLine()) != null) {
                String[] name = line.split(delimiter);
                lines.add(name);
            }
            return lines;

            // System.out.println(lines.get(0) + "\t" + lines.get(1) + "\t" + lines.get(2));

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
    }



