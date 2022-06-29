import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { category } from './category';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http:HttpClient) { }

  //load all category
  public categories():Observable<category[]>{
    return this.http.get<category[]>(`${baseUrl}/category/getcat/`);

  }

  //add category

  public addCategory(category:any)
  {
    return this.http.post(`${baseUrl}/category/`,category);

  }

  deleteCategory(id :number):Observable<Object>{
    return this.http.delete(`${baseUrl}/category/` + id);
  }

}
