"use strict";
exports.__esModule = true;
exports.Rook = void 0;
var Piece_1 = require("./Piece");
var Rook = /** @class */ (function () {
    function Rook(isWhite) {
        this.kind = Piece_1.PieceType.Rook;
        this.generateMoves = function (moveOn, row, col) {
            var rookMoves = [];
            return null;
        };
        this.isWhite = isWhite;
    }
    return Rook;
}());
exports.Rook = Rook;
