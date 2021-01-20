import java.util.Scanner;


public class TicTacToe {

    // 2 dimensional array of 3 rows and 3 columns for the game's board
    public String[][] gameBoard = new String[3][3];
    private String computer = " O ";
    private String user = " X ";

    // Default Constructor which fills the board places with dashes
    public TicTacToe() {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[0].length; col++) {
                gameBoard[row][col] = " _ ";
            }
        }
    }

    // Sets the game board with symbols
    public void showBoard() {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[0].length; col++) {
                if (col > 0 && col < 3)
                    System.out.print("|");
                else
                    System.out.println("");
                System.out.print(gameBoard[row][col]);
            }
        }
        System.out.println("");
    }

    // Allows the user to choose their turn, then allows computer to choose the turn
    public int startGame(int row, int col) {
        int pcTurn = 1;
        // Checks if there is any space for the user to enter their move
        // If a space is taken, prompts user to choose another position
        if (!gameBoard[row][col].equals(computer) && !gameBoard[row][col].equals(user)) {
            gameBoard[row][col] = " X ";
        } else {
            System.out.println("Position is taken. Try another position!");
            return 2;
        }

        //Computer randomly generates it's turns
        while (pcTurn < 5) {

            // System.out.println("just here chilling ...PC turn is: "+ pcTurn);
            int x = ((int) (3 * Math.random()));
            int y = ((int) (3 * Math.random()));

            if (!gameBoard[x][y].equals(computer) && !gameBoard[x][y].equals(user)) {
                gameBoard[x][y] = " O ";
                break;
            }
            pcTurn += 1;
        }
        return 0;
    }

    /**
     * This method checks if the user input is a valid input which should be in 0-2 range
     * If not, outputs the error message and directs user to input a valid value
     * @param scn
     * @return returns the valid position
     */
    public int GetValue(Scanner scn) {
        int value = scn.nextInt();
        while (value < 0 || value > 2) {
            System.out.println("Invalid Entry!");
            System.out.print("Enter a number within 0 - 2: ");
            value = scn.nextInt();
        }
        return value;
    }

    /**
     *Checks each cases for the user and computer and outputs based on that. This method also keeps track of the
     * score if the user wins
     * @return the score of the game and the winner
     */
    public int[] isGameCheck() {
        int score = 0;
        // Horizontal
        int isThereAwinner = 0;
        // case 1: for the first row
        if (gameBoard[0][0].equals(user) && (gameBoard[0][1].equals(user)) && gameBoard[0][2].equals(user)) {
            System.out.println("Congratulations! You won the Game.");
            score += 100;
            isThereAwinner = 1;
        }
        // case 2: for the 2nd row
        else if (gameBoard[1][0].equals(user) && (gameBoard[1][1].equals(user)) && gameBoard[1][2].equals(user)) {
            System.out.println("Congratulations! You won the Game.");
            score += 100;
            isThereAwinner = 1;
        }

        // case 3: for the 3rd row
        else if (gameBoard[2][0].equals(user) && (gameBoard[2][1].equals(user)) && gameBoard[2][2].equals(user)) {
            System.out.println("Congratulations! You won the Game.");
            score += 100;
            isThereAwinner = 1;
        }

        // Vertical
        // case 1: for the 1st column
        else if (gameBoard[0][0].equals(user) && (gameBoard[1][0].equals(user)) && gameBoard[2][0].equals(user)) {
            System.out.println("Congratulations! You won the Game.");
            score += 100;
            isThereAwinner = 1;
        }

        // case 2: for the 2nd column
        else if (gameBoard[0][1].equals(user) && (gameBoard[1][1].equals(user)) && gameBoard[2][1].equals(user)) {
            System.out.println("Congratulations! You won the Game.");
            score += 100;
            isThereAwinner = 1;
        }
        // case 3: for the 3rd column
        else if (gameBoard[0][2].equals(user) && (gameBoard[1][2].equals(user)) && gameBoard[2][2].equals(user)) {
            System.out.println("Congratulations! You won the Game.");
            score += 100;
            isThereAwinner = 1;
        }

        // Diagonal
        // case 1: for the cross match
        else if (gameBoard[0][0].equals(user) && (gameBoard[1][1].equals(user)) && gameBoard[2][2].equals(user)) {
            System.out.println("Congratulations! You won the Game.");
            score += 100;
            isThereAwinner = 1;
        }

        // case 2: for the cross match
        else if (gameBoard[2][0].equals(user) && (gameBoard[1][1].equals(user)) && gameBoard[0][2].equals(user)) {
            System.out.println("Congratulations! You won the Game.");
            score += 100;
            isThereAwinner = 1;
        }

        // Horizontal

        // case 1: for the first row
        else if (gameBoard[0][0].equals(computer) && (gameBoard[0][1].equals(computer))
                && gameBoard[0][2].equals(computer)) {
            System.out.println("Sorry! Computer won the Game.");
            isThereAwinner = 1;
        }
        // case 2: for the 2nd row
        else if (gameBoard[1][0].equals(computer) && (gameBoard[1][1].equals(computer))
                && gameBoard[1][2].equals(computer)) {
            System.out.println("Sorry! Computer won the Game.");
            isThereAwinner = 1;
        }

        // case 3: for the 3rd row
        else if (gameBoard[2][0].equals(computer) && (gameBoard[2][1].equals(computer))
                && gameBoard[2][2].equals(computer)) {
            System.out.println("Sorry! Computer won the Game.");
            isThereAwinner = 1;
        }

        // Vertical
        // case 1: for the 1st column
        else if (gameBoard[0][0].equals(computer) && (gameBoard[1][0].equals(computer))
                && gameBoard[2][0].equals(computer)) {
            System.out.println("Sorry! Computer won the Game.");
            isThereAwinner = 1;
        }

        // case 2: for the 2nd column
        else if (gameBoard[0][1].equals(computer) && (gameBoard[1][1].equals(computer))
                && gameBoard[2][1].equals(computer)) {
            System.out.println("Sorry! Computer won the Game.");
            isThereAwinner = 1;
        }
        // case 3: for the 3rd column
        else if (gameBoard[0][2].equals(computer) && (gameBoard[1][2].equals(computer))
                && gameBoard[2][2].equals(computer)) {
            System.out.println("Sorry! Computer won the Game.");
            isThereAwinner = 1;
        }

        // Diagonal
        // case 1: for the cross match
        else if (gameBoard[0][0].equals(computer) && (gameBoard[1][1].equals(computer))
                && gameBoard[2][2].equals(computer)) {
            System.out.println("Sorry! Computer won the Game.");
            isThereAwinner = 1;
        }

        // case 2: for the cross match
        else if (gameBoard[2][0].equals(computer) && (gameBoard[1][1].equals(computer))
                && gameBoard[0][2].equals(computer)) {
            System.out.println("Sorry! Computer won the Game.");
            isThereAwinner = 1;
        }
        int[] val = { score, isThereAwinner };
        return val;
    }

}



