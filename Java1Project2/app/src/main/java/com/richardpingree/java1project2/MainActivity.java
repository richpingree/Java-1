package com.richardpingree.java1project2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import static com.richardpingree.java1project2.R.layout.main;


public class MainActivity extends Activity {

    public ArrayList<SuperHeroes> heroes = new ArrayList<SuperHeroes>();

    Spinner spinnerView;
    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //add to arraylist
        heroes.add(new SuperHeroes("Superman", "Heat Vision", "DC"));
        heroes.add(new SuperHeroes("Storm", "Weather Control", "Marvel"));
        heroes.add(new SuperHeroes("Flash", "Super Speed", "DC"));
        heroes.add(new SuperHeroes("Wolverine", "Regeneration", "Marvel"));
        heroes.add(new SuperHeroes("Green Lantern", "Willpower", "DC"));
        heroes.add(new SuperHeroes("Captain America", "Super Soldier", "Marvel"));
        heroes.add(new SuperHeroes("Wonder Woman", "Lasso of Truth", "DC"));
        heroes.add(new SuperHeroes("Professor X", "Telepathy", "Marvel"));

        //Log.i("Test", heroes.toString());

        //activity for detailed view
        final Intent intent = new Intent(getBaseContext(), detailActivity.class);

        //creates spinnerView
        spinnerView = (Spinner) findViewById(R.id.spinner);
                if(spinnerView != null){
                    //adds array to spinnerView
                    ArrayAdapter<SuperHeroes> spinAdapter = new ArrayAdapter<SuperHeroes>(this, android.R.layout.simple_spinner_dropdown_item, heroes);
                    spinnerView.setAdapter(spinAdapter);

                    //onclick for spinner
                    spinnerView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            //sets values for detailed view
                            SuperHeroes selected = (SuperHeroes)spinnerView.getItemAtPosition(position);
                            String name = selected.name;
                            String power = selected.power;
                            String universe = selected.universe;
                            intent.putExtra("value1", name);
                            intent.putExtra("value2", power);
                            intent.putExtra("value3", universe);
                            startActivity(intent);

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });


                }
                else {
                    //creates list view
                    list = (ListView) findViewById(R.id.listView);
                    //adds array to list view
                    ArrayAdapter<SuperHeroes> listAdapter = new ArrayAdapter<SuperHeroes>(this, android.R.layout.simple_list_item_1, heroes);
                    list.setAdapter(listAdapter);

                    //onclick for list view
                    list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                        @Override
                        public void onItemClick(AdapterView<?> parent,View view, int position, long id) {

                            //sets values for detailed view
                            SuperHeroes listselected = (SuperHeroes)list.getItemAtPosition(position);
                            String name = listselected.name;
                            String power = listselected.power;
                            String universe = listselected.universe;
                            intent.putExtra("value1", name);
                            intent.putExtra("value2", power);
                            intent.putExtra("value3", universe);
                            startActivity(intent);

                        }
                    });

                }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
