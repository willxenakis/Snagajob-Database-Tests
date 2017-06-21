package com.example.williamxenakis.myapplication;

import android.arch.persistence.room.Database;

/**
 * Created by william.xenakis on 6/20/17.
 */

@Database(entities = {DogEntity.class}, version = 1)
public abstract class RoomDatabase extends android.arch.persistence.room.RoomDatabase {
    public abstract DogDAO DogDAO();
}
