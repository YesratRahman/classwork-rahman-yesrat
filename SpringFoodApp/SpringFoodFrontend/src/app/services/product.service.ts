import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Product } from '../interfaces/Product';
import {Observable, of} from 'rxjs';
import { tap, catchError } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class ProductService {
  baseUrl: string = "https://localhost:44349/api";
  httpOptions ={
    headers: new HttpHeaders(
    {
      "Content-Type": "application/json"
    }
      ) 
  }

  constructor(private http: HttpClient) { }
  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.baseUrl + "/product", this.httpOptions)
      .pipe(
        tap(x => console.log(x)),
        catchError(err => {
          console.log(err);
          let empty: Product[] = [];
          return of(empty);
        })
      );
  }

}
