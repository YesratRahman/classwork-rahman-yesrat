package com.tp.diceroller.services;

import java.util.Random;

public class RNG {
    static Random random = new Random();

    public static int rollDice(int sideOfDice){
        int randomRoll = random.nextInt(sideOfDice) + 1 ;

        return randomRoll;
    }
}
