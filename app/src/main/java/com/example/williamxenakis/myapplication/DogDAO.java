package com.example.williamxenakis.myapplication;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by william.xenakis on 6/20/17.
 */

@Dao
public interface DogDAO {
    @Query("SELECT * FROM Dogs")
    List<DogEntity> getAll();

    @Query("SELECT * FROM Dogs WHERE id IN (:id)")
    List<DogEntity> loadAllByIds(int[] id);

    @Query("SELECT * FROM Dogs WHERE name LIKE :name")
    DogEntity findByName(String name);

    @Query("SELECT * FROM Dogs WHERE id LIKE :id")
    DogEntity findByID(int id);

    @Insert
    void insertAll(DogEntity... Dogs);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUsers(DogEntity... Dogs);

    @Update
    public void updateUsers(DogEntity... Dogs);

    @Delete
    void delete(DogEntity user);
}
