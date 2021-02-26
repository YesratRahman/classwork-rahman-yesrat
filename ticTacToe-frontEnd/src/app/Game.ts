import { Location } from "./Location";

export interface Game {
    pieces: number[][];
    gameStatus: number;
    isOTurn: boolean;
    makeMove: (pos: Location) => void;
    gameOver: () => number;

}

export class TicTacToeGame implements Game {
    pieces: number[][];
    gameStatus: number = -2;
    isOTurn: boolean = true;

    constructor() {
        this.pieces = [];
        for (let row= 0;row< 3;row++) {
            this.pieces[row] = [];
            for (let col= 0;col< 3; col++) {
                this.pieces[row][col] = 0;
            }
        }
    }

    makeMove(pos: Location): void {
        if (this.pieces[pos.row][pos.col] === 0 && this.gameStatus === -2) {
            this.pieces[pos.row][pos.col] = this.isOTurn ? 1 : -1;
            this.gameStatus = this.gameOver();
            this.isOTurn = !this.isOTurn;
        }
    }
    validFullBoard(): boolean {
        for (let row= 0;row < 3;row++) {
            for (let  col= 0;col< 3; col++) {
                if (this.pieces[row][col] === 0) {
                    return false;
                }
            }
        }
        return true;
    }



    checkingRows(): boolean {
        for (let row= 0;row< 3;row++) {
            let rowSum = this.pieces[row][0] + this.pieces[row][1] + this.pieces[row][2];
            if (Math.pow(rowSum, 2) === 9) {
                return true;
            }
        }
        return false;
    }

    checkingColums(): boolean {
        for (let row= 0;row< 3;row++) {
            let colSum = this.pieces[0][row] + this.pieces[1][row] + this.pieces[2][row];
            if (Math.pow(colSum, 2) === 9) {
                return true;
            }
        }
        return false;
    }

    checkingDiagonally(): boolean {
        let d1Sum = this.pieces[0][0] + this.pieces[1][1] + this.pieces[2][2];
        if (Math.pow(d1Sum, 2) === 9) {
            return true;
        }
        let d2Sum = this.pieces[0][2] + this.pieces[1][1] + this.pieces[2][0];
        if (Math.pow(d2Sum, 2) === 9) {
            return true;
        }
        return false;
    }
    gameOver(): number {
        if (this.checkingRows() || this.checkingColums() || this.checkingDiagonally()) {
            return this.isOTurn ? 1 : -1;
        } else {
            if (this.validFullBoard()) {
                return 0;
            }
        }
        return -2;
    }

}