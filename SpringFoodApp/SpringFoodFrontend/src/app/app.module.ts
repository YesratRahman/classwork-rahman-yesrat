import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { AllProductsComponent } from './components/all-products/all-products.component';
import { HomeComponent } from './components/home/home.component';
import { ProductComponent } from './components/product/product.component';
import {MatToolbarModule} from '@angular/material/toolbar'; 
import {MatIconModule} from '@angular/material/icon';
import {MatSidenavModule} from '@angular/material/sidenav';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ContactComponent } from './components/contact/contact.component';
import { FooterComponent } from './components/footer/footer.component';
import { ThankyouComponent } from './components/thankyou/thankyou.component';
import { CartPageComponent } from './components/cart-page/cart-page.component';
import { HeaderComponent } from './components/header/header.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ProductComponent,
    AllProductsComponent,
    ContactComponent,
    FooterComponent,
    ThankyouComponent,
    HeaderComponent,
    CartPageComponent  ],
  imports: [
    BrowserModule,
    AppRoutingModule, 
    HttpClientModule,
    MatToolbarModule,
    MatIconModule,
    MatSidenavModule,
    BrowserAnimationsModule


  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
