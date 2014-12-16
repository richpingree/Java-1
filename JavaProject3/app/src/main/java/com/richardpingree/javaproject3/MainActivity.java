package com.richardpingree.javaproject3;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;


public class MainActivity extends Activity implements View.OnClickListener {


    EditText userInput;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.userText);

        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);
    }


    protected boolean isOnline() {
        ConnectivityManager connMan = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connMan.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()){

            return true;

        }else{
            return false;
        }
    }
    @Override
    public void onClick(View v) {
        String getInput = userInput.getText().toString();

        getInput = getInput.replaceAll(" ", "_").toLowerCase();
        //Log.i("Test", getInput);
        try {
            String baseURL = "http://api.artistlink.com/home/accounts.json?auth_token=5xVzCSGTz4yNaaxyJbcs";
            URL queryURl = new URL(baseURL + "&name=" + getInput);
            new myTask().execute(queryURl);

        }  catch (MalformedURLException e) {
            e.printStackTrace();
        } {

        }

        if (isOnline()){
            Log.i("Test", "you have an internet connection.");
        } else
            Log.i("Test", "internet not available");

    }

    private class myTask extends AsyncTask<URL, Integer, JSONObject>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected JSONObject doInBackground(URL... urls) {

            String jsonString = "";

            //collect api response
            for (URL queryURL: urls) {
                try {
                    URLConnection conn = queryURL.openConnection();
                    jsonString = IOUtils.toString(conn.getInputStream());
                    //removes brackets from api data
                    jsonString = jsonString.replace("[","");
                    jsonString = jsonString.replace("]","");
                    break;
                } catch (Exception e) {
                    Log.e("Test", "could not connect to network" + queryURL.toString());
                }
            }
            Log.i("Test", "recieved data" + jsonString);


            //api string to json

            JSONObject apiData;

            try {
                apiData = new JSONObject(jsonString);
            } catch (Exception e){
                Log.e("Test", "can not convert");
                apiData = null;
            }

            return apiData;
        }

        @Override
        protected void onPostExecute(JSONObject apiData) {

        }
    }
}
