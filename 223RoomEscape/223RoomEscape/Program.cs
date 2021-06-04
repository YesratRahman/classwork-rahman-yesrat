using System;
using System.Collections.Generic;
using _223RoomEscape.Classes.Fighter;


/**
     * 
     * Players will have to try to fight their way from the upper left corner (0,0) to the lower right corner (14,14).  
     * Every time they spawn in the upper left, the room with populate with N randomly generated enemies 
     * (using the same constraints as below) at random locations, where N is equal to 1 + the number of 
     * rooms they have completed so far.
     * 
     * At each step, the board will be drawn (with a border around the grid, a symbol 
     * for the player, a symbol for the exit, and symbols for each enemy).  At each step, 
     * the player may attempt to walk up, down, left, or right (bonus gold star if you can 
     * get this to work with just the arrow keys).  Attempting to walk into a square where 
     * there is already an enemy will cause the player to instead attack.
     * 
     * 
     * After the player has either GeneratePlayerMoved or attacked (assuming they haven't made it to the goal), 
     * every enemy will each GeneratePlayerMove one square towards the player.  If they are directly next to a player,
     * they will attack the player instead.  If they are blocked by one of their allies and cannot make
     * an attack or GeneratePlayerMove towards an attacking position, they will instead attack the enemy in their way!
     * 
     * 
     * When any enemy dies, they should be reGeneratePlayerMoved from the board.  When the player reaches the escape square at the 
     * opposite, they will load into the next room which will have one more enemy.  This process repeats until the 
     * player dies or they defeat the last room in which all 223 available squares (every square other than the player 
     * and the exit) will be filled enemies!
     * 
     * Players should be able to choose 1 of (at least) 3 character classes, 
     * each with different abilities (healing each turn, doing extra damage, % chance to dodge, etc).
     * Players should be able to choose 1 of (at least) 3 weapons, each with different (random) damage formulas.
     * Players should be able to choose 1 of (at least) 3 armors, each with different damage reduction formulas.
     * Players should be given 1 health potion which they will automatically drink if their health would otherwise 
     * be reduced below zero (they should be alerted to this when it happens).
     */
namespace _223RoomEscape
{
    class Program
    {
        static Random random = new Random();
        static List<Fighter> numberOfEnemies = new List<Fighter>();
        static char player = 'X';
        static char enemy = 'O';
        static char emptySpace = '_';
        static void Main(string[] args)
        {
            Fighter fighter = SetUpPlayer();
            int numberOfRooms = 1;
            bool gameStatus = false;
            char[,] gameBoard = new char[15, 15];
            while (gameStatus == false || numberOfRooms != 15)
            {
                GenerateGameBoard(gameBoard, numberOfRooms, player, emptySpace);
                bool gameComplete = false;
                while (!gameComplete)
                {
                    ShowGameBoard(gameBoard, numberOfRooms);
                    Console.WriteLine("Press the directional key where you would like to GeneratePlayerMove next.");
                    ConsoleKeyInfo keyInfo = Console.ReadKey();
                    switch (keyInfo.Key)
                    {
                        case ConsoleKey.RightArrow:
                        case ConsoleKey.UpArrow:
                        case ConsoleKey.LeftArrow:
                        case ConsoleKey.DownArrow:
                            gameStatus = GeneratePlayerMove(fighter, gameBoard, keyInfo.Key);
                            break;
                        default:
                            Console.WriteLine("Entered key is not A status Key");
                            break;
                    }

                    if (gameBoard[14, 14] == player)
                    {
                        Console.WriteLine("You completed room " + numberOfRooms);
                        fighter.Row = 0;
                        fighter.Col = 0;
                        gameComplete = true;
                        numberOfRooms++;
                        break;
                    }

                    //gameStatus = GenerateEnemyMove(fighter, gameBoard);

                    if (gameStatus)
                    {
                        break;
                    }
                }
               
            }
           

        }

        private static void GenerateGameBoard(char[,] room, int numberOfRooms, char player, char emptySpace)
        {
            numberOfEnemies.Clear();

            for (int i = 0; i < 15; i++)
            {
                for (int j = 0; j < 15; j++)
                {
                    if (i == 0 && j == 0)
                    {
                        room[i, j] = player;
                    }
                    else if (i == 14 && j == 14)
                    {
                        room[i, j] = 'E';
                    }
                    else
                    {
                        room[i, j] = emptySpace;
                    }
                }
            }
            PlaceEnemies(numberOfRooms, room);

        }


