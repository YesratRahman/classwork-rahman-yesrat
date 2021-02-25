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
exports.BlackPawn = void 0;
var ChessPiece_1 = require("./ChessPiece");
var Piece_1 = require("./Piece");
var BlackPawn = /** @class */ (function (_super) {
    __extends(BlackPawn, _super);
    function BlackPawn() {
        var _this = _super.call(this, Piece_1.PieceType.Pawn, false) || this;
        _this.generateMoves = function (moveOn, loc) {
            var blackPawnMoves = [];
            //we'll generate 4 "position" objects that represent different directions the bishop might move
            //then try those one at a time and add the results
            var blackPawnDirections = [];
            blackPawnDirections.push({ row: -1, col: 0 });
            blackPawnDirections.push({ row: -2, col: 0 });
            blackPawnDirections.push({ row: -1, col: -1 });
            blackPawnDirections.push({ row: -1, col: 1 });
            var currentLoc = { row: loc.row + blackPawnDirections[0].row, col: loc.col + blackPawnDirections[0].col };
            while (BlackPawn.isOnBoard(currentLoc) && moveOn.pieceAt(currentLoc) === null) {
                if (BlackPawn.promotePiece(currentLoc)) {
                    blackPawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Knight });
                    blackPawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Bishop });
                    blackPawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Rook });
                    blackPawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Queen });
                }
                else {
                    blackPawnMoves.push({ from: loc, to: currentLoc });
                }
            }
            currentLoc = { row: loc.row + blackPawnDirections[1].row, col: loc.col + blackPawnDirections[1].col };
            while (BlackPawn.isOnBoard(currentLoc) && moveOn.pieceAt(currentLoc) === null) {
                if (BlackPawn.promotePiece(currentLoc)) {
                    blackPawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Knight });
                    blackPawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Bishop });
                    blackPawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Rook });
                    blackPawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Queen });
                }
                else {
                    blackPawnMoves.push({ from: loc, to: currentLoc });
                }
            }
            currentLoc = { row: loc.row + blackPawnDirections[2].row, col: loc.col + blackPawnDirections[2].col };
            while (BlackPawn.isOnBoard(currentLoc) && moveOn.pieceAt(currentLoc) === null) {
                if (BlackPawn.promotePiece(currentLoc)) {
                    blackPawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Knight });
                    blackPawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Bishop });
                    blackPawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Rook });
                    blackPawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Queen });
                }
                else {
                    blackPawnMoves.push({ from: loc, to: currentLoc });
                }
            }
            currentLoc = { row: loc.row + blackPawnDirections[3].row, col: loc.col + blackPawnDirections[3].col };
            while (BlackPawn.isOnBoard(currentLoc) && moveOn.pieceAt(currentLoc) === null) {
                if (BlackPawn.promotePiece(currentLoc)) {
                    blackPawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Knight });
                    blackPawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Bishop });
                    blackPawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Rook });
                    blackPawnMoves.push({ from: loc, to: currentLoc, promoteTo: Piece_1.PieceType.Queen });
                }
                else {
                    blackPawnMoves.push({ from: loc, to: currentLoc });
                }
            }
            //     allMoves.push( { from: loc, to: currentLoc  });
            //     currentLoc = { row: currentLoc.row + dir.row, col : currentLoc.col + dir.col };
            // });
            return blackPawnMoves;
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
    BlackPawn.isOnBoard = function (loc) {
        return loc.col >= 0 && loc.col < 8 && loc.row >= 0 && loc.row < 8;
    };
    BlackPawn.promotePiece = function (loc) {
        return loc.row == 7;
    };
    return BlackPawn;
}(ChessPiece_1.ChessPiece));
exports.BlackPawn = BlackPawn;
