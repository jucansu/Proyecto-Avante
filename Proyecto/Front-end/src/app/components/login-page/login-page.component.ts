import { Component, OnInit } from '@angular/core';
import { Usuario } from '../../models/usuario';
import { UserService } from '../../services/user.service';
import { PublicacionService } from '../../services/publicacion.service';
import { Publicacion } from '../../models/publicacion';

@Component({
  selector: 'login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {
  constructor(private userService : UserService,
    private publicacionService : PublicacionService) { }

  ngOnInit() {
  }

  onSubmit(userForm){    
    var usuario = new Usuario();
    usuario.email = userForm.email;
    usuario.contraseña = userForm.contraseña;
    this.userService.login(usuario).subscribe(user => {
      this.setCookie("pepe_login", user.token, 1);
      if(user.token && user.token != ""){
        location.reload();
      }
    });
  }

  delete(){
      this.publicacionService.delete(9).subscribe();
  }

  setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
  }
}
