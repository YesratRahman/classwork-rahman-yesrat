package com.tp.rpg;

import com.tp.rpg.playerClass.MageRunner;
import com.tp.rpg.playerClass.Warrior;
import com.tp.rpg.weapons.Fist;
import com.tp.rpg.weapons.Gun;
import com.tp.rpg.weapons.Weapon;

import java.util.Random;
import java.util.Scanner;

public class Application {
    public static Character player;
    //public static Scanner input;

    public static void main(String[] args) {

        int choice = 9;
        //boolean quit = false;
        //input = new Scanner(System.in);

        Console.print("Welcome to the Game World");

        do{
            Console.print("\n1.Create Your Character\n2.Choose Class\n3.Find a Weapon\n4.Find an Armor" +
                    "\n5.Checkout your Character\n6.Fight\n7.Save a Character\n8." +
                    "Exit the Game ");
            choice = Console.readInt("\nPlease enter your selection: ", 1, 9);

            switch(choice){
                case 1:
                    createCharacter();
                    break;
                case 2:
                    chooseClass();
                    break;
                case 3:
                    findWeapon();
                    break;
//                case 4:
//                    findArmor();
//                    break;
//                case 5:
//                    viewCharacter(human);
//                    break;
//                case 6:
//                    startFighting();
//                    break;
//                case 7:
//                    saveACharacter();
//                    break;

//                case 8:
//                    Console.print("Thanks for Playing. GoodBye!");
//                    break;
                default:
                    Console.print("Invalid Choice! Try Again. ");
                    break;
            }
        }while(choice < 9);

        PlayerCharacter pc = setUpPlayer();

        while( pc.isAlive() ){
            NonPlayerCharacter enemy = setUpEnemy();

            //battle( pc, enemy );


        }

        gameOverScreen();

    }


    private static void chooseClass() {
        int choice;
        Scanner scn = new Scanner(System.in);

        if(player != null){
            Console.print("Select your new class: \n");
            Console.print("1. Warrior\n");
            Console.print("2. Mage Runner\n");
            choice = scn.nextInt();
            scn.nextLine();
            switch (choice){
                case 1:
                    player = new Warrior(player);
                    Console.print("\nYou are now a " + player.getClass().getSimpleName());
                    break;
                case 2:
                    player = new MageRunner(player);
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
        Console.print("\nPlease enter your gender: ");
        Console.print("\n1. Female");
        Console.print("\n2. Male\n");
        int choice = 0;
        choice = scn.nextInt();
        scn.nextLine();


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
        int choice;
        int newChoice;

        Weapon weapon = null;

        if(player!=null){
            Console.print("You have found a new Weapon.");
            Random random = new Random();
            newChoice = random.nextInt(4) + 1;

            switch(newChoice){
                case 1:
                    weapon = new Fist();
                    break;
                case 2:
                    weapon = new Gun();
                    break;
            }
            Console.print("You have found " + weapon.getClass().getSimpleName());
            Console.print("Level of the weapon is " );


        }

    }

//    private static void saveACharacter() {
//    }
//
//    private static void startFighting() {
//    }
//
//    private static void viewCharacter(Character human) {
//    }
//

//
//    private static void loadCharacter(Character human) {
//    }
//
//    private static void findArmor() {
//    }
//






    //walk the user through setting up their character
    private static PlayerCharacter setUpPlayer() {

        throw new UnsupportedOperationException();
    }

    //create some NPC object (with armor & weapons?)
    private static NonPlayerCharacter setUpEnemy() {

        throw new UnsupportedOperationException();
    }

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
