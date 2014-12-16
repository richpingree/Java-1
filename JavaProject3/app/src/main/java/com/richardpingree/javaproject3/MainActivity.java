package com.richardpingree.javaproject3;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


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
        userInput.setText("");

        Log.i("Test", getInput);

        if (isOnline()){
            Log.i("Test", "you have an internet connection.");
        } else
            Log.i("Test", "internet not available");




    }
}
