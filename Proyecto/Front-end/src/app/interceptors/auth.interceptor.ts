import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpErrorResponse,
  HttpResponse
} from '@angular/common/http';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/catch';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor() {}
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let token = ""; //leo de la cookie el token
    const authReq = request.clone({
      setHeaders: {
        Authorization: `Bearer ` +token
      }
    });
    return next.handle(authReq)
    //   .catch(err => { 
    //     console.log('Caught error', err);
    //     return Observable.throw(err);
    //   });
  }
}