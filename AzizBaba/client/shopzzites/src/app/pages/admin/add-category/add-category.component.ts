import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { category } from 'src/app/service/category';
import { CategoryService } from 'src/app/service/category.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent implements OnInit {

 
  public category={
    categoryTitle:'',
    categoryDescription:'',
  };

  constructor(private snack:MatSnackBar,private categoryService:CategoryService,private router:Router) { }

  ngOnInit(): void {
  }

  formSubmit()
  {
    

    if(this.category.categoryTitle==""||this.category.categoryTitle=="")
    {
      this.snack.open("field should not be empty ","ok");
      return;
    }
    this.categoryService.addCategory(this.category).subscribe((data)=>{

      Swal.fire("succesfully added category");
    },
    (error)=>{
      console.log(error);

      Swal.fire("category with this name already exist");

    });

  }

  

}
