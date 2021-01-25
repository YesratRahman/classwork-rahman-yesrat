package com.tp.rpg.playerClass;

import com.tp.rpg.Character;

public class Mage extends Character{
    public Mage(Character player){
        super(player.getName(), player.getGender(),
                player.getLevel(), player.getStrength());
    }
}