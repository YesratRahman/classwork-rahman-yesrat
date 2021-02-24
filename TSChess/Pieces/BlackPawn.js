"use strict";
exports.__esModule = true;
exports.BlackPawn = void 0;
var Piece_1 = require("./Piece");
var BlackPawn = /** @class */ (function () {
    function BlackPawn() {
        this.kind = Piece_1.PieceType.Pawn;
        this.isWhite = false;
        this.generateMoves = function (moveOn, row, col) {
            var blackPawnMoves = [];
            return null;
        };
    }
    return BlackPawn;
}());
exports.BlackPawn = BlackPawn;
