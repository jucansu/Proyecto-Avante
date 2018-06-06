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

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor() {}
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let cookies : String[] = document.cookie.split(";");
    let token : string = "";
    for(let cookie of cookies){
      if(cookie.includes("pepe_login")){
        token = cookie.substring(11);
        console.log("token aas",token);
      }
    }
    const authReq = request.clone({
      setHeaders: {
        Authorization: token
      }
    });
    return next.handle(authReq).pipe(
      catchError(err => err.code === 401 
        ? throwError("Unauthorized operation")
        : throwError(err)));
  }
}