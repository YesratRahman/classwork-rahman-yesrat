
public class Sudoku {
    public static void main(String[] args) {
        char[][] table = {
                {'5', '3', '.', '.', '.', '7', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };
        System.out.println(isValidSudoku(table));

        for (int i = 0; i < table.length; i++) {
            solveSudoku(table);
        }

    }

    //Solve the Sudoku game using the isValidSudoku method
    public static void solveSudoku(char[][] board) {
        if (board == null || board[0].length == 0 || board.length == 0) {
            return;
        }
        isSolveSudoku(board);
    }

    public static boolean isSolveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char character = '1'; character <= '9'; character++) {
                        if (isValidSudoku(board) && isSolveSudoku(board)) {
                            board[i][j] = character;
                            if (isSolveSudoku(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';

                            }
                        }
                    }
                    return false;
                }

            }
        }
        return true;
    }

    //Sudoku Game: check the board if it's a valid board
    private static boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] column = new boolean[9][9];
        boolean[][] each_Block = new boolean[9][9];
        //boolean isValidSudoku = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int check = board[i][j] - '1';
                if (board[i][j] == '.') {
                    continue;
                }
                if (row[i][check] || column[j][check] || each_Block[i - i % 3 + j / 3][check]) {
                    return false;
                } else {
                    row[i][check] = column[j][check] = each_Block[i / 3 * 3 + j / 3][check] = true;
                }
            }
        }
        return true;
    }
}