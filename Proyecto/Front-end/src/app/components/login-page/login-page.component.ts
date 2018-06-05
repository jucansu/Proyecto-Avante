import { Component, OnInit } from '@angular/core';
import { Usuario } from '../../models/usuario';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(private userService : UserService) { }

  ngOnInit() {
  }

  onSubmit(userForm){
    var usuario = new Usuario();
    usuario.email = userForm.email;
    usuario.contraseña = userForm.contraseña;
    this.userService.login(usuario).subscribe(user => {
      this.setCookie("pepe_login", user.token, 1);
    });
  }

  setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";path=/";
  }
}
