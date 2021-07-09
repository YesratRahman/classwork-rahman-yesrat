import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Order } from 'src/app/interfaces/Order';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {


order! : Order;
id : number = 0;

constructor(private productService : ProductService, private route : ActivatedRoute) {
  this.productService.getOrderById(this.id).subscribe(order => 
    this.order = order); 
    console.log(this.order);
 }

ngOnInit(): void {
  // 
  this.id = parseInt(this.route.snapshot.paramMap.get('id')!); 

}
} 