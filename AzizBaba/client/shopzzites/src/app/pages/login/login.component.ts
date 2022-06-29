import { Token } from '@angular/compiler';
import { tokenize } from '@angular/compiler/src/ml_parser/lexer';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/service/login.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData={
    username:"",
    password:"",
  };
  constructor(private snack:MatSnackBar,private login:LoginService,private router:Router) { }

  ngOnInit(): void {
    
  }
  formSubmit()
  {
    
    console.log("login form submitted");

    if(this.loginData.username.trim()==''|| this.loginData.username==null)
    {

      this.snack.open("user-name is required!! ",'',{
        duration:3000,
      });
      return ;
    }

    if(this.loginData.password.trim()==''|| this.loginData.password==null)
    {

      this.snack.open("password is required!! ",'',{
        duration:3000,
      });
      return ;
    }
    //request server to generate token
    this.login.generateToken(this.loginData).subscribe((response:any)=>{
   
      console.log("success");
      console.log(response);
      this.login.loginUser(response.token);
     
      this.login.getCurrentUser().subscribe(
        (user:any)=>{
          this.login.setUser(user);
          console.log(user);
          //redirecr..admin/normal

          if(this.login.getUserRole()=="ADMIN")
          {

          //  this.login.loginStatusSubject.next(true);
            window.location.href="/admin";
           // this.router.navigate(['admin']);

          }
          else if(this.login.getUserRole()=="NORMAL")
          {
            //this.login.loginStatusSubject.next(true);
            window.location.href="/user-dashboard/0";
            //this.router.navigate(['user-dashboard']);

          }
          else
          {
            this.login.logout();
            location.reload();
          }
        }
      )

    },
    (error)=>{

      console.log("error");
      Swal.fire("user does not exist!!! register first");
    }
    
    );


  }

}
