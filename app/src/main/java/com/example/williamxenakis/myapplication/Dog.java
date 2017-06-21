package com.example.williamxenakis.myapplication;

/**
 * Created by william.xenakis on 6/20/17.
 */

public class Dog {
    private int id;
    private String name;
    private String homeAddress;
    private int age;

    public Dog() {
    }

    public Dog(int id, String name, String homeAddress, int age) {
        this.id = id;
        this.name = name;
        this.homeAddress = homeAddress;
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return homeAddress;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
