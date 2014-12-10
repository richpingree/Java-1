package com.richardpingree.java1project2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class detailActivity extends Activity {

    TextView heroname;
    TextView heropower;
    TextView herouniverse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        Intent intent = getIntent();
        heroname = (TextView) findViewById(R.id.nametext);
        heropower =(TextView) findViewById(R.id.powertext);
        herouniverse = (TextView) findViewById(R.id.universetext);
        String name = intent.getStringExtra("value1");
        String power = intent.getStringExtra("value2");
        String universe = intent.getStringExtra("value3");
        heroname.setText(name);
        heropower.setText(power);
        herouniverse.setText(universe);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail, menu);
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
