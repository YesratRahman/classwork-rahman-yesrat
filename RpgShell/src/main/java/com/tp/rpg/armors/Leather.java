package com.tp.rpg.armors;

public class Leather extends Armor{
    @Override
    public String getComLine(){
        return " A sneaky armor allows to dodge some of the attack";
    }
    @Override
    public String getComEffectiveLine(){
        return " Uses dexterity to dodge some of the attack";
    }
}
