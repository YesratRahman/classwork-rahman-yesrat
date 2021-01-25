package com.tp.rpg.armors;

public class Robe extends Armor{

    @Override
    public String getComLine(){
        return " A robe protects from some of the attack";
    }
    @Override
    public String getComEffectiveLine(){
        return " Uses intelligence to resist some of the attack";
    }
}
