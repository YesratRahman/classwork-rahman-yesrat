using System;
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
     * After the player has either moved or attacked (assuming they haven't made it to the goal), 
     * every enemy will each move one square towards the player.  If they are directly next to a player,
     * they will attack the player instead.  If they are blocked by one of their allies and cannot make
     * an attack or move towards an attacking position, they will instead attack the enemy in their way!
     * 
     * 
     * When any enemy dies, they should be removed from the board.  When the player reaches the escape square at the 
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
        static Random rand = new Random();
        //static char[,] gameBoard = new char[15, 15];

        static char player = 'X';
        static char enemy = 'O';
        static char emptySpace = '_';

        static void Main(string[] args)
        {

            int rooms = 1;
            int numberOfEnemies = rooms + 1;

            //Fighter player = SetUpPlayer();
            //PrintBoard(gameBoard);
            int points = 0;

            //while (player.Health > 0)
            //{
            //    Fighter enemy = SetUpEnemy();

            //    Console.WriteLine("Watch out! An enemy " + enemy.Name + " appears!");

            //    points = Battle(player, enemy, points);

            //}

            //GameOverScreen(player, points);
            bool gameOver = false;
            while (!gameOver)
            {
                Fighter fighter = SetUpPlayer();
                //while (player.Health > 0)
                //{
                char[,] gameBoard = ShowBoard();
                GenerateRandomEnemies(gameBoard, enemy, numberOfEnemies);

                PrintBoard(gameBoard);
                GeneratePlayerMoves(gameBoard, player, emptySpace);

                if (gameOver)
                {
                    Console.WriteLine("Player Won the Game");
                    GameOverScreen(fighter, points);
                }
                else
                {
                    Console.WriteLine("Player Won the Game");
                    GameOverScreen(fighter, points);
                }
                //}

            }


        }


        private static int Battle(Fighter player, Fighter enemy, int points)
        {
            Fighter attacker = player;
            Fighter defender = enemy;
            Random rand = new Random();

            while (player.Health > 0 && enemy.Health > 0)
            {
                if (attacker.Weapon.Name == "Crossbow")
                {
                    if (rand.Next(0, 2) == 0)
                    {
                        attacker.Weapon.Damage = 20;
                    }
                    else
                    {
                        attacker.Weapon.Damage = 0;
                    }
                }

                attacker.Attack(defender);

                if (defender.Name == player.Name && player.Health <= 6 && player.Potion > 0)
                {
                    Console.WriteLine("You healed 4 hp with a potion!");
                    player.Health += 4;
                    player.Potion--;
                }

                if (attacker.Name == "Troll")
                {
                    Console.WriteLine("The dang troll regenerated 1 hp!");
                    attacker.Health += 1;
                }

                Fighter temp = attacker;
                attacker = defender;
                defender = temp;

                Console.WriteLine("Current Health: " + player.Health);
                Console.WriteLine("Enemy Health: " + enemy.Health);
            }

            if (enemy.Health <= 0)
            {
                Console.WriteLine("You have defeated the " + enemy.Name);
                Console.WriteLine("---------------------");
                points++;
            }

            return points;
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

            return newFighter;
        }
        private static void GeneratePlayerMoves(char[,] gameBoard, char player, char emptySpace)
        {
            if (gameBoard[14, 14] != player)
            {
                Console.WriteLine("Enter a directional key to make a move ==>> ");
                ConsoleKeyInfo consoleKey = Console.ReadKey();
                for (int row = 0; row < 15; row++)
                {
                    for (int col = 0; col < 15; col++)
                    {
                        if (gameBoard[row, col] == player)
                        {
                            if (consoleKey.Key == ConsoleKey.RightArrow)
                            {
                                if (col < 14)
                                {
                                    gameBoard[row, col + 1] = player;
                                    gameBoard[row, col] = emptySpace;
                                    PrintBoard(gameBoard);
                                    GeneratePlayerMoves(gameBoard, player, emptySpace);
                                }
                                else
                                {
                                    Console.WriteLine("Sorry, you can not move right from here.");
                                    GeneratePlayerMoves(gameBoard, player, emptySpace);
                                }

                            }
                            else if (consoleKey.Key == ConsoleKey.LeftArrow)
                            {
                                if (col > 0)
                                {
                                    gameBoard[row, col - 1] = player;
                                    gameBoard[row, col] = emptySpace;
                                    PrintBoard(gameBoard);
                                    GeneratePlayerMoves(gameBoard, player, emptySpace);
                                }
                                else
                                {
                                    Console.WriteLine("Sorry, you can not move left from here.");
                                    GeneratePlayerMoves(gameBoard, player, emptySpace);
                                }
                            }
                            else if (consoleKey.Key == ConsoleKey.UpArrow)
                            {
                                if (row > 0)
                                {
                                    gameBoard[row - 1, col] = player;
                                    gameBoard[row, col] = emptySpace;
                                    PrintBoard(gameBoard);
                                    GeneratePlayerMoves(gameBoard, player, emptySpace);
                                }
                                else
                                {
                                    Console.WriteLine("Sorry, you can not move up from here.");
                                    GeneratePlayerMoves(gameBoard, player, emptySpace);
                                }
                            }
                            else if (consoleKey.Key == ConsoleKey.DownArrow)
                            {
                                if (row < 14)
                                {
                                    gameBoard[row + 1, col] = player;
                                    gameBoard[row, col] = emptySpace;
                                    PrintBoard(gameBoard);
                                    GeneratePlayerMoves(gameBoard, player, emptySpace);
                                }
                                else
                                {
                                    Console.WriteLine("Sorry, you can not move down from here.");
                                    GeneratePlayerMoves(gameBoard, player, emptySpace);
                                }
                            }
                            else
                            {
                                Console.WriteLine("Invalid move");
                            }

                        }

                    }
                }
            }
            else
            {

                Console.WriteLine("You are inside the battle field");

            }
        }


        private static Fighter SetUpEnemy()
        {
            Random rand = new Random();

            int random = rand.Next(1, 4);

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



        private static void PrintBoard(char[,] board)
        {
            Console.WriteLine();

            for (int i = 0; i < board.GetLength(0); i++)
            {
                for (int j = 0; j < board.GetLength(1); j++)
                {
                    Console.Write(board[i, j] + " ");
                    if (j == 14)
                        Console.WriteLine();
                }
            }
        }

        private static char[,] ShowBoard()
        {

            char[,] gameBoard = new char[15, 15];
            for (int row = 0; row < 15; row++)
            {
                for (int col = 0; col < 15; col++)
                {
                    if (row == 0 && col == 0)
                    {
                        gameBoard[row, col] = player;
                    }
                    else if (row == 14 && col == 14)
                    {
                        gameBoard[row, col] = 'E';
                    }
                    else
                    {
                        gameBoard[row, col] = emptySpace;
                    }

                }


            }
            return gameBoard;
        }

        private static void GenerateRandomEnemies(char[,] board, char enemy, int num)
        {
            int position = 0;
            while (position != num)
            {
                int row = rand.Next(0, 14);
                int col = rand.Next(0, 14);
                if (row == 0 && col == 0)
                {
                    row = rand.Next(0, 14);
                    col = rand.Next(0, 14);
                }
                board[row, col] = enemy;
                position++;
            }
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
