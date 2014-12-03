package com.richardpingree.java1project1;

import android.app.Activity;
import android.os.Bundle;
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


public class MainActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {

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

            Toast.makeText(getBaseContext(), "Item is already on the list..", Toast.LENGTH_SHORT).show();


        }else
        if (getInput == null || getInput.isEmpty()) {

            Toast.makeText(getApplicationContext(), "Blank Entry not allowed!", Toast.LENGTH_SHORT).show();


        }else {
            items.add(getInput);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, items);
            itemList.setAdapter(adapter);
            ((EditText) findViewById(R.id.userInput)).setText("");


            //Number of items
            int numItems = items.size();
            itemCount.setText("Number of Entries: " + numItems);

        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
