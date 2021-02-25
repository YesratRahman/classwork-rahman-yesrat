import { sequence } from '@angular/animations';
import { Component, Input, OnInit } from '@angular/core';
import { Bishop } from '../chess/Pieces/Bishop';
import { Piece, PieceType } from '../chess/Pieces/Piece';

@Component({
  selector: 'app-chess-square',
  templateUrl: './chess-square.component.html',
  styleUrls: ['./chess-square.component.css']
})
export class ChessSquareComponent implements OnInit {

  @Input()squarePiece: Piece = new Bishop(true);
  imageSrc: string = "./assets/";
  @Input()row : number = 0; 
  @Input() col : number = 7; 
  isLightSquare : boolean = true; 

  constructor() {

  }

  ngOnInit(): void {
    if(this.squarePiece == null){
      this.imageSrc = ""; 
    }
    else {

    
    this.imageSrc += this.squarePiece.isWhite ? "w" : "b";
    switch (this.squarePiece.kind) {
      case PieceType.Bishop: this.imageSrc += "B"; break;
      case PieceType.Knight: this.imageSrc += "N"; break;
      case PieceType.King: this.imageSrc += "K"; break;
      case PieceType.Queen: this.imageSrc += "Q"; break;
      case PieceType.Pawn: this.imageSrc += "P"; break;
      case PieceType.Rook: this.imageSrc += "R"; break;

    }

    this.imageSrc += ".png"; 
  } 
    this.isLightSquare =(this.row + this.col) %2 === 0; 
   
  }

}
