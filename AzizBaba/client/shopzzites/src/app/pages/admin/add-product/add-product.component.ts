import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { ProductServiceService } from 'src/app/product-service.service';
import { CategoryService } from 'src/app/service/category.service';
import Swal from 'sweetalert2';



@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
  categories:any =[] ;
  products:any[];
  productdata={

    pName:'',
  };
  categoryData={

	 pName:'',
	 pDesc:'',
	 pPrice:'',
	 pPhoto:'',
   category:{
     categoryId:'',
   },
  };

  

  constructor(private categoryservice:CategoryService,private productservice:ProductServiceService,private snack:MatSnackBar,private router:Router) { }

  ngOnInit(): void {


  
  

    this.categoryservice.categories().subscribe((data:any)=>
      {

        this.categories=data;
        console.log(this.categories);
      },
      (error)=>
      {
        console.log("error");
        Swal.fire("error loading data");
        
      });
      return;
    
      
  }

  

  submit()
  {
    if(this.categoryData.pDesc==""||this.categoryData.pName==""||this.categoryData.pPhoto==""||this.categoryData.pPrice=="")
    {
      this.snack.open("fields cannot be empty","ok");
      return;
    }

    
    

    this.productservice.addProduct(this.categoryData).subscribe((data)=>{
      Swal.fire("succesfully added product");
      console.log(this.categoryData);
      
       this.router.navigate(["/admin"])
    },
    (error)=>{
      Swal.fire("product already present");
    }
    );


   
  }
  

}


