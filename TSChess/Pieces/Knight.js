"use strict";
exports.__esModule = true;
exports.Knight = void 0;
var Piece_1 = require("./Piece");
var Knight = /** @class */ (function () {
    function Knight(isWhite) {
        this.kind = Piece_1.PieceType.Knight;
        this.generateMoves = function (moveOn, row, col) {
            var knightMoves = [];
            return null;
        };
        this.isWhite = isWhite;
    }
    return Knight;
}());
exports.Knight = Knight;
