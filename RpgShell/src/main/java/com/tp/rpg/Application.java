package com.tp.rpg;

import com.tp.rpg.armors.*;
import com.tp.rpg.playerClass.Goblin;
import com.tp.rpg.playerClass.Mage;
import com.tp.rpg.playerClass.Warrior;
import com.tp.rpg.weapons.*;

import java.util.Random;
import java.util.Scanner;

public class Application {
    public static Character player;
    public static void main(String[] args) {

        Console.print("Welcome to the Game World");
        boolean quit = false;
        do{
            Console.print("\n1.Create Your Character\n2.Choose your character type\n3.Find a Weapon\n4.Find an Armor" +
                    "\n5.Checkout your Character\n6.Fight\n7.Save a Character\n8." +
                    "Exit the Game ");
           int choice = Console.readInt("\nPlease enter your selection: ", 1, 9);

            switch(choice){
                case 1:
                    createCharacter();
                    break;
                case 2:
                    chooseCharacterType();
                    break;
                case 3:
                    findWeapon();
                    break;
                case 4:
                    findArmor();
                    break;
                case 5:
                    viewCharacter(player);
                    break;
//                case 6:
//                    startFighting();
//                    break;
//                case 7:
//                    saveACharacter();
//                    break;

//                case 8:
//                    quit = true;
//                    Console.print("Thanks for Playing. GoodBye!");
//                    break;
                default:
                    Console.print("Invalid Choice! Try Again. ");
                    break;
            }
        }while (quit == false);
    }


    private static void chooseCharacterType() {
       // int choice;
       // Scanner scn = new Scanner(System.in);

        if(player != null){
            int choice = Console.readInt("Select your character type: \n1. Warrior \n2. Mage Runner \n3. Goblin\n", 1,3 );
            switch (choice){
                case 1:
                    player = new Warrior(player);
                    Console.print("\nYou are now a " + player.getClass().getSimpleName());
                    break;
                case 2:
                    player = new Mage(player);
                    Console.print("\nYou are now a " + player.getClass().getSimpleName());
                    break;
                case 3:
                    player = new Goblin(player);
                    Console.print("\nYou are now a " + player.getClass().getSimpleName());
                    break;
                default:
                    Console.print("Invalid Choice! Try Again.");
                    break;

            }
        }
        else {
            Console.print("No Change of Character");
        }

    }
    private static void createCharacter() {
        String name = null;
        String gender = null;
        Scanner scn = new Scanner(System.in);
        Console.print("\nPlease enter your name: \n");
        name = scn.nextLine();
        int choice = Console.readInt("Please enter your gender: \n1. Female \n2. Male \n", 1,2 );
        switch(choice){
            case 1:
                gender = "Female";
                break;
            case 2:
                gender = "Male";
                break;
            default:
                Console.print("Invalid Choice! Try Again. ");
                break;
        }

        player = new Character(name, gender);
        player.setName(name);
        player.setGender(gender);
        Console.print("Welcome to the Game World.\n");
        Console.print("Your name is " + player.getName());
        Console.print("\nYou are a " + player.getGender());
        Console.print("\nYour class is  " + player.getClass().getSimpleName());
        Console.print("\nYour level is " + player.getLevel());
    }


    private static void findWeapon() {
        int newChoice;

        Weapon weapon = null;

        if(player!=null){
            Console.print("You have found a new Weapon.\n");
            Random random = new Random();
            newChoice = random.nextInt(4) + 1;

            switch(newChoice){
                case 1:
                    weapon = new Fist();
                    break;
                case 2:
                    weapon = new Sword();
                    break;
                case 3:
                    weapon = new Hammer();
                    break;
                case 4:
                    weapon = new Staff();
                    break;
            }
            Console.print("The new weapon is " + weapon.getClass().getSimpleName() + "\n");
            Console.print("Level of the weapon is "+ weapon.getLevel() +"\n");


            int choice = Console.readInt("Do you want to equip it? \n1. Yes \n2. No\n", 1,2);

            switch (choice){
                case 1:
                    player.setEquipsWeapon(weapon);
                    Console.print("Congrats, your new weapon is " + weapon.getClass().getSimpleName());
                    break;
                case 2:
                    Console.print("Sorry you didn't choose any weapon this time!");
                    break;
                default:
                    Console.print("Invalid Choice! Try Again.");
                    break;
            }
        }
        else{
            Console.print("No character was chosen first!");
        }

    }


    private static void findArmor() {
        int newChoice;

        Armor armor = null;

        if(player!=null){
            Console.print("You have found a new Armor.\n");
            Random random = new Random();
            newChoice = random.nextInt(4) + 1;

            switch(newChoice){
                case 1:
                    armor = new Shield();
                    break;
                case 2:
                    armor = new Robe();
                    break;
                case 3:
                    armor = new ChainMail();
                    break;
                case 4:
                    armor = new Leather();
                    break;
            }
            Console.print("The new armor is " + armor.getClass().getSimpleName() + "\n");
            Console.print("Level of the armor is "+ armor.getLevel() +"\n");


            int choice = Console.readInt("Do you want to equip it? \n1. Yes \n2. No\n", 1,2);

            switch (choice){
                case 1:
                    player.setEquipsArmor(armor);
                    Console.print("Congrats, your new armor is " + armor.getClass().getSimpleName());
                    break;
                case 2:
                    Console.print("Sorry you didn't choose any armor this time!");
                    break;
                default:
                    Console.print("Invalid Choice! Try Again.");
                    break;
            }
        }
        else{
            Console.print("No character was chosen first!");
        }
    }

    private static void viewCharacter(Character newPlayer) {
        if(newPlayer != null){
            Console.print("Name: " + player.getName() + "\n");
            Console.print("Gender: " + player.getGender()+ "\n");
            Console.print("Character Type: " + player.getClass().getSimpleName()+ "\n");
            Console.print("Level: " + player.getLevel()+ "\n");
            Console.print("Strength: " + player.getStrength()+ "\n");



        }
        else{
            Console.print("No character to view this time!");
        }
    }


//    private static void saveACharacter() {
//    }
//
//    private static void startFighting() {
//    }
//


//
//    private static void loadCharacter(Character human) {
//    }
//






    //walk the user through setting up their character
    private static PlayerCharacter setUpPlayer() {

        throw new UnsupportedOperationException();
    }

    //create some NPC object (with armor & weapons?)
//    private static NonPlayerCharacter setUpEnemy() {
//
//        throw new UnsupportedOperationException();
//    }

    //a and b battle until one is dead
//    private static void battle(Character a, Character b) {
//        Character attacker = a;
//        Character defender = b;
//
//        while( a.isAlive() && b.isAlive() ){
//            if( a.makeChoice().equals("Attack")) {
//                attacker.attack(defender);
//            } else {
//                //TODO: consider other actions
//                throw new UnsupportedOperationException();
//            }
//
//            Character temp = a;
//            a = b;
//            b = temp;
//
//            //TODO: display HP status?
//        }
//    }

    //display some message
    private static void gameOverScreen() {
    }


}