//
//public class TicTacToe {
//
//    //2 dimensional array of 3 rows and 3 columns for the game's board
//    public String[][] gameBoard = new String[3][3];
//    private String computer = " O ";
//    private String user = " X ";
//
//    //Default Constructor which fills the board places with dashes
//    public TicTacToe() {
//        for (int row = 0; row < gameBoard.length; row++) {
//            for (int col = 0; col < gameBoard[0].length; col++) {
//                gameBoard[row][col] = " _ ";
//            }
//        }
//    }
//
//    //Sets the game board with symbols
//    public void showBoard() {
//        for (int row = 0; row < gameBoard.length; row++) {
//            for (int col = 0; col < gameBoard[0].length; col++) {
//                if (col > 0 && col < 3)
//                    System.out.print("|");
//                else
//                    System.out.println("");
//                System.out.print(gameBoard[row][col]);
//            }
//        }
//    }
//
//    //Allows the user to choose their turn, then allows computer to choose the turn
//    public void startGame(int row, int col) {
//
//        //Checks if there is any space for the user to enter their move
//        //If a space is taken, prompts user to choose another position
//        if (!gameBoard[row][col].equals(computer) && !gameBoard[row][col].equals(user)) {
//            gameBoard[row][col] = " X ";
//        } else {
//            System.out.println("Position is taken. Try another position!");
//        }
//
//        boolean isValid = false;
//        while (true) {
//            int x = ((int) (3 * Math.random()));
//            int y = ((int) (3 * Math.random()));
//
//            if (!gameBoard[x][y].equals(computer) && !gameBoard[x][y].equals(user)) {
//                gameBoard[x][y] = " O ";
//                break;
//            }
//        }
//    }
//
//    public boolean isGameCheck() {
//
//        //Horizontal
//
//        //case 1: for the first row
//        if (gameBoard[0][0].equals(user) && (gameBoard[0][1].equals(user)) && gameBoard[0][2].equals(user)) {
//            System.out.println("Congratulations! You won the Game.");
//            return true;
//        }
//        //case 2: for the 2nd row
//        else if (gameBoard[1][0].equals(user) && (gameBoard[1][1].equals(user)) && gameBoard[1][2].equals(user)) {
//            System.out.println("Congratulations! You won the Game.");
//            return true;
//        }
//
//        //case 3: for the 3rd row
//        else if (gameBoard[2][0].equals(user) && (gameBoard[2][1].equals(user)) && gameBoard[2][2].equals(user)) {
//            System.out.println("Congratulations! You won the Game.");
//            return true;
//        }
//
//        //Vertical
//        //case 1: for the 1st column
//        else if (gameBoard[0][0].equals(user) && (gameBoard[1][0].equals(user)) && gameBoard[2][0].equals(user)) {
//            System.out.println("Congratulations! You won the Game.");
//            return true;
//        }
//
//        //case 2: for the 2nd column
//        else if (gameBoard[0][1].equals(user) && (gameBoard[1][1].equals(user)) && gameBoard[2][1].equals(user)) {
//            System.out.println("Congratulations! You won the Game.");
//            return true;
//        }
//        //case 3: for the 3rd column
//        else if (gameBoard[0][2].equals(user) && (gameBoard[1][2].equals(user)) && gameBoard[2][2].equals(user)) {
//            System.out.println("Congratulations! You won the Game.");
//            return true;
//        }
//
//        //Diagonal
//        //case 1: for the cross match
//        else if (gameBoard[0][0].equals(user) && (gameBoard[1][1].equals(user)) && gameBoard[2][2].equals(user)) {
//            System.out.println("Congratulations! You won the Game.");
//            return true;
//        }
//
//        //case 2: for the cross match
//        else if (gameBoard[2][0].equals(user) && (gameBoard[1][1].equals(user)) && gameBoard[0][2].equals(user)) {
//            System.out.println("Congratulations! You won the Game.");
//            return true;
//        }
//
//
//        //Horizontal
//
//        //case 1: for the first row
//        else if (gameBoard[0][0].equals(computer) && (gameBoard[0][1].equals(computer)) && gameBoard[0][2].equals(computer)) {
//            System.out.println("Sorry! Computer won the Game.");
//            return true;
//        }
//        //case 2: for the 2nd row
//        else if (gameBoard[1][0].equals(computer) && (gameBoard[1][1].equals(computer)) && gameBoard[1][2].equals(computer)) {
//            System.out.println("Sorry! Computer won the Game.");
//            return true;
//        }
//
//        //case 3: for the 3rd row
//        else if (gameBoard[2][0].equals(computer) && (gameBoard[2][1].equals(computer)) && gameBoard[2][2].equals(computer)) {
//            System.out.println("Sorry! Computer won the Game.");
//            return true;
//        }
//
//        //Vertical
//        //case 1: for the 1st column
//        else if (gameBoard[0][0].equals(computer) && (gameBoard[1][0].equals(computer)) && gameBoard[2][0].equals(computer)) {
//            System.out.println("Sorry! Computer won the Game.");
//            return true;
//        }
//
//        //case 2: for the 2nd column
//        else if (gameBoard[0][1].equals(computer) && (gameBoard[1][1].equals(computer)) && gameBoard[2][1].equals(computer)) {
//            System.out.println("Sorry! Computer won the Game.");
//            return true;
//        }
//        //case 3: for the 3rd column
//        else if (gameBoard[0][2].equals(computer) && (gameBoard[1][2].equals(computer)) && gameBoard[2][2].equals(computer)) {
//            System.out.println("Sorry! Computer won the Game.");
//            return true;
//        }
//
//        //Diagonal
//        //case 1: for the cross match
//        else if (gameBoard[0][0].equals(computer) && (gameBoard[1][1].equals(computer)) && gameBoard[2][2].equals(computer)) {
//            System.out.println("Sorry! Computer won the Game.");
//            return true;
//        }
//
//        //case 2: for the cross match
//        else if (gameBoard[2][0].equals(computer) && (gameBoard[1][1].equals(computer)) && gameBoard[0][2].equals(computer)) {
//            System.out.println("Sorry! Computer won the Game.");
//            return true;
//        }
//
//        return false;
//    }
//}




