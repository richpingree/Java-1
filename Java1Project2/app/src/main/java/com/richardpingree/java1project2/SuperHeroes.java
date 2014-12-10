package com.richardpingree.java1project2;

/**
 * Created by richardpingree on 12/9/14.
 */
public class SuperHeroes {
    public String name = "";
    public String power = "";
    public String universe = "";

    public SuperHeroes(String _name, String _power, String _universe){
        name = _name;
        power = _power;
        universe = _universe;
    }

    public String toString(){return (name + " " + power + " " + universe);}
}