        private static void PlaceEnemies(int roomNum, char[,] room)
        {
            for (int i = 0; i < roomNum + 1; i++)
            {
                bool placed = false;

                while (!placed)
                {
                    int spawnRow = random.Next(0, 14);
                    int spawnCol = random.Next(0, 14);

                    Fighter enemyFi = SetUpEnemy();
                    numberOfEnemies.Add(enemyFi);

                    if (room[spawnRow, spawnCol] == emptySpace)
                    {
                        room[spawnRow, spawnCol] = enemy;
                        enemyFi.Col = spawnCol;
                        enemyFi.Row = spawnRow;
                        placed = true;
                    }
                }
            }
        }


        private static bool GeneratePlayerMove(Fighter fighter, char[,] room, ConsoleKey consoleKey)
        {

            bool status = true;
            bool gameComplete = false;

            if ((fighter.Row != 14 && consoleKey == ConsoleKey.DownArrow && room[fighter.Row + 1, fighter.Col] != emptySpace)
                || (fighter.Row != 0 && consoleKey == ConsoleKey.UpArrow && room[fighter.Row - 1, fighter.Col] != emptySpace)
                || (fighter.Col != 0 && consoleKey == ConsoleKey.LeftArrow && room[fighter.Row, fighter.Col - 1] != emptySpace)
                || (fighter.Col != 14 && consoleKey == ConsoleKey.RightArrow && room[fighter.Row, fighter.Col + 1] != emptySpace))
            {

                gameComplete = Battle(fighter, consoleKey, room);
            }

            if (gameComplete)
            {
                return gameComplete;
            }

            if ((fighter.Row == 0 && consoleKey == ConsoleKey.UpArrow) || (fighter.Row == 14 && consoleKey == ConsoleKey.DownArrow))
            {
                status = false;
            }

            if ((fighter.Col == 0 && consoleKey == ConsoleKey.LeftArrow) || (fighter.Col == 14 && consoleKey == ConsoleKey.RightArrow))
            {
                status = false;
            }

            if (status)
            {
                if (consoleKey == ConsoleKey.UpArrow)
                {
                    room[fighter.Row - 1, fighter.Col] = player;
                    room[fighter.Row, fighter.Col] = emptySpace;
                    fighter.Row -= 1;
                }
                else if (consoleKey == ConsoleKey.LeftArrow)
                {
                    room[fighter.Row, fighter.Col - 1] = player;
                    room[fighter.Row, fighter.Col] = emptySpace;
                    fighter.Col -= 1;
                }

                else if (consoleKey == ConsoleKey.DownArrow)
                {
                    room[fighter.Row + 1, fighter.Col] = player;
                    room[fighter.Row, fighter.Col] = emptySpace;
                    fighter.Row += 1;
                }
                else if (consoleKey == ConsoleKey.RightArrow)
                {
                    room[fighter.Row, fighter.Col + 1] = player;
                    room[fighter.Row, fighter.Col] = emptySpace;
                    fighter.Col += 1;
                }

                else
                {
                    Console.WriteLine("Sky is falling");
                }

            }
            else
            {
                Console.WriteLine("You cannot GeneratePlayerMove there!");
            }

            return gameComplete;
        }

       
        private static void ShowGameBoard(char[,] board, int roomNum)
        {
            Console.WriteLine();
            Console.WriteLine("You are inside room: " + roomNum);
            Console.WriteLine();
            for (int row = 0; row < 15; row++)
            {
                for (int col = 0; col < 15; col++)
                {
                    Console.Write(board[row, col] + " ");
                }
                Console.WriteLine();
            }
        }

