package com.example.williamxenakis.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

/**
 * Created by william.xenakis on 6/20/17.
 */

public class sqlDBHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    public static final String DATABASE_NAME = "dogInfo";
    // Contacts table name
    private static final String DOGS = "dogs";
    // Shops Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_SH_ADDR = "home_address";
    private static final String KEY_AGE = "age";

    public sqlDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + DOGS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_SH_ADDR + " TEXT," + KEY_AGE + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        // Creating tables again
        onCreate(db);
    }

    public void addDog(Dog dog) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, dog.getName()); // Shop Name
        values.put(KEY_SH_ADDR, dog.getAddress()); // Shop Phone Number
        values.put(KEY_AGE, dog.getAge());
        // Inserting Row
        db.insert(DOGS, null, values);
        db.close(); // Closing database connection
    }

    public int updateDog(Dog dog) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, dog.getName());
        values.put(KEY_SH_ADDR, dog.getAddress());
        values.put(KEY_AGE, dog.getAge());
        // updating row
        return db.update(DOGS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(dog.getId())});
    }

    public Dog getDog(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
/*
        Cursor cursor = db.query(DOGS, new String[]{KEY_ID,
                KEY_NAME, KEY_SH_ADDR, KEY_AGE}, KEY_ID + "=?",
        new String[]{String.valueOf(id)}, null, null, null, null);*/

        Cursor cursor = db.rawQuery("select * from dogs", null);
        if (cursor != null)
            cursor.moveToFirst();
        Dog contact = new Dog(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(3)));
        cursor.close();
        // return dog
        return contact;
    }
}
