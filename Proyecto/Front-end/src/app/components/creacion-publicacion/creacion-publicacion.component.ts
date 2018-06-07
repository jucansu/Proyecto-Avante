import { Component, OnInit } from '@angular/core';
import { Publicacion } from '../../models/publicacion';
import { PublicacionService } from '../../services/publicacion.service';
import { UserService } from '../../services/user.service';
import { Usuario } from '../../models/usuario';
import { Router } from '@angular/router';

@Component({
  selector: 'creacion-publicacion',
  templateUrl: './creacion-publicacion.component.html',
  styleUrls: ['./creacion-publicacion.component.css']
})
export class CreacionPublicacionComponent implements OnInit {

  private isLogged : boolean;
  private loggedUser : Usuario;

  constructor(private publicacionService : PublicacionService,
    private userService : UserService,
    private router : Router) { }

  ngOnInit() {
    let cookies : String[] = document.cookie.split(";");
    let token : string = "";
    this.isLogged = false;
    for(let cookie of cookies){
      if(cookie.includes("pepe_login")){
        token = cookie.substring(11);
        break;
      }
    }
    token = !token || token.trim().length == 0? "" : token.substring(36, token.length-36);
    if(token == ""){      
      this.router.navigate(['/']);
    }
    try{
      var id : number= Number.parseInt(token);
      this.userService.getUser(id).subscribe(user => {
        this.loggedUser = user;
        this.isLogged = true;
      });
    } catch {
      this.isLogged = false; 
    }
  }

  onSubmit(publicacionForm){
    var publicacion = new Publicacion(0, publicacionForm.titulo, 
      publicacionForm.descripcion, publicacionForm.etiqueta, new Date(), 0, this.loggedUser.id);
    this.publicacionService.post(publicacion).subscribe(publicacion => {
      if(publicacion.id && publicacion.id != 0){
        this.router.navigate(["/detalle/"+publicacion.id]);
      }
    });
  }

}
