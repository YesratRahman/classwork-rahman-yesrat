
package com.tp.rpg.playerClass;

        import com.tp.rpg.Character;

public class Goblin extends Character {
    public Goblin(Character player){
        super(player.getName(), player.getGender(),
                player.getLevel(), player.getStrength());
    }
}