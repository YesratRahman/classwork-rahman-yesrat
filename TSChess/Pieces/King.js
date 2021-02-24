"use strict";
exports.__esModule = true;
exports.King = void 0;
var Piece_1 = require("./Piece");
var King = /** @class */ (function () {
    function King(isWhite) {
        this.kind = Piece_1.PieceType.King;
        this.generateMoves = function (moveOn, row, col) {
            var kingMoves = [];
            return null;
        };
        this.isWhite = isWhite;
    }
    return King;
}());
exports.King = King;
