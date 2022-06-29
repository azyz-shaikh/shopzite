import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { UserService } from 'src/app/service/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userService:UserService,private snack:MatSnackBar,private router:Router) { }

  public user={
    username:'',
    password:'',
    email:'',
  };

  error:any;
  ngOnInit(): void {
  }
  formSubmit()
  {
   console.log(this.user);
   if(this.user.username=='' || this.user.username==null)
  {
    //alert('user is required');
    this.snack.open("User Name is required ",'ok');
    return ;
  }


  this.userService.addUser(this.user).subscribe(
    (data)=>{
       console.log(data);
     Swal.fire('Success','user registraion successfull');
     this.router.navigate(['login']);

    },
    (error)=>{
      console.log("error");
      Swal.fire('user already exist');

    }


   
    
  );
  

  }
  }
  


