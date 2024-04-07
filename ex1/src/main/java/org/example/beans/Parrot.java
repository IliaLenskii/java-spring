package org.example.beans;

public class Parrot {

    private String name;

    //public Parrot() {}

    public Parrot(String name) {
        this.name = name;
    }

    public String getName(){

        return name;
    }

    public String setName(String name){

        return this.name = name;
    }

    @Override
    public String toString(){

        return this.getClass() +": "+ this.name;
    }
}
