package com.example.fgs.stockmanagementtabactivity;


import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fgs.stockmanagementtabactivity.Model.AverageForStockQuotes;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by fgs on 8/25/2017.
 */

public class AverageStockQuotesFragment extends Fragment {
    ArrayList<AverageForStockQuotes> averageList=new ArrayList<>();
    ListView  averageStocks;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.averagestockquotes,container,false);
        String ticker="AAPL";
        averageStocks = rootView.findViewById(R.id.avergeStockQuotes);
        new AvgStockQuotes(ticker);
        return rootView;
    }
    public class AvgStockQuotes extends AsyncTask<Void, Void, JSONObject> {
        private final String stockSymbol;

        JSONObject jsonObject;

        AvgStockQuotes(String ticker) {
            stockSymbol = ticker;
        }


        protected JSONObject doInBackground(Void... params) {
            try {
                SyncHttpClient asyncHttpClient = new SyncHttpClient();
                RequestParams requestParams = new RequestParams();
                requestParams.put("stockSymbol", stockSymbol);

                String url = "http://192.168.1.9:8080/getAverageForStockSymbol";
                asyncHttpClient.post(url, requestParams, new JsonHttpResponseHandler() {

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        try {
                            System.out.println(response);
                            jsonObject = response;
                        } catch (Exception er) {
                            er.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable e) {
                        super.onFailure(statusCode, headers, responseString, e);
                        e.printStackTrace();
                    }

                });
            } catch (Exception e) {
                e.printStackTrace();

            }
            return jsonObject;
        }

        @Override
        protected void onPostExecute(JSONObject stocks) {

            System.out.println(stocks);

            try {

                JSONArray symbol=stocks.getJSONArray("averages");
                for(int i=0;i<symbol.length();i++){
                    AverageForStockQuotes avearge=new AverageForStockQuotes();
                    avearge.setAvgId(symbol.getJSONObject(i).getString("avgId"));
                    avearge.setAvgStockSymbol(symbol.getJSONObject(i).getString("stockSymbol"));
                    avearge.setAverageValues(symbol.getJSONObject(i).getString("averagevalue"));
                    avearge.setAvgdate(symbol.getJSONObject(i).getString("date"));
                    averageList.add(avearge);

                }

                AverageAdapter adapter=new AverageAdapter(getActivity(),R.layout.average_stocksquotes_ticker,averageList);
                averageStocks.setAdapter(adapter);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public class AverageAdapter extends ArrayAdapter {
        private List<AverageForStockQuotes> AvgStockQuotes;
        private int resource;
        private LayoutInflater inflator;
        public AverageAdapter(Context context, int resource, List<AverageForStockQuotes> objects) {
            super(context, resource, objects);
            AvgStockQuotes=objects;
            this.resource=resource;
            inflator= (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);

        }

        @NonNull
        @Override
        public View getView(int position,  View convertView, ViewGroup parent) {
            if(convertView==null){
                convertView=inflator.inflate(R.layout.average_stocksquotes_ticker,null);

            }
            TextView avgId;
            TextView ticker;
            TextView date;
            TextView avgValues;
            avgId=(TextView)convertView.findViewById(R.id.avgId);
            ticker=(TextView)convertView.findViewById(R.id.ticker);
            date=(TextView)convertView.findViewById(R.id.date);
            avgValues=(TextView)convertView.findViewById(R.id.avgValues);
            avgId.setText(AvgStockQuotes.get(position).getAvgId());
            ticker.setText(AvgStockQuotes.get(position).getAvgStockSymbol());
            date.setText(AvgStockQuotes.get(position).getAvgdate());
            avgValues.setText(AvgStockQuotes.get(position).getAverageValues());
            return convertView;
        }

    }


}
