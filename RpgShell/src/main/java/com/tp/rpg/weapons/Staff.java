package com.tp.rpg.weapons;

public class Staff extends Weapon {
    public Staff(){
        super();
    }
    @Override
    public String getComLine(){
        return "Attack with Staff";
    }

    @Override
    public String getComEffectiveLine(){
        return "Uses strength to power the attack of the Staff";
    }
}
