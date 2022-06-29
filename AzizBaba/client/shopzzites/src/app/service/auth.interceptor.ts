import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HTTP_INTERCEPTORS } from "@angular/common/http";
//import { Token } from "@angular/compiler";
import { Injectable } from "@angular/core";
import { Router } from "@angular/router";
import { Observable, tap } from "rxjs";
import { LoginService } from "./login.service";




@Injectable()
export class AuthInterceptor implements HttpInterceptor
{
    constructor(private login:LoginService, private router:Router)
    {

    }
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
       


        const token= this.login.getToken();
        if (token != null) {
            const clonedReq = req.clone({
                headers: req.headers.set('Authorization', `Bearer ` + token)
            });
            return next.handle(clonedReq);
        }
        else {
            return next.handle(req.clone());
        }
    
}
}

export const authInterceptorProviders=[
    {
        provide:HTTP_INTERCEPTORS,
        useClass:AuthInterceptor,
        multi:true,
        
    },

];