"use strict";
exports.__esModule = true;
exports.WhitePawn = void 0;
var Piece_1 = require("./Piece");
var WhitePawn = /** @class */ (function () {
    function WhitePawn() {
        this.kind = Piece_1.PieceType.Pawn;
        this.isWhite = true;
        this.generateMoves = function (moveOn, row, col) {
            var pawnMoves = [];
            return null;
        };
    }
    return WhitePawn;
}());
exports.WhitePawn = WhitePawn;
