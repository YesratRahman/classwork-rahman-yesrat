"use strict";
exports.__esModule = true;
exports.Bishop = void 0;
var Piece_1 = require("./Piece");
var Bishop = /** @class */ (function () {
    function Bishop(isWhite) {
        this.kind = Piece_1.PieceType.Bishop;
        this.generateMoves = function (moveOn, row, col) {
            var bishopMoves = [];
            return null;
        };
        this.isWhite = isWhite;
    }
    return Bishop;
}());
exports.Bishop = Bishop;
