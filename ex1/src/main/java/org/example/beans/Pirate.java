package org.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Primary
public class Pirate {

    private String name;
    private Boolean init = false;

    //@Autowired // not the best practice
    //private Parrot parrot;

    private Parrot parrotx; // use final

    public Pirate() {}

    public Pirate(String name) {
        this.name = name;
    }

    // @Autowired at constr mostly real app
    @Autowired
    public Pirate(Parrot parrot) { this.parrotx = parrot; }

    @PostConstruct
    public void init (){
        this.init = true;
    }

    public String getName(){

        return name;
    }

    public String setName(String name){

        return this.name = name;
    }

    public Parrot setParrot(Parrot parrot){

        return this.parrotx = parrot;
    }

    public Parrot getParrot(){

        return parrotx;
    }
}
