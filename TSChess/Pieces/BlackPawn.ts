import { Board } from "../Board";
import { Move } from "../Move";
import { Position } from "../Position";
import { ChessPiece } from "./ChessPiece";
import { PieceType } from "./Piece";

export class BlackPawn extends ChessPiece {
    constructor(){
        super( PieceType.Pawn, false);
    }

    generateMoves: (moveOn: Board, loc: Position) => Move[] = 
    (moveOn: Board, loc: Position)  => {
    
        let blackPawnMoves : Move[]  = [];

        //we'll generate 4 "position" objects that represent different directions the bishop might move
        //then try those one at a time and add the results

        let blackPawnDirections : Position[] = [];

        blackPawnDirections.push( {row : -1, col: 0} );
        blackPawnDirections.push( {row : -2 ,col: 0} );
        blackPawnDirections.push( {row : -1, col: -1} );
        blackPawnDirections.push( {row : -1, col: 1} );


        

        let currentLoc: Position = { row: loc.row + blackPawnDirections[0].row, col: loc.col + blackPawnDirections[0].col };

        while (BlackPawn.isOnBoard(currentLoc) && moveOn.pieceAt(currentLoc) === null) {
            if (BlackPawn.promotePiece(currentLoc)) {
                blackPawnMoves .push({ from: loc, to: currentLoc, promoteTo: PieceType.Knight });
                blackPawnMoves .push({ from: loc, to: currentLoc, promoteTo: PieceType.Bishop });
                blackPawnMoves .push({ from: loc, to: currentLoc, promoteTo: PieceType.Rook });
                blackPawnMoves .push({ from: loc, to: currentLoc, promoteTo: PieceType.Queen });

            }
            else {
                blackPawnMoves .push({ from: loc, to: currentLoc });
            }
        }
            currentLoc = { row: loc.row + blackPawnDirections[1].row, col: loc.col + blackPawnDirections[1].col };

            while (BlackPawn.isOnBoard(currentLoc) && moveOn.pieceAt(currentLoc) === null) {
                if (BlackPawn.promotePiece(currentLoc)) {
                    blackPawnMoves .push({ from: loc, to: currentLoc, promoteTo: PieceType.Knight });
                    blackPawnMoves .push({ from: loc, to: currentLoc, promoteTo: PieceType.Bishop });
                    blackPawnMoves .push({ from: loc, to: currentLoc, promoteTo: PieceType.Rook });
                    blackPawnMoves .push({ from: loc, to: currentLoc, promoteTo: PieceType.Queen });

                }
            
                else {
                    blackPawnMoves .push({ from: loc, to: currentLoc });
                }
            }
                currentLoc = { row: loc.row + blackPawnDirections[2].row, col: loc.col + blackPawnDirections[2].col };

                while (BlackPawn.isOnBoard(currentLoc) && moveOn.pieceAt(currentLoc) === null) {
                    if (BlackPawn.promotePiece(currentLoc)) {
                        blackPawnMoves .push({ from: loc, to: currentLoc, promoteTo: PieceType.Knight });
                        blackPawnMoves .push({ from: loc, to: currentLoc, promoteTo: PieceType.Bishop });
                        blackPawnMoves .push({ from: loc, to: currentLoc, promoteTo: PieceType.Rook });
                        blackPawnMoves .push({ from: loc, to: currentLoc, promoteTo: PieceType.Queen });

                    }
                    else {
                        blackPawnMoves .push({ from: loc, to: currentLoc });
                    }
                }
                    currentLoc = { row: loc.row + blackPawnDirections[3].row, col: loc.col + blackPawnDirections[3].col };

                    while (BlackPawn.isOnBoard(currentLoc) && moveOn.pieceAt(currentLoc) === null) {
                        if (BlackPawn.promotePiece(currentLoc)) {
                            blackPawnMoves .push({ from: loc, to: currentLoc, promoteTo: PieceType.Knight });
                            blackPawnMoves .push({ from: loc, to: currentLoc, promoteTo: PieceType.Bishop });
                            blackPawnMoves .push({ from: loc, to: currentLoc, promoteTo: PieceType.Rook });
                            blackPawnMoves .push({ from: loc, to: currentLoc, promoteTo: PieceType.Queen });

                        }
                        else {
                            blackPawnMoves .push({ from: loc, to: currentLoc });
                        }
                    }
                        //     allMoves.push( { from: loc, to: currentLoc  });
                        //     currentLoc = { row: currentLoc.row + dir.row, col : currentLoc.col + dir.col };
                        // });
                    


                    return blackPawnMoves ;

                };



// static slidePiece: (moveOn : Board, loc : Position, dir : Position, isWhite : boolean ) =>  Move[] = 
//     ( moveOn : Board, loc : Position, dir : Position, isWhite: boolean ) : Move[] => {

//         let allMoves : Move[] = [];

//         let currentLoc : Position = { row : loc.row + dir.row, col : loc.col + dir.col };

//         while( WhitePawn.isOnBoard( currentLoc ) && moveOn.pieceAt(currentLoc) === null ){
//             allMoves.push( { from: loc, to: currentLoc  });
//             currentLoc = { row: currentLoc.row + dir.row, col : currentLoc.col + dir.col };
//         }

//         if( WhitePawn.isOnBoard( currentLoc )){
//             if( moveOn.pieceAt(currentLoc).isWhite != isWhite  ){
//                 allMoves.push( {from: loc, to: currentLoc});
//             }
//         }

//         return allMoves;
//     }
        

static isOnBoard(loc: Position): boolean {
    return loc.col >= 0 && loc.col < 8 && loc.row >= 0 && loc.row < 8;
}

static promotePiece(loc: Position): boolean {
    return loc.row == 7;
}

}