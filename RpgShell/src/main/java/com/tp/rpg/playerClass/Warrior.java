package com.tp.rpg.playerClass;

import com.tp.rpg.Character;

public class Warrior extends Character{
    public Warrior(Character player){
        super(player.getName(), player.getGender(),
                player.getLevel(), player.getStrength());

    }


}
