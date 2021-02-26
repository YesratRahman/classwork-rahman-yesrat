import { Component, OnInit } from '@angular/core';
import { Game, TicTacToeGame } from '../Game';
import { Location } from '../Location';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.css']
})
export class BoardComponent implements OnInit {
  game: Game = new TicTacToeGame();
  status: string = "Welcome to the New Game";

  constructor() { }

  ngOnInit(): void {
  }

  onSquareClicked(pos: Location): void {
    this.game.makeMove(pos);
    switch (this.game.gameStatus) {
      case 1:
        this.status = "Congrats, Player O wins!";
        break;
      case -1:
        this.status = "Congrats, Player X wins!";
        break;
      case 0:
        this.status = "Draw!";
        break;
    }
  }

  reset(): void {
    this.game = new TicTacToeGame();
    this.status = "Welcome to the New Game";
  }

}
