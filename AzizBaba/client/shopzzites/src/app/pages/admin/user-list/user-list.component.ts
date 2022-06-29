import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/service/login.service';
import { User } from '../../../service/user';
import { UserService } from '../../../service/user.service';


@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  user :User[];
  constructor(private userService:UserService,private router:Router,private login:LoginService) { }

  

  ngOnInit(): void {
  

    this.getallUser();


  }
  
  private getallUser()
  {
    this.userService.getallUser().subscribe(data =>{
      this.user=data;
    });
  }

  deleteUser(id:number)
  {
    this.userService.deleteUser(id).subscribe(data =>{
      console.log(data);
      this.getallUser();
    })
  } 
  }


