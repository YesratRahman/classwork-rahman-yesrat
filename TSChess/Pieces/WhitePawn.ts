import { Board } from "../Board";
import { Move } from "../Move";
import { Position } from "../Position";
import { ChessPiece } from "./ChessPiece";
import { PieceType } from "./Piece";

export class WhitePawn extends ChessPiece {

    constructor() {
        super(PieceType.Pawn, true);
    }

    generateMoves: (moveOn: Board, loc: Position) => Move[] =
        (moveOn: Board, loc: Position) => {

            let whitePawnMoves: Move[] = [];

            //we'll generate 4 "position" objects that represent different directions the bishop might move
            //then try those one at a time and add the results

            let whitePawnDirections: Position[] = [];

            whitePawnDirections.push({ row: 1, col: 0 });
            whitePawnDirections.push({ row: 2, col: 0 });
            whitePawnDirections.push({ row: 1, col: 1 });
            whitePawnDirections.push({ row: 1, col: -1 });

            // for( let direction of whitePawnDirections  ){
            //     let directionMoves : Move[] = WhitePawn .slidePiece( moveOn, loc, direction, this.isWhite );
            //     blackPawnMoves.push( ...directionMoves );
            // }

            let currentLoc: Position = { row: loc.row + whitePawnDirections[0].row, col: loc.col + whitePawnDirections[0].col };

            while (WhitePawn.isOnBoard(currentLoc) && moveOn.pieceAt(currentLoc) === null && moveOn.enPassantCaptureLoc==currentLoc) {
                if (WhitePawn.promotePiece(currentLoc)) {
                    whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: PieceType.Knight});
                    whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: PieceType.Bishop });
                    whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: PieceType.Rook });
                    whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: PieceType.Queen });

                }
                else {
                    whitePawnMoves.push({ from: loc, to: currentLoc });
                }
            }
                currentLoc = { row: loc.row + whitePawnDirections[1].row, col: loc.col + whitePawnDirections[1].col };

                while (WhitePawn.isOnBoard(currentLoc) && moveOn.pieceAt(currentLoc) === null && moveOn.enPassantCaptureLoc==currentLoc 
                 && moveOn.allSquares[currentLoc.row][currentLoc.col].isWhite){
                    if (WhitePawn.promotePiece(currentLoc)) {
                        whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: PieceType.Knight });
                        whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: PieceType.Bishop });
                        whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: PieceType.Rook });
                        whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: PieceType.Queen });

                    }
                
                    else {
                        whitePawnMoves.push({ from: loc, to: currentLoc });
                    }
                }
                    currentLoc = { row: loc.row + whitePawnDirections[2].row, col: loc.col + whitePawnDirections[2].col };

                    while (WhitePawn.isOnBoard(currentLoc) && moveOn.pieceAt(currentLoc) === null && moveOn.enPassantCaptureLoc==currentLoc && moveOn.allSquares[currentLoc.row][currentLoc.col].isWhite) {
                        if (WhitePawn.promotePiece(currentLoc)) {
                            whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: PieceType.Knight });
                            whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: PieceType.Bishop });
                            whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: PieceType.Rook });
                            whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: PieceType.Queen });

                        }
                        else {
                            whitePawnMoves.push({ from: loc, to: currentLoc });
                        }
                    }
                        currentLoc = { row: loc.row + whitePawnDirections[3].row, col: loc.col + whitePawnDirections[3].col };

                        while (WhitePawn.isOnBoard(currentLoc) && moveOn.pieceAt(currentLoc) === null && moveOn.enPassantCaptureLoc==currentLoc  && moveOn.allSquares[currentLoc.row][currentLoc.col].isWhite) {
                            if (WhitePawn.promotePiece(currentLoc)) {
                                whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: PieceType.Knight });
                                whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: PieceType.Bishop });
                                whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: PieceType.Rook });
                                whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: PieceType.Queen });

                            }
                            else {
                                whitePawnMoves.push({ from: loc, to: currentLoc });
                            }
                        }
                            //     allMoves.push( { from: loc, to: currentLoc  });
                            //     currentLoc = { row: currentLoc.row + dir.row, col : currentLoc.col + dir.col };
                            // });
                        


                        return whitePawnMoves;

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


