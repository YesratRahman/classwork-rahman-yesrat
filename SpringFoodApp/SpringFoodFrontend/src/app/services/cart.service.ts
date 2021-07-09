import { Injectable } from '@angular/core';
import { Cart } from '../interfaces/Cart';
import { CartProduct } from '../interfaces/CartProduct';
import { Product } from '../interfaces/Product';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  
  private cart:Cart = new Cart(); 

   addToCart(product: Product):void{
    let cartItem = this.cart.items.find(item => item.product.id === product.id);
    if(cartItem){
      this.changeQuantity(product.id, cartItem.quantity + 1);
      return;
    }
    this.cart.items.push(new CartProduct(product));
  }

  removeFromCart(productId:number | undefined): void{
    this.cart.items = this.cart.items.filter(item => item.product.id != productId);
  }

  changeQuantity(productId:number | undefined, quantity:number){
    let cartItem = this.cart.items.find(item => item.product.id === productId);
    if(!cartItem) return;
    cartItem.quantity = quantity;
  }

  getCart():Cart{
    return this.cart;
  }
}