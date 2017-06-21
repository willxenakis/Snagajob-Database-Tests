package com.example.williamxenakis.myapplication;

import android.arch.persistence.room.*;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by william.xenakis on 6/20/17.
 */

public class DatabaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_main);
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

        final TextView text1 = (TextView) findViewById(R.id.textView1);
        TextView text2 = (TextView) findViewById(R.id.textView2);

        //SQLite db
//        this.deleteDatabase(sqlDBHandler.DATABASE_NAME);
//        sqlDBHandler SQLiteDb = new sqlDBHandler(this);
//        SQLiteDb.addDog(new Dog(1, "Doggo", "1984 Happy Valley Rd, Lafayette, CA", 1));
//        text1.setText(SQLiteDb.getDog(1).getName());
//        text2.setText(SQLiteDb.getDog(1).getAddress());

        //I can successfully retrieve data from this db



        //Firebase db
        DatabaseReference fireBaseDb = FirebaseDatabase.getInstance().getReference("Dogs");
        fireBaseDb.child("Dogs").child("1").setValue(new Dog(1, "Doggo", "1984 Happy Valley Rd, Lafayette, CA", 1));


        // Attach a listener to read the data at our posts reference
        fireBaseDb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<HashMap<String,String>> dogs = (List<HashMap<String, String>>) dataSnapshot.child("Dogs").getValue();
                text1.setText(dogs.get(1).get("name"));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
        fireBaseDb.child("Dogs").child("1").child("name").setValue("Doggo 2.0");

        //I can successfully retrieve data from this db


        //Realm db
//        Realm.init(this);
//        Realm realmDb = Realm.getDefaultInstance();
//        realmDb.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                RealmDog dog = realm.createObject(RealmDog.class);
//                dog.dogName = "Fido";
//                dog.age  = 5;
//                dog.address = "1984 Happy Valley Rd, Lafayette, CA";
//                dog.id = 1;
//            }
//        });
//        RealmResults<RealmDog> dogs = realmDb.where(RealmDog.class)
//                .equalTo("age", 5)
//                .findAll();
//        text1.setText(Integer.toString(dogs.get(0).age));
        //I can successfully retrieve data from this db

        //Room db
//        RoomDatabase roomDB = Room.databaseBuilder(getApplicationContext(), RoomDatabase.class, "Dogs").allowMainThreadQueries().build();
//        DogEntity dog2 = new DogEntity();
//        dog2.setId(1);
//        dog2.setName("Rexx");
//        dog2.setAge(2);
//        dog2.setHomeAddress("1984 Happy Valley Rd, Lafayette, CA");
//        roomDB.DogDAO().insertUsers(dog2);
//        text1.setText(roomDB.DogDAO().findByID(1).getHomeAddress());
        //I can successfully retrieve data from this db

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
        //startActivity(new Intent(this, DatabaseActivity.class));

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
