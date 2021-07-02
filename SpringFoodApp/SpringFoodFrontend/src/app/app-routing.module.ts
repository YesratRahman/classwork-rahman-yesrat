import { NgModule } from "@angular/core";
import { ProductComponent } from "./components/product/product.component";
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from "./components/home/home.component";
import { AllProductsComponent } from "./components/all-products/all-products.component";
import { ContactComponent } from "./components/contact/contact.component";

const routes: Routes =[
    { path: '', redirectTo: 'home', pathMatch: 'full'},
    // { path: '', component: HomeComponent },
    { path: "products", component: ProductComponent } , 
    {path: "contact", component: ContactComponent}





]; 
@NgModule({
    imports: [ RouterModule.forRoot(routes) ],
    exports: [ RouterModule ]
  })
  export class AppRoutingModule {}