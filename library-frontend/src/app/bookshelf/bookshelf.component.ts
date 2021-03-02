import { Component, OnInit } from '@angular/core';
import { Book } from '../Book';
import { LibraryService } from '../library.service';

@Component({
  selector: 'app-bookshelf',
  templateUrl: './bookshelf.component.html',
  styleUrls: ['./bookshelf.component.css']
})
export class BookshelfComponent implements OnInit {

  books : Book[];

  constructor(private libService : LibraryService) { 
  }

  ngOnInit(): void {
    this.libService.getAllBooks().subscribe(list => {
      this.books = list
    });
  }

}
