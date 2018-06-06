import { Injectable } from '@angular/core';
import { Usuario } from '../models/usuario';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http : HttpClient) { }

  staticUrl:String = environment.baseApi + '/user/';
  
  login(user : Usuario) : Observable<Usuario>{
      return this.http.post<Usuario>(this.staticUrl + 'login', user);
    }

}
