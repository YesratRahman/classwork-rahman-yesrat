import { NgModule } from "@angular/core";
import { ProductComponent } from "./components/product/product.component";
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from "./components/home/home.component";
import { AllProductsComponent } from "./components/all-products/all-products.component";
import { ContactComponent } from "./components/contact/contact.component";
import { CartPageComponent } from "./components/cart-page/cart-page.component";

const routes: Routes =[
    // { path: '', redirectTo: 'home', pathMatch: 'full'},
    { path: '', component: HomeComponent },
    { path: "allProducts", component: AllProductsComponent } , 
    {path: "contact", component: ContactComponent},
    {path: "search/:searchTerm", component: AllProductsComponent},
    {path: "product/:id", component: ProductComponent},
    {path: "cart-page", component: CartPageComponent}





]; 
@NgModule({
    imports: [ RouterModule.forRoot(routes) ],
    exports: [ RouterModule ]
  })
  export class AppRoutingModule {}