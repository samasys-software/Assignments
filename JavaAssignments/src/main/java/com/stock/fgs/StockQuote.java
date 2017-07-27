package com.stock.fgs;

/**
 * Created by SamayuSoftcorp on 27-07-2017.
 */



    public class StockQuote {


        private double open;
        private double high;
        private double low;
        private double close;
        private double adjclose;
        private double volumn;
        private  String date;

        public  String getCsvFile() {
            return csvFile;
        }

        public void setCsvFile(String csvFile) {
            this.csvFile = csvFile;
        }

        private String csvFile;
        public double getOpen() {
            return open;
        }

        public void setOpen(double open) {
            this.open = open;
        }

        public double getHigh() {
            return high;
        }

        public void setHigh(double high) {
            this.high = high;
        }

        public double getLow() {
            return low;
        }

        public void setLow(double low) {
            this.low = low;
        }

        public double getClose() {
            return close;
        }

        public void setClose(double close) {
            this.close = close;
        }

        public double getAdjclose() {
            return adjclose;
        }

        public void setAdjclose(double adjclose) {
            this.adjclose = adjclose;
        }

        public  double getVolumn() {
            return volumn;
        }

        public void setVolumn(double volumn) {
            this.volumn = volumn;
        }

        public  String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

    }


