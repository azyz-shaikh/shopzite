import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductServiceService } from 'src/app/product-service.service';
import { products } from 'src/app/service/product';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {
  pId:number;
  product:products= new products() ;

  constructor(private productservice:ProductServiceService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {

    this.pId= this.route.snapshot.params['pId'];
    this.productservice.getProductById(this.pId).subscribe((data)=>{
      console.log(data);
      this.product=data;
    },
    (error)=>{
      console.log(error);
    });
  }

  onsubmit()
  {
    this.productservice.updateProduct(this.pId,this.product).subscribe((data) =>{
      Swal.fire("succesfully updated");
      this.router.navigate(["/viewproduct"]);
    },
    (error)=>{
      Swal.fire("error updatig data");
    });

  }

}
