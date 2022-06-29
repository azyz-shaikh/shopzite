import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/app/service/category.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  categories:any;

  constructor(private category: CategoryService) { }

  ngOnInit(): void {
    this.category.categories().subscribe((data:any)=>{

      this.categories=data;
    },
    (error)=>{
      Swal.fire("error loading data");
      
    })
  }

}
