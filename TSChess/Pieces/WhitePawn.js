"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
exports.__esModule = true;
exports.WhitePawn = void 0;
var ChessPiece_1 = require("./ChessPiece");
var Piece_1 = require("./Piece");
var WhitePawn = /** @class */ (function (_super) {
    __extends(WhitePawn, _super);
    function WhitePawn() {
        var _this = _super.call(this, Piece_1.PieceType.Pawn, true) || this;
        _this.generateMoves = function (moveOn, loc) {
            var whitePawnMoves = [];
            //we'll generate 4 "position" objects that represent different directions the bishop might move
            //then try those one at a time and add the results
            var whitePawnDirections = [];
            whitePawnDirections.push({ row: 1, col: 0 });
            whitePawnDirections.push({ row: 2, col: 0 });
            whitePawnDirections.push({ row: 1, col: 1 });
            whitePawnDirections.push({ row: 1, col: -1 });
            // for( let direction of whitePawnDirections  ){
            //     let directionMoves : Move[] = WhitePawn .slidePiece( moveOn, loc, direction, this.isWhite );
            //     blackPawnMoves.push( ...directionMoves );
            // }
            var currentLoc = { row: loc.row + whitePawnDirections[0].row, col: loc.col + whitePawnDirections[0].col };
            while (WhitePawn.isOnBoard(currentLoc) && moveOn.pieceAt(currentLoc) === null && moveOn.enPassantCaptureLoc == currentLoc) {
                if (WhitePawn.promotePiece(currentLoc)) {
                    whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Knight });
                    whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Bishop });
                    whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Rook });
                    whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Queen });
                }
                else {
                    whitePawnMoves.push({ from: loc, to: currentLoc });
                }
            }
            currentLoc = { row: loc.row + whitePawnDirections[1].row, col: loc.col + whitePawnDirections[1].col };
            while (WhitePawn.isOnBoard(currentLoc) && moveOn.pieceAt(currentLoc) === null && moveOn.enPassantCaptureLoc == currentLoc
                && moveOn.allSquares[currentLoc.row][currentLoc.col].isWhite) {
                if (WhitePawn.promotePiece(currentLoc)) {
                    whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Knight });
                    whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Bishop });
                    whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Rook });
                    whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Queen });
                }
                else {
                    whitePawnMoves.push({ from: loc, to: currentLoc });
                }
            }
            currentLoc = { row: loc.row + whitePawnDirections[2].row, col: loc.col + whitePawnDirections[2].col };
            while (WhitePawn.isOnBoard(currentLoc) && moveOn.pieceAt(currentLoc) === null && moveOn.enPassantCaptureLoc == currentLoc && moveOn.allSquares[currentLoc.row][currentLoc.col].isWhite) {
                if (WhitePawn.promotePiece(currentLoc)) {
                    whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Knight });
                    whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Bishop });
                    whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Rook });
                    whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Queen });
                }
                else {
                    whitePawnMoves.push({ from: loc, to: currentLoc });
                }
            }
            currentLoc = { row: loc.row + whitePawnDirections[3].row, col: loc.col + whitePawnDirections[3].col };
            while (WhitePawn.isOnBoard(currentLoc) && moveOn.pieceAt(currentLoc) === null && moveOn.enPassantCaptureLoc == currentLoc && moveOn.allSquares[currentLoc.row][currentLoc.col].isWhite) {
                if (WhitePawn.promotePiece(currentLoc)) {
                    whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Knight });
                    whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Bishop });
                    whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Rook });
                    whitePawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Queen });
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
        return _this;
    }
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
    WhitePawn.isOnBoard = function (loc) {
        return loc.col >= 0 && loc.col < 8 && loc.row >= 0 && loc.row < 8;
    };
    WhitePawn.promotePiece = function (loc) {
        return loc.row == 7;
    };
    return WhitePawn;
}(ChessPiece_1.ChessPiece));
exports.WhitePawn = WhitePawn;
