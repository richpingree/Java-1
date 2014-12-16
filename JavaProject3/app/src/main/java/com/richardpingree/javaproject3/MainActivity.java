//created by Richard Pingree

package com.richardpingree.javaproject3;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.Toast;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.w3c.dom.Text;

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

    //detects if network is connected
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

        //replaces spaces with underscore and puts lowercase
        getInput = getInput.replaceAll(" ", "_").toLowerCase();
        //Log.i("Test", getInput);
        try {
            //Url for api
            String baseURL = "http://api.artistlink.com/home/accounts.json?auth_token=5xVzCSGTz4yNaaxyJbcs";
            URL queryURl = new URL(baseURL + "&name=" + getInput);
            //executes asynctask
            new myTask().execute(queryURl);
            userInput.setText("");

        }  catch (MalformedURLException e) {
            Toast.makeText(getBaseContext(), "Artist not found!", Toast.LENGTH_LONG).show();
            //e.printStackTrace();
        }

        if (isOnline()){
            //Log.i("Test", "you have an internet connection.");
        } else
            //message for no network connection
            Toast.makeText(getBaseContext(), "Not Connected to Network!", Toast.LENGTH_LONG).show();
            //Log.i("Test", "internet not available");

    }

    private void updateDisplay(Artist artist){
        ((TextView) findViewById(R.id.nametxt)).setText(artist.getArtistName());
        ((TextView) findViewById(R.id.genretxt)).setText(artist.getArtistGenre());
        ((TextView) findViewById(R.id.labeltxt)).setText(artist.getArtistLabel());
        ((TextView) findViewById(R.id.countrytxt)).setText(artist.getArtistCountry());
        ((TextView) findViewById(R.id.citytxt)).setText(artist.getArtistCity());
        ((TextView) findViewById(R.id.statetxt)).setText(artist.getArtistState());
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

                    //Log.e("Test", "could not connect to network" + queryURL.toString());
                }
            }
            //Log.i("Test", "recieved data" + jsonString);


            //api string to json

            JSONObject apiData;

            try {
                apiData = new JSONObject(jsonString);
            } catch (Exception e){

                //Log.e("Test", "can not convert");
                apiData = null;
            }

            return apiData;
        }

        @Override
        protected void onPostExecute(JSONObject apiData) {
            //returns data to display
            if (apiData != null){
                Artist result = new Artist(apiData);
                updateDisplay(result);
            }else{
                //alert to tell user that artist not in database

                AlertDialog.Builder alertView = new AlertDialog.Builder(MainActivity.this);
                alertView.setTitle("Artists Not Found!");
                alertView.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertView.show();
            }

        }
    }
}
