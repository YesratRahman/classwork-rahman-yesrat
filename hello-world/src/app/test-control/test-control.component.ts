import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'test-control',
  templateUrl: './test-control.component.html',
  styleUrls: ['./test-control.component.css']
})
export class TestControlComponent implements OnInit {

  defaultImage: boolean = true;
  constructor() { }

  ngOnInit(): void {
  }

  imageSrc: string = "https://icatcare.org/app/uploads/2018/07/Thinking-of-getting-a-cat.png";

  onClick(): void {
    this.defaultImage = !this.defaultImage;
    if (this.defaultImage) {
      this.imageSrc = "https://icatcare.org/app/uploads/2018/07/Thinking-of-getting-a-cat.png";
    } else {
      this.imageSrc = "https://steemitimages.com/1280x0/https://s3.us-east-2.amazonaws.com/partiko.io/img/roger5120-blonde-cat-having-fun--1-r4fgqeiq-1537049986376.png";
    }
  }
}
