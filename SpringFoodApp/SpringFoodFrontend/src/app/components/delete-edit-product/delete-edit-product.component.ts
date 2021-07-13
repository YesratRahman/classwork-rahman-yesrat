import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Product } from 'src/app/interfaces/Product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-delete-edit-product',
  templateUrl: './delete-edit-product.component.html',
  styleUrls: ['./delete-edit-product.component.css']
})
export class DeleteEditProductComponent implements OnInit {

  products : Product[] = []; 
  product! : Product ; 
  @Output() notifyDelete : EventEmitter<number> = new EventEmitter<number>(); 


  constructor(private productService : ProductService) { 
   
  }

  ngOnInit(): void {
    
      this.productService.getAllProducts().subscribe(proList => {
        this.products = proList; 
      })
    //   if(this.product.id == null || this.product.id == undefined){
    //     console.log("error"); 
    //   }
    //   else {
    //  this.productService.getProductById(this.product.id).subscribe(); 
    //   }
    
  }

  // deleteProduct(){
  //   if(this.product.id == null || this.product.id == undefined){
  //     console.log("error"); 
  //   }
  //   else {
  //     this.productService.deleteProduct(this.product.id).subscribe(() => {
  //       this.notifyDelete.emit(this.product.id); 
  //       console.log(this.product.id);
  
  //     }); 
  //   }
  deleteProduct(id: number) {
    this.productService.deleteProduct(id).subscribe(data => {
      this.productService.getAllProducts(); 
        })
    }
   
  
  
}
