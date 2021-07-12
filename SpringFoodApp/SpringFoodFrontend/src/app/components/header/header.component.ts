import { Component, EventEmitter, OnInit } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  // count : number = this.cartService.getCart().items.length;
  // totalItem: unknown;
  totalItem = 0;
  constructor(private cartService:  CartService) { }

  ngOnInit(): void {
    this.cartService.getCount().subscribe(count => {
      
      console.log(count); 
      this.totalItem = count;
      }
    );
  }

}
