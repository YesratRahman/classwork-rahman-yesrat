import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from 'src/app/interfaces/Category';
import { Product } from 'src/app/interfaces/Product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
    name: string = ""; 
    price: number = 0;
    quantity: number = 0 ;
    image: string = "";
    description: string = "";
    // category : Category = {name : "", products : []}; 
    categories : Category[] = []; 
    // categoryId: number = 0; 
    @Input('ngModel') categoryId: number = 0;


  constructor(private productService : ProductService, private router : Router) { }

  ngOnInit(): void {
    this.productService.getAllCategories().subscribe(category => {
      this.categories = category; 
      console.log(this.categories);
    })
  }
  addProduct(){
    let toAdd: Product ={
      name :  this.name, 
      price : this.price, 
      quantity : this.quantity, 
      image : this.image,
      description : this.description, 
      // category : this.category,
      categoryId : this.categoryId


    }; 
    this.productService.addProduct(toAdd).subscribe((_) => {this.router.navigate(["/allProducts"])});
    console.log(toAdd);
  }
  onDropdownChange(e: number){
    console.log(e);//you will get the id  
    this.categoryId =e;  //if you want to bind it to your model
    console.log(e);
  }
  // getAllCategories(){
  //   this.productService.getAllCategories().subscribe(category => {
  //     this.categories = category; 
  //     console.log(this.categories);
  //   })
  // // })
  // }
}
