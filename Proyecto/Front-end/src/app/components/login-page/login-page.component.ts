import { Component, OnInit } from '@angular/core';
import { Usuario } from '../../models/usuario';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(private userService : UserService) { }

  ngOnInit() {
  }

  onSubmit(userForm){
    var usuario = new Usuario(null, null, 
    null, userForm.contraseña, userForm.email, null, null, null, null);
    //this.userService.login(usuario);
    
  }

}
