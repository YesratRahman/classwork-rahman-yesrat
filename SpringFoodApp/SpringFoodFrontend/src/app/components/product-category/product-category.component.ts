import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/interfaces/Product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-category',
  templateUrl: './product-category.component.html',
  styleUrls: ['./product-category.component.css']
})
export class ProductCategoryComponent implements OnInit {

  products : Product[] = []; 
  id : number = 0;
    constructor(private produtService : ProductService,private router: Router, private route : ActivatedRoute) {} 
    ngOnInit(): void {
      this.route.params.subscribe(paramType => {
        this.id = paramType.id;
      });
      
      this.produtService.getAllProductsByCategoryId(this.id).subscribe(product => {
        this.products = product;
        console.log(this.products)
      }); 
    }
  } 
