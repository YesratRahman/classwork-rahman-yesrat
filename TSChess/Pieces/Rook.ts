import { Board } from "../Board";
import { Move } from "../Move";
import { Piece, PieceType } from "./Piece";

export class Rook implements Piece {

    kind : PieceType = PieceType.Rook;

    isWhite : boolean;

    

    constructor( isWhite : boolean ){
        this.isWhite = isWhite;
    }

    generateMoves: (moveOn: Board, row: number, col: number) => Move[] = 
         (moveOn: Board, row: number, col: number)  => {

            // Rooks "slide" either horizontally or vertically

            let rookMoves : Move[]  = [];
            //1. from row to allSqures.length 
            //2. from col to allSQures[0]
            //3. from row to 0 
            //4. from col to 0 
            for(let i = 0; i < moveOn.allSquares.length; i++){
                for (let j = 0; j < moveOn.allSquares[i].length; j++) {

                    if(moveOn.allSquares[i][j]){
                        rookMoves = 
                    }
                }
            }

            


            return null;
         }

}