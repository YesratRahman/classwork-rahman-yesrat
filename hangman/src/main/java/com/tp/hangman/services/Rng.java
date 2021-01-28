package com.tp.hangman.services;

import java.util.Random;

public class Rng {
    static Random rng = new Random();

    public static int randomIndex( int maxIndexInc ){

        return rng.nextInt(maxIndexInc + 1);
    }

    public static void reSeed(long seed){

        rng = new Random(seed);

    }
}
