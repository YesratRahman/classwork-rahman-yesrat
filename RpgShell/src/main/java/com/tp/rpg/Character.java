package com.tp.rpg;

import com.tp.rpg.armors.*;
import com.tp.rpg.weapons.*;

import java.util.Random;

//TODO:
//      add a concept of hit points
//      add a concept of armor (or maybe multiple pieces of armor)
//      add a concept of a weapon (or maybe multiple weapons)
//Stretch goals:
//      add a potion class/interface that the character can drink instead of attacking
//      let the character "disarm" the opponent instead of attacking
//          base this on the weapons used?
//      let the character choose to "block" or "defend"
//          could stun the opponent if they attack?
//          could give us TWO attacks on the next round?
public class Character {

    //TODO: add fields for armor(s) and weapon(s)

    private Weapon weapon;
    private Armor armor;

    private String name;
    private String gender;
    private int level;
    private int strength;

    Random random = new Random();






    public Character(String name, String Gender){
        setName(name);
        setGender(gender);
        setLevel(random.nextInt(5) + 1);
        setStrength(this.getLevel() + (random.nextInt(5)+1));

    }

    public Character(String name, String gender, int level, int strength ){
        setName(name);
        setGender(gender);
        setLevel(level);
        setStrength(strength);
    }


    public void setName(String name ){
        this.name = name;
    }
    public void setGender(String gender){
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getGender(){
        return gender;
    }

    public void setLevel(int level){
        this.level = level;
    }
    public int  getLevel(){
        return level;
    }

    public void setStrength(int strength){
        this.strength = strength;
    }

    public int getStrength(){
        return strength;
    }




    public void attack( Character defender ){
        throw new UnsupportedOperationException();
    }

    public void takeDamage( int damage ){
        throw new UnsupportedOperationException();
    }

    public boolean isAlive(){
        throw new UnsupportedOperationException();
    }


}
