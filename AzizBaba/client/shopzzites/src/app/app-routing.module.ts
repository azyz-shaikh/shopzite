import { FullscreenOverlayContainer } from '@angular/cdk/overlay';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { SignupComponent } from './pages/signup/signup.component';
import { UserDashboardComponent } from './pages/user/user-dashboard/user-dashboard.component';
import { AdminGuard } from './service/admin.guard';
import { NormalGuard } from './service/normal.guard';
import { UserListComponent } from './pages/admin/user-list/user-list.component';
import { ViewCategoriesComponent } from './pages/admin/view-categories/view-categories.component';
import { AddCategoryComponent } from './pages/admin/add-category/add-category.component';
import { AddProductComponent } from './pages/admin/add-product/add-product.component';
import { ViewProductComponent } from './pages/admin/view-product/view-product.component';
import { LoadproductComponent } from './pages/user/loadproduct/loadproduct.component';
import { UpdateProductComponent } from './pages/admin/update-product/update-product.component';




const routes: Routes = [
  {
    path:'signup',component:SignupComponent,pathMatch:'full',
  },
  {
    path:'',component:HomeComponent,pathMatch:'full',
  },
  {
    path:'login',component:LoginComponent,pathMatch:'full',
  },
  {
    path:'admin',component:DashboardComponent,pathMatch:'full',
    canActivate:[AdminGuard],

  },

  {
    path:'viewproduct',component:ViewProductComponent,
   

  },

  {
    path:'categories',component:ViewCategoriesComponent,
  }
  ,
{
  path:'user-list',component:UserListComponent,
        pathMatch:"full"
},

{
  

  path:'update-product/:pId',component:UpdateProductComponent,
        pathMatch:"full"
},

  {
    path:'user-dashboard',component:UserDashboardComponent,
    canActivate:[NormalGuard],
    children:[
      {
        path:':catId',component:LoadproductComponent
      }
    ]

  },

  {
    path:'addcat',component:AddCategoryComponent,pathMatch:'full',
   

  },
  {
    path:'addproduct',component:AddProductComponent,pathMatch:'full',
   

  },
 
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
  
})
export class AppRoutingModule { }
