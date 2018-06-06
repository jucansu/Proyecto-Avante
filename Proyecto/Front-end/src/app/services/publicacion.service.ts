import { Injectable } from '@angular/core';
import { Publicacion } from '../models/publicacion';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PublicacionService {

  constructor(private http : HttpClient) { }

  staticUrl:String = environment.baseApi + '/publicacion/';

  getList() : Observable<Publicacion[]>{    
    return this.http.get<Publicacion[]>(this.staticUrl + 'list');
  }

  getUserList(userId : number) : Observable<Publicacion[]>{    
    return this.http.get<Publicacion[]>(this.staticUrl + 'list/'+userId);
  }

  get(publicacionId : number) : Observable<Publicacion>{    
    return this.http.get<Publicacion>(this.staticUrl + 'get/'+publicacionId);
  }

  post(publicacion : Publicacion) : Observable<Publicacion>{
    return this.http.post<Publicacion>(this.staticUrl + 'post', publicacion);
  }

  delete(publicacionId : number) : Observable<any>{      
    return this.http.get<any>(this.staticUrl + 'delete/'+publicacionId);
  }
}
