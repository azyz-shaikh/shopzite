import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import baseUrl from './helper';


@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  constructor(private http:HttpClient) { }


  public addProduct(product:any)
  {
    return this.http.post(`${baseUrl}/product/`,product);

  }

  public deleteProduct(pId :number):Observable<Object>{
    return this.http.delete(`${baseUrl}/product/` + pId);
  }




 
}
