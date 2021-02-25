import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'test-control',
  templateUrl: './test-control.component.html',
  styleUrls: ['./test-control.component.css']
})
export class TestControlComponent implements OnInit {

  imageSrc: string = "./assets/cat.png"
  defaultImage: boolean = true;

  constructor() { }

  ngOnInit(): void {
  }

  onClick(): void {
    this.defaultImage != this.defaultImage;
    if (!this.defaultImage) {
      this.imageSrc; 
    }
    else {
      this.imageSrc = "https://images-na.ssl-images-amazon.com/images/I/61Oh2US5ZuL._AC_SL1001_.jpg";
    }
  }

}
