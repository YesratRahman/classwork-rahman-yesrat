import { Location } from './Location';

export interface Game {
    boardPieces: number[][];
    gameStatus: number;
    isOTurn: boolean;
    makeMove: (pos: Location) => void;
    gameOver: () => number;
}

export class TTTGame implements Game {
    boardPieces: number[][];
    gameStatus: number = -2;
    isOTurn: boolean = true;

    constructor() {
        this.boardPieces = [];
        for (let row= 0;row< 3;row++) {
            this.boardPieces[row] = [];
            for (let col= 0;col< 3; col++) {
                this.boardPieces[row][col] = 0;
            }
        }
    }

    makeMove(pos: Location): void {
        if (this.gameStatus === -2 && this.boardPieces[pos.row][pos.col] === 0) {
            this.boardPieces[pos.row][pos.col] = this.isOTurn ? 1 : -1;
            this.gameStatus = this.gameOver();
            this.isOTurn = !this.isOTurn;
        }
    }
    validFullBoard(): boolean {
        for (let row= 0;row < 3;row++) {
            for (let  col= 0;col< 3; col++) {
                if (this.boardPieces[row][col] === 0) {
                    return false;
                }
            }
        }
        return true;
    }

    //  int d1Sum = board[0] + board[4] + board[8];
    // int d2Sum = board[6] + board[4] + board[2];
    // if( d1Sum * d1Sum == 9 || d2Sum * d2Sum == 9 ) status = 1;

    checkWin(): boolean {
        for (let row= 0;row< 3;row++) {
            let rowSum = this.boardPieces[row][0] + this.boardPieces[row][1] + this.boardPieces[row][2];
            let colSum = this.boardPieces[0][row] + this.boardPieces[1][row] + this.boardPieces[2][row];
            if (rowSum * rowSum === 9) {
                return true;
            }
            if (colSum * colSum === 9) {
                return true;
            }
        }
        let d1Sum = this.boardPieces[0][0] + this.boardPieces[1][1] + this.boardPieces[2][2];
        let d2Sum = this.boardPieces[0][2] + this.boardPieces[1][1] + this.boardPieces[2][0];
        if (d1Sum * d1Sum === 9 || d2Sum * d2Sum === 9) {
            return true;
        }
        return false;
    }
   
    gameOver(): number {
        if (this.checkWin()) {
            return this.isOTurn ? 1 : -1;
        } else {
            if (this.validFullBoard()) {
                return 0;
            }
        }
        return -2;
    }

}