//public class TicTacToe {
//
//    //2 dimensional array of 3 rows and 3 columns for the game's board
//    public String[][] gameBoard = new String[3][3];
//    private String computer = " O ";
//    private String user = " X ";
//
//    //Default Constructor which fills the board places with dashes
//    public TicTacToe() {
//        for (int row = 0; row < gameBoard.length; row++) {
//            for (int col = 0; col < gameBoard[0].length; col++) {
//                gameBoard[row][col] = " _ ";
//            }
//        }
//    }
//
//    //Sets the game board with symbols
//    public void showBoard() {
//        for (int row = 0; row < gameBoard.length; row++) {
//            for (int col = 0; col < gameBoard[0].length; col++) {
//                if (col > 0 && col < 3)
//                    System.out.print("|");
//                else
//                    System.out.println("");
//                System.out.print(gameBoard[row][col]);
//            }
//        }
//    }
//
//    //Allows the user to choose their turn, then allows computer to choose the turn
//    public void startGame(int row, int col) {
//
//        //Checks if there is any space for the user to enter their move
//        //If a space is taken, prompts user to choose another position
//        if (!gameBoard[row][col].equals(computer) && !gameBoard[row][col].equals(user)) {
//            gameBoard[row][col] = " X ";
//        } else {
//            System.out.println("Position is taken. Try another position!");
//        }
//
//        boolean isValid = false;
//        while (true) {
//            int x = ((int) (3 * Math.random()));
//            int y = ((int) (3 * Math.random()));
//
//            if (!gameBoard[x][y].equals(computer) && !gameBoard[x][y].equals(user)) {
//                gameBoard[x][y] = " O ";
//                break;
//            }
//        }
//    }
//
//    public int isGameCheck(int score) {
//
//        //Horizontal
//
//        //case 1: for the first row
//        if (gameBoard[0][0].equals(user) && (gameBoard[0][1].equals(user)) && gameBoard[0][2].equals(user)) {
//            System.out.println("Congratulations! You won the Game.");
//            score += 100;
//        }
//        //case 2: for the 2nd row
//        else if (gameBoard[1][0].equals(user) && (gameBoard[1][1].equals(user)) && gameBoard[1][2].equals(user)) {
//            System.out.println("Congratulations! You won the Game.");
//            score += 100;
//        }
//
//        //case 3: for the 3rd row
//        else if (gameBoard[2][0].equals(user) && (gameBoard[2][1].equals(user)) && gameBoard[2][2].equals(user)) {
//            System.out.println("Congratulations! You won the Game.");
//            score += 100;
//        }
//
//        //Vertical
//        //case 1: for the 1st column
//        else if (gameBoard[0][0].equals(user) && (gameBoard[1][0].equals(user)) && gameBoard[2][0].equals(user)) {
//            System.out.println("Congratulations! You won the Game.");
//            score += 100;
//        }
//
//        //case 2: for the 2nd column
//        else if (gameBoard[0][1].equals(user) && (gameBoard[1][1].equals(user)) && gameBoard[2][1].equals(user)) {
//            System.out.println("Congratulations! You won the Game.");
//            score += 100;
//        }
//        //case 3: for the 3rd column
//        else if (gameBoard[0][2].equals(user) && (gameBoard[1][2].equals(user)) && gameBoard[2][2].equals(user)) {
//            System.out.println("Congratulations! You won the Game.");
//            score += 100;
//        }
//
//        //Diagonal
//        //case 1: for the cross match
//        else if (gameBoard[0][0].equals(user) && (gameBoard[1][1].equals(user)) && gameBoard[2][2].equals(user)) {
//            System.out.println("Congratulations! You won the Game.");
//            score += 100;
//        }
//
//        //case 2: for the cross match
//        else if (gameBoard[2][0].equals(user) && (gameBoard[1][1].equals(user)) && gameBoard[0][2].equals(user)) {
//            System.out.println("Congratulations! You won the Game.");
//            score += 100;
//        }
//
//
//        //Horizontal
//
//        //case 1: for the first row
//        else if (gameBoard[0][0].equals(computer) && (gameBoard[0][1].equals(computer)) && gameBoard[0][2].equals(computer)) {
//            System.out.println("Sorry! Computer won the Game.");
//        }
//        //case 2: for the 2nd row
//        else if (gameBoard[1][0].equals(computer) && (gameBoard[1][1].equals(computer)) && gameBoard[1][2].equals(computer)) {
//            System.out.println("Sorry! Computer won the Game.");
//        }
//
//        //case 3: for the 3rd row
//        else if (gameBoard[2][0].equals(computer) && (gameBoard[2][1].equals(computer)) && gameBoard[2][2].equals(computer)) {
//            System.out.println("Sorry! Computer won the Game.");
//        }
//
//        //Vertical
//        //case 1: for the 1st column
//        else if (gameBoard[0][0].equals(computer) && (gameBoard[1][0].equals(computer)) && gameBoard[2][0].equals(computer)) {
//            System.out.println("Sorry! Computer won the Game.");
//        }
//
//        //case 2: for the 2nd column
//        else if (gameBoard[0][1].equals(computer) && (gameBoard[1][1].equals(computer)) && gameBoard[2][1].equals(computer)) {
//            System.out.println("Sorry! Computer won the Game.");
//        }
//        //case 3: for the 3rd column
//        else if (gameBoard[0][2].equals(computer) && (gameBoard[1][2].equals(computer)) && gameBoard[2][2].equals(computer)) {
//            System.out.println("Sorry! Computer won the Game.");
//        }
//
//        //Diagonal
//        //case 1: for the cross match
//        else if (gameBoard[0][0].equals(computer) && (gameBoard[1][1].equals(computer)) && gameBoard[2][2].equals(computer)) {
//            System.out.println("Sorry! Computer won the Game.");
//        }
//
//        //case 2: for the cross match
//        else if (gameBoard[2][0].equals(computer) && (gameBoard[1][1].equals(computer)) && gameBoard[0][2].equals(computer)) {
//            System.out.println("Sorry! Computer won the Game.");
//        }
//        return score;
//    }
//
//}
//
//
//
//
