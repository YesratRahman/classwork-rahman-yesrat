package com.tp.rpg.playerClass;

import com.tp.rpg.Character;

public class MageRunner extends Character{
    public MageRunner(Character player){
        super(player.getName(), player.getGender(),
                player.getLevel(), player.getStrength());
    }
}