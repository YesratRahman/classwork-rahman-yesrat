package com.tp.rpg;

import java.util.Random;

abstract public class Tools {
    private int level;

    public Tools(){
        Random random = new Random();
        this.setLevel(random.nextInt(5) + 1);

    }

    public void setLevel(int level){
        this.level = level;
    }
    public int getLevel(){
        return level;
    }

    public String getComLine(){
        return "No weapon left, fight with hand";
    }

    public String getComEffectiveLine(){
        return "No armor left to defend";
    }
}
