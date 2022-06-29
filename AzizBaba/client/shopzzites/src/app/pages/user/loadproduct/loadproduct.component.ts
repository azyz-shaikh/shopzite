import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductServiceService } from 'src/app/product-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-loadproduct',
  templateUrl: './loadproduct.component.html',
  styleUrls: ['./loadproduct.component.css']
})
export class LoadproductComponent implements OnInit {

  catId: any;
  products:any;
  constructor(private route:ActivatedRoute,private product:ProductServiceService) { }

  ngOnInit(): void {
   //this.catId= this.route.snapshot.params['catId'];
   this.route.params.subscribe((params)=>{
     this.catId=params['catId'];

     if(this.catId==0)
   {
     console.log("load all the product");
     this.product.getallproducts().subscribe((data=>{

      this.products=data;
      console.log(this.products);

     }),
     (error)=>{
       console.log(error);
       Swal.fire("eror");

     });
   }
   else
   {
     console.log("load specific products");
     this.product.getproductcategory(this.catId).subscribe((data)=>{
       this.products=data;
     },
     (error)=>{
       Swal.fire("error");

     })
     
   }
     

   })
   
  }

}
