"use strict";
exports.__esModule = true;
exports.Queen = void 0;
var Piece_1 = require("./Piece");
var Queen = /** @class */ (function () {
    function Queen(isWhite) {
        this.kind = Piece_1.PieceType.Queen;
        this.generateMoves = function (moveOn, row, col) {
            var queenMoves = [];
            return null;
        };
        this.isWhite = isWhite;
    }
    return Queen;
}());
exports.Queen = Queen;
