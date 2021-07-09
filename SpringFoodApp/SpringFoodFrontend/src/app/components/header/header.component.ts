import { Component, EventEmitter, OnInit } from '@angular/core';
import { CartService } from 'src/app/services/cart.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  count : number = this.cartService.getCart().items.length;

  constructor(private cartService:  CartService) { }

  ngOnInit(): void {
    
  }

}