        private static bool Battle(Fighter fighter, ConsoleKey consoleKey, char[,] room)
        {
            Fighter attacker = fighter;
            int enemyCol = 0, enemyRow = 0;

            if (consoleKey == ConsoleKey.UpArrow)
            {
                enemyCol = fighter.Col;
                enemyRow = fighter.Row - 1;
            }
            if (consoleKey == ConsoleKey.LeftArrow)
            {
                enemyCol = fighter.Col - 1;
                enemyRow = fighter.Row;
            }
            if (consoleKey == ConsoleKey.DownArrow)
            {
                enemyCol = fighter.Col;
                enemyRow = fighter.Row + 1;
            }
            if (consoleKey == ConsoleKey.RightArrow)
            {
                enemyCol = fighter.Col + 1;
                enemyRow = fighter.Row;
            }

            Fighter enemyFi = SetEnemy(enemyRow, enemyCol);
            Fighter defender = enemyFi;
            bool gameComplete = false;

            while (fighter.Health > 0 && enemyFi.Health > 0)
            {
                Console.WriteLine(attacker.Name + " attacks " + defender.Name + " with a " + attacker.Weapon.Name + "!");

                if (attacker.Weapon.Name == "Crossbow")
                {
                    if (random.Next(0, 2) == 0)
                    {
                        Console.WriteLine("The crossbow actually hit!");
                        attacker.Weapon.Damage = 20;
                    }
                    else
                    {
                        Console.WriteLine("The crossbow missed!");
                        attacker.Weapon.Damage = 0;
                    }
                }

                attacker.Attack(defender);

                if (defender.Name == fighter.Name && fighter.Health <= 6 && fighter.Potion > 0)
                {
                    Console.WriteLine("You healed 4 hp with a potion!");
                    fighter.Health += 4;
                    fighter.Potion--;
                }

                if (attacker.Name == "Troll")
                {
                    Console.WriteLine("The dang troll regenerated 1 hp!");
                    attacker.Health += 1;
                }

                Fighter temp = attacker;
                attacker = defender;
                defender = temp;

                Console.WriteLine("Current Health: " + fighter.Health);
                Console.WriteLine("Enemy Health: " + enemyFi.Health);
            }

            if (enemyFi.Health <= 0)
            {
                room[enemyFi.Row, enemyFi.Col] = emptySpace;
                Console.WriteLine("You have defeated the " + enemyFi.Name);
                Console.WriteLine("---------------------");
            }

            if (fighter.Health <= 0)
            {
                gameComplete = true;
            }

            return gameComplete;
        }

        private static Fighter SetUpPlayer()
        {
            Console.WriteLine("Hello warrior, let's get you set up!");
            Console.WriteLine("What shall we call you?");
            string name = Console.ReadLine();

            Console.WriteLine("Choose your fighter type: ");
            Console.WriteLine("Brute | Ninja | Troll");
            string type = Console.ReadLine();

            Console.WriteLine("Choose your Weapon: ");
            Console.WriteLine("Fists | Sword | Crossbow");
            string weapon = Console.ReadLine();

            Console.WriteLine("Choose your Armor: ");
            Console.WriteLine("Helmet | Shirt | Shield");
            string armor = Console.ReadLine();

            Console.WriteLine("Choose how many potions you want to bring: ");
            Console.WriteLine("1 | 2 | 3");
            int potion = Convert.ToInt32(Console.ReadLine());

            return GetType(type, name, weapon, armor, potion);
        }

        private static Fighter GetType(string type, string name, string weapon, string armor, int potion)
        {
            Fighter newFighter = null;

            switch (type)
            {
                case "Brute":
                    newFighter = new Brute(name, 10, weapon, armor, potion);
                    break;
                case "Ninja":
                    newFighter = new Ninja(name, 10, weapon, armor, potion);
                    break;
                case "Troll":
                    newFighter = new Troll(name, 10, weapon, armor, potion);
                    break;
            }

            newFighter.Row = 0;
            newFighter.Col = 0;

            return newFighter;
        }

        private static Fighter SetUpEnemy()
        {

            int random = Program.random.Next(1, 4);

            if (random == 1)
            {
                return new Brute();
            }
            else if (random == 2)
            {
                return new Ninja();
            }
            else if (random == 3)
            {
                return new Troll();
            }

            return new Brute();
        }
        private static Fighter SetEnemy(int row, int col)
        {
            foreach (Fighter enemy in numberOfEnemies)
            {
                if (enemy.Row == row && enemy.Col == col)
                {
                    return enemy;
                }
            }
            return null;
        }

        private static void GameOverScreen(Fighter player, int points)
        {
            Console.WriteLine("\nGAME OVER");
            if (points == 0)
            {
                Console.WriteLine("Impressive, " + player.Name + ", you managed to kill absolutely " + points + " enemies.");
            }
            else if (points == 1)
            {
                Console.WriteLine("Uh, " + player.Name + ", you only killed " + points + " enemy. Disappointing performance.");
            }
            else
            {
                Console.WriteLine("Congratulations, " + player.Name + ", you defeated " + points + " enemies.");
            }
        }

    }
}
