package com.richardpingree.java1project1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.view.View.*;


public class MainActivity extends Activity implements OnClickListener, AdapterView.OnItemClickListener {

    //variables
    EditText userTxt;
    Button addBtn;
    TextView itemCount;
    TextView average;
    ListView itemList;

    ArrayList<String> items = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Fields and Views
        userTxt = (EditText) findViewById(R.id.userInput);
        itemCount = (TextView) findViewById(R.id.counterTxt);
        average = (TextView) findViewById(R.id.averageChar);

        //Button
        addBtn = (Button) findViewById(R.id.button);
        addBtn.setOnClickListener(this);

        //List
        itemList = (ListView) findViewById(R.id.listView);
        itemList.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String getInput = userTxt.getText().toString();

        if (items.contains(getInput)) {

            Toast.makeText(getBaseContext(), "Item is already on the list.", Toast.LENGTH_SHORT).show();


        }else
        if (getInput == null || getInput.isEmpty()) {

            Toast.makeText(getApplicationContext(), "Blank Entry not allowed!", Toast.LENGTH_SHORT).show();

        }else {

            items.add(getInput);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, items);
            itemList.setAdapter(adapter);
            //resets the text field after entering data
            ((EditText) findViewById(R.id.userInput)).setText("");

            //Number of items
            int numItems = items.size();
            itemCount.setText("Number of Entries: " + numItems);

            //Average Word Length
            aveWordLength();

        }

    }

    private void aveWordLength() {

        //Makes the array into a String
        String allItems = items.toString();

        //calculates each item length by subtracting the comma and space after string is added
        int count = allItems.length() - items.size() * 2;
        //String countString = Integer.toString(count);
        //Log.i("Pingree", countString);

        //the average length per word
        int averageLength = count / items.size();

        average.setText("Average Characters: " + averageLength);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        TextView textView = (TextView) view;
        final AlertDialog.Builder alertView = new AlertDialog.Builder(this);
        alertView.setTitle("You have selected!");
        alertView.setMessage(textView.getText().toString());
        alertView.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }

        });

        alertView.show();

    }
}
