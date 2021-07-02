import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/interfaces/Product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  products : Product[] = []; 

  constructor(private produtService : ProductService, private router: Router, private route : ActivatedRoute) { }

  ngOnInit(): void {
    this.produtService.getAllProducts().subscribe(proList => {
      console.log(proList);
      this.products = proList; 
    })
  }
  

}
