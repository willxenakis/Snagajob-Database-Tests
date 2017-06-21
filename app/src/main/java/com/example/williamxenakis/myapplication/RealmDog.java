package com.example.williamxenakis.myapplication;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by william.xenakis on 6/21/17.
 */

@RealmClass
public class RealmDog extends RealmObject {
    public int id;
    public String dogName;
    public int age;
    public String address;

//    public RealmDog(int id, int age, String dogName, String address){
//        this.id = id;
//        this.age = age;
//        this.dogName = dogName;
//        this.address = address;
//    }
    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getDogName() {
        return dogName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }
}
