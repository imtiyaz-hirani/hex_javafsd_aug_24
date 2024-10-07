import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from '../model/product';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  

  constructor(private http: HttpClient) { }

  addProduct(obj: Product) : Observable<Product>{
    return this.http.post<Product>('http://localhost:8082/product/add', obj)
  }

  uploadImage(formData: FormData, id: any) {
     return this.http.post('http://localhost:8082/product/image/upload/' + id, formData)
  }
}
