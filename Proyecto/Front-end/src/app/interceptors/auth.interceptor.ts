import { Injectable } from '@angular/core';
import {catchError} from "rxjs/internal/operators";
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpErrorResponse,
  HttpResponse
} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { Router } from '@angular/router';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private router:Router) {}
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let cookies : String[] = document.cookie.split(";");
    let token : string = "";
    for(let cookie of cookies){
      if(cookie.includes("pepe_login")){
        token = cookie.substring(11);
      }
    }
    const authReq = request.clone({
      setHeaders: {
        Authorization: token
      }
    });
    return next.handle(authReq).pipe(
      catchError(err => {
        if(err.status === 401 ){
            this.router.navigate(["/"]);
        }
        throw(err);
        }));

  }
}