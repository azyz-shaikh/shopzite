import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import baseUrl from './service/helper';
import { products } from './service/product';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  constructor(private http:HttpClient) { }


  public getallproducts()
  {
    return this.http.get(`${baseUrl}/product/`);
  }

  public addProduct(product:any)
  {
    return this.http.post(`${baseUrl}/product/`,product);

  }

  
  deleteProduct(id :number):Observable<Object>{
    return this.http.delete(`${baseUrl}/product/` + id);
  }


   //getproductbased on category

   public getproductcategory(categoryId:any)
   {
     return this.http.get(`${baseUrl}/product/category/${categoryId}`);
   }

   //update
   updateProduct(pId:number,product:products):Observable<Object>
{
  return this.http.put(`${baseUrl}/product/`,product);

}

//getbyid

getProductById(pId:number):Observable<products>{
  return this.http.get<products>(`${baseUrl}/product/${pId}`);
}

}
