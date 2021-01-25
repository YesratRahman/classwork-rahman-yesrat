package com.tp.rpg.weapons;

public class Hammer extends Weapon {
    public Hammer(){
        super();
    }
    @Override
    public String getComLine(){
        return "Attack with Hammer";
    }

    @Override
    public String getComEffectiveLine(){
        return "Uses strength to power the attack of the Hammer";
    }
}
