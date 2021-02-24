import { Board } from "../Board";
import { Move } from "../Move";
import { Piece, PieceType } from "./Piece";

export class WhitePawn implements Piece {

    kind : PieceType = PieceType.Pawn;

    isWhite : boolean = true;


    generateMoves: (moveOn: Board, row: number, col: number) => Move[] = 
         (moveOn: Board, row: number, col: number)  => {

            let pawnMoves : Move[]  = [];

            


            return null;
         }

}