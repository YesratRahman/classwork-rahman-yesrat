package com.tp.rpg.weapons;

public class Sword extends Weapon {
    public Sword(){
        super();
    }
    @Override
    public String getComLine(){
        return "Attack with Sword";
    }

    @Override
    public String getComEffectiveLine(){
        return "Uses strength to power the attack of the Sword";
    }
}
