import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Location } from '../../game/Location';

@Component({
  selector: 'app-square',
  templateUrl: './square.component.html',
  styleUrls: ['./square.component.css']
})
export class SquareComponent implements OnInit {

  @Output() squareClickedEvent: EventEmitter<Location> = new EventEmitter<Location>();

  @Input() piece: number = 0;
  imageSrc: string = "./assets/";
  @Input() row: number = 0;
  @Input() col: number = 0;

  constructor() { }

  ngOnInit(): void {
    if (this.piece === -1) {
      this.imageSrc += "X.png";
    }
    else if (this.piece === 1) {
      this.imageSrc += "O.png";
    }
    else {
      this.imageSrc += "Emp.png";
    }
  }

  squareClicked(): void {
    this.squareClickedEvent.emit(
      { row: this.row, col: this.col }
      );
  }

}
