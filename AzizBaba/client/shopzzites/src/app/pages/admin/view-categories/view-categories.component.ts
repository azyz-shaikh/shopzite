import { Component, OnInit } from '@angular/core';
import { category } from 'src/app/service/category';
import { CategoryService } from 'src/app/service/category.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-categories',
  templateUrl: './view-categories.component.html',
  styleUrls: ['./view-categories.component.css']
})
export class ViewCategoriesComponent implements OnInit {

  categories :category[] 
   
  constructor(private category:CategoryService,private categoryService:CategoryService) { }

  ngOnInit(): void {

   this.getallcategory();
  }

  getallcategory()
{
  this.category.categories().subscribe((data:any) =>{
    this.categories=data;
  });
  
}

deleteCategory(id:number)
  {
    this.categoryService.deleteCategory(id).subscribe((data) =>{
      console.log(data);
      this.getallcategory();
    },
    (error)=>{
      Swal.fire("first delete all the product realted to this category");
    });
  } 


}


