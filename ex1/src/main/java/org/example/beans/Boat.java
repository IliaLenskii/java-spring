package org.example.beans;

public class Boat {

    private String name;

    public Boat() {}

    public Boat(String name) {
        this.name = name;
    }

    public String getName(){

        return name;
    }

    public String setName(String name){

        return this.name = name;
    }
}
