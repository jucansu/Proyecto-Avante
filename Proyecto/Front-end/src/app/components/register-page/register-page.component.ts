import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { Usuario } from '../../models/usuario';

@Component({
  selector: 'register-page',
  templateUrl: './register-page.component.html',
  styleUrls: ['./register-page.component.css']
})
export class RegisterPageComponent implements OnInit {

  constructor(private userService : UserService) { }

  ngOnInit() {
  }

  onSubmit(userForm){
    var usuario = new Usuario();
    usuario.id = 0;
    usuario.nombre = userForm.nombre;
    usuario.apellidos = userForm.apellidos;
    usuario.contraseña = userForm.contraseña;
    usuario.email = userForm.email;
    usuario.avatar = userForm.avatar;
    usuario.rol = "USUARIO";
    usuario.mensajeBaneo = "";
    usuario.estado = "NO_SUSCRITO";

    this.userService.register(usuario).subscribe(user => {
      this.userService.login(user).subscribe(logged => {
        this.setCookie("pepe_login", logged.token, 1);
        if(logged.token && logged.token != ""){          
          location.reload();
        }
      });  
    });
  }

  setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
  }

}
