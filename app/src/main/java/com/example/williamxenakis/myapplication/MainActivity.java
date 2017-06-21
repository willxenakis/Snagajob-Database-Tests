package com.example.williamxenakis.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TabLayout layout = (TabLayout) findViewById(R.id.TabBar);
        layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                TextView text = (TextView) findViewById(R.id.textView1);

                if (tab.getPosition() == 0) {
                    text.setText("Left Tab Active");
                } else if (tab.getPosition() == 1) {
                    text.setText("Center Tab Active");
                } else {
                    text.setText("Right Tab Active");
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
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

    public void buttonClicked(View view) {
        TextView text = (TextView) findViewById(R.id.textView1);
        startActivity(new Intent(this, DatabaseActivity.class));


        if (text.getText() == "Hi") {
            text.setText("Hello World");
        } else {
            text.setText("Hi");
        }
    }

    public void boxChecked(View view) {
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        TextView text = (TextView) findViewById(R.id.textView1);
        if (checkBox.isChecked()) {
            text.setText("Yo");
        } else {
            text.setText("No");
        }
    }

    public void switched(View view) {
        TextView text = (TextView) findViewById(R.id.textView1);
        Switch aSwitch = (Switch) findViewById(R.id.switch1);
        if (aSwitch.isChecked()) {
            text.setText("Swotched");
        } else {
            text.setText("Not Swotched");
        }
    }
}
