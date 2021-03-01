import { Component, OnInit } from '@angular/core';
import { Game, TTTGame } from '../../game/Game';
import { Location } from '../../game/Location';

@Component({
  selector: 'app-board',
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.css']
})
export class BoardComponent implements OnInit {
  game: Game = new TTTGame();
  winsO : number = 0; 
  winsX : number = 0; 
  draws : number = 0; 
  status: string = " ";

  constructor() { }

  ngOnInit(): void {
  }

  onSquareClicked(position: Location): void {
    this.game.makeMove(position);
    switch (this.game.gameStatus) {
      case 1:
        this.status = "Congrats, Player O wins!";
        this.winsO++; 
        break;
      case -1:
        this.status = "Congrats, Player X wins!";
        this.winsX++; 
        break;
      case 0:
        this.status = "A Draw!";
        this.draws++; 
        break;
    }
  }

  reset(): void {
    this.game = new TTTGame();
  }

}


