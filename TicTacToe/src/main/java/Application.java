public class Application {

    public static void main(String[] args) throws Exception{

        // user chooses number of rounds
        int numRounds = getNumRounds();
        int wins = 0;
        int losses = 0;
        int draws = 0;

        // loop through each round
        for( int i = 0; i < numRounds; i++ ) {
            //      randomly choose who goes first
            boolean playerGoesFirst = choosePlayerIsFirst();

            //1 - player wins
            //0 - draw
            //-1 - player loses
            int roundResult = playRound( playerGoesFirst );

            //      record the results
            switch (roundResult){
                case 1:
                    wins++;
                    break;
                case 0:
                    draws++;
                    break;
                case -1:
                    losses++;
                    break;
                default:
                    throw new Exception("Error: got back invalid round result: " + roundResult);
            }

        }
        // report wins/losses/draws
        report(wins, losses, draws);
    }

    public static int getNumRounds(){
        int numRounds = Console.readInt("Please enter the number of rounds to play (1-10): ", 1, 10);

        return numRounds;
    }

    public static boolean choosePlayerIsFirst(){
        int coinFlipResult = Rng.nextInt(0, 1);

        boolean playerIsX = coinFlipResult == 1;

        return playerIsX;
    }


    private static int playRound(boolean isPlayerTurn) {
        int roundResult = Integer.MIN_VALUE;

        //1. create blank board
        int[] board = createBoard();

        // 0 1 2
        // 3 4 5
        // 6 7 8

        boolean gameOver = false;
        boolean xTurn = true;
        while( !gameOver ) {
            //2. print board
            printBoard( board );
            //3. if it's the player's turn, get location from player, otherwise get location from computer
            int location = Integer.MIN_VALUE;
            if( isPlayerTurn ){
                //get the location from the player
                location = getPlayerMove(board);
            } else {
                //get the location from the computer
                location = getComputerMove(board);
            }

            //4. update board with SOME??? mark
            board[location] = xTurn ? 1 : -1;

            //5. check for a win OR draw or loss (exit loop if so), otherwise go to step 2
            //-1 continue playing
            //0 draw
            //1 current player wins
            int currentGameStatus = evaluateBoard(board);

            switch (currentGameStatus){
                case 0:
                    //the game is drawn
                    roundResult = 0;
                    gameOver = true;
                    break;
                case 1:
                    //here the current player has won
                    //1 - player wins
                    //0 - draw
                    //-1 - player loses
                    roundResult = isPlayerTurn ? 1 : -1;
                    gameOver = true;
                    break;
            }

            isPlayerTurn = !isPlayerTurn;
            xTurn = !xTurn;
        }

        printBoard( board );

        return roundResult;
    }

    private static void report(int wins, int losses, int draws) {
        Console.print("Player won " + wins + " times.\n");
        Console.print("Computer won " + losses + " times.\n");
        Console.print("There were " + draws + " draws.\n");
        if( wins < losses ) {
            Console.print("Try harder next time...\n");
        }

    }

    private static int[] createBoard() {
        int[] board = new int[9];

        return board;
    }

    private static void printBoard(int[] board) {
        //                        0    1    2
        char[] displaySymbols = {'O', '.', 'X'};

        //1 - X
        //0 - blank (period so we can distinguish from whitespace)
        //-1 - O

        Console.print('\n');
        for( int row = 0; row < 3; row++ ){
            for( int col = 0; col < 3; col++ ){
                int i = 3 * row + col;

                //gives us -1 to 1
                int valueOnBoard = board[i];

                char displaySymbol = displaySymbols[valueOnBoard + 1];

                Console.print( displaySymbol );
            }
            Console.print('\n');
        }
        Console.print('\n');


    }

    private static int getPlayerMove(int[] board) {
       int location = Integer.MIN_VALUE;

       boolean valid = false;
       while( !valid ){
           location = Console.readInt("Please enter your move (0-8): ",0,8);
           valid = board[location] == 0;
       }

       return location;
    }

    private static int getComputerMove(int[] board) {
        int location = Integer.MIN_VALUE;

        //1. Pick random number between 0 and 8
        //2. see if the location is occupied, if so go back to 1
        boolean valid = false;
        while( !valid ){
            location = Rng.nextInt(0, 8);

            valid = board[location] == 0;
        }

        return location;

    }

    //-1 continue playing
    //0 draw
    //1 current player wins
    private static int evaluateBoard(int[] board) {
        int status = -1;

        //draw check
        int product = 1;
        for( int i = 0; i < 9; i++ ) product *= board[i];
        if( product != 0 ) status = 0;

        //win check
        for( int row = 0; row < 3; row++ ){
            int rowSum = board[row*3+0] + board[row*3+1] + board[row*3+2];
            if( rowSum * rowSum == 9 ) status = 1;
        }

        // 0 1 2
        // 3 4 5
        // 6 7 8

        for( int col = 0; col < 3; col++ ){
            int colSum = board[3 * 0 + col] + board[3 * 1 + col] + board[3 * 2 + col];
            if( colSum * colSum == 9 ) status = 1;
        }

        int d1Sum = board[0] + board[4] + board[8];
        int d2Sum = board[6] + board[4] + board[2];

        if( d1Sum * d1Sum == 9 || d2Sum * d2Sum == 9 ) status = 1;

        return status;
    }



}
