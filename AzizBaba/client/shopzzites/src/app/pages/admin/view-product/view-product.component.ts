import { Component, OnInit } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { ProductServiceService } from 'src/app/product-service.service';
import { category } from 'src/app/service/category';
import { CategoryService } from 'src/app/service/category.service';
import { products } from 'src/app/service/product';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-product',
  templateUrl: './view-product.component.html',
  styleUrls: ['./view-product.component.css']
})
export class ViewProductComponent implements OnInit {

products:products[];
category:category[];
  pName: string;

  constructor(private productservice:ProductServiceService,private router:Router ) { }

  ngOnInit(): void {

    this.productservice.getallproducts().subscribe((data:any)=>{
      this.products=data;
      console.log(this.products);
      
    },
    );
  }
  getallproducts()
  {
    this.productservice.getallproducts().subscribe((data:any) =>{
      this.products=data;
    });

  }

  deleteProduct(Pid:number)
  {
    this.productservice.deleteProduct(Pid).subscribe(data =>{
      console.log(data);
      this.getallproducts();
    });
  } 

  updateProduct(Pid:number)
  {

    this.router.navigate(['update-product',Pid]);
   

  }



}
