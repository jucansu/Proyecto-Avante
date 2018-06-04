import { Injectable } from '@angular/core';
import { Usuario } from '../models/usuario';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(pri) { }
  
  login(user : Usuario) : Observable<string>{
      // return this.http.post<Usuario>('/services/', user);
      return null;
    }

}
