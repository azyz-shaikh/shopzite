import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import baseUrl from './helper';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }

  //add user
  public addUser(user:any)
  {
    return this.http.post(`${baseUrl}/user/`,user);

  }

  getallUser():Observable<User[]>{
    return this.http.get<User[]>(`${baseUrl}/user/getall`,);

  }


  deleteUser(id :number):Observable<Object>{
    return this.http.delete(`${baseUrl}/user/` + id);
  }


  

}
