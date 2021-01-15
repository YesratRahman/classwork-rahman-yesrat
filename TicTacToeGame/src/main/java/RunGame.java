import java.util.Scanner;

/**
 * Main class to run the Tic Tac Toe Game
 */
public class RunGame {
    public static void main(String[] args) {
        int score = 0;
        int playMore = 0;
        Scanner scn = new Scanner(System.in);
        boolean newGame = true;
        boolean continuePlay = true;
        TicTacToe game = new TicTacToe();
        int TurnCount = 1;
        while (continuePlay) {
            System.out.println("Turn #" + TurnCount);
            if (TurnCount > 5) { //Checks when there is a tie.
                System.out.println("Looks like there's a tie!, let's play again!");
                newGame = true;
                game = new TicTacToe();
                //continue;
                //break;
            }

            if (newGame == true) {
                TurnCount = 1;
                // Welcome Message
                System.out.println("Welcome to the Tic Tac Toe Game!");
                System.out.println("To Start playing, Enter the coordinates to place 'X' into the Board.");
                game.showBoard();
                newGame = false;
            }
            System.out.print("Placement position. Enter a number within 0 - 2 for the row position: ");
            int first = game.GetValue(scn);
            System.out.print("Placement position. Enter a number within 0 - 2 for the column position: ");
            int second = game.GetValue(scn);
            // game.startGame(first, second);

            if (game.startGame(first, second) == 2) {
                game.showBoard();
                continue;
            }

            game.showBoard();
            int[] result = game.isGameCheck();
            score += result[0];
            if (result[1] == 1) { // there is winner
                System.out.println("Your Score is :" + score); // print the score
                System.out.println("Do you want to play again ? Enter 1, Else enter anything "); // check game continue
                // or not
                playMore = scn.nextInt();
                if (playMore == 1) { // Game continue
                    newGame = true; // bring back welcome message
                    game = new TicTacToe(); // reset game object
                    TurnCount = 1;
                    continue;
                } else {// game do not continue
                    continuePlay = false;
                    System.out.println("Your Final Score was :" + score);
                    System.out.println("Thank you for playing with us you are awesome!! ");
                    System.out.println("Good bye!!");
                }
            }
            TurnCount += 1;

        }
        scn.close();
    }
}