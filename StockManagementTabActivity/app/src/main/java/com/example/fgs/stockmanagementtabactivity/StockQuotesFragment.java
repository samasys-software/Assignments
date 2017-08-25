package com.example.fgs.stockmanagementtabactivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.fgs.stockmanagementtabactivity.Model.ListData;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.SyncHttpClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by fgs on 8/25/2017.
 */

public class StockQuotesFragment extends Fragment {
    ListView lvDetails;
    ArrayList<ListData> myList=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.stockquotes, container, false);
        String ticker="AAPL";
      //  String value = getArguments().getString("YourKey");
        lvDetails = rootView.findViewById(R.id.stockQuote);
       new StockQuotes(ticker).execute();
        return rootView;
    }
     class StockQuotes extends AsyncTask<Void, Void, JSONObject> {
         private final String stockSymbol;

         JSONObject jsonArray;

         StockQuotes(String ticker) {
             stockSymbol = ticker;
         }


         protected JSONObject doInBackground(Void... params) {
             try {
                 SyncHttpClient asyncHttpClient = new SyncHttpClient();
                 RequestParams requestParams = new RequestParams();
                 requestParams.put("stockSymbol", stockSymbol);

                 String url = "http://192.168.1.9:8080/getStockQuotes";
                 asyncHttpClient.post(url, requestParams, new JsonHttpResponseHandler() {
                     @Override
                     public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                         try {
                             System.out.println(response);
                             jsonArray = response;
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
             return jsonArray;
         }

         @Override
         protected void onPostExecute(JSONObject stocks) {

             System.out.println(stocks);
             try {

                 JSONArray symbol = stocks.getJSONArray("stockQuotes");

                 // ArrayList<String> line=new ArrayList<>();
                 for (int i = 0; i < symbol.length(); i++) {
                     ListData lv = new ListData();


                     lv.setQuoteId(symbol.getJSONObject(i).getString("quoteId"));
                     lv.setStockSymbol(symbol.getJSONObject(i).getString("stockSymbol"));
                     lv.setClose(symbol.getJSONObject(i).getString("close"));
                     lv.setDate(symbol.getJSONObject(i).getString("date"));
                     //add this object into the ArrayList myList
                     myList.add(lv);

                 }
                 lvDetails.setAdapter(new MyBaseAdapter(getActivity(), myList));
               //  ListUtils.setDynamicHeight(lvDetails);



             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
     }


     }
