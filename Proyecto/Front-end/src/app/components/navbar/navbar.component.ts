import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { Usuario } from '../../models/usuario';

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  private isLogged : boolean;
  private loggedUser : Usuario;

  constructor(private userService : UserService) { }

  ngOnInit() {
    let cookies : String[] = document.cookie.split(";");
    let token : string = "";
    this.isLogged = false;
    for(let cookie of cookies){
      if(cookie.includes("pepe_login")){
        token = cookie.substring(11);
      }
    token = token.trim().length == 0? "" : token.substring(36, token.length-36);
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

  logout(){
    if(this.isLogged){
      document.cookie = "pepe_login=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
      this.isLogged = false;
    }
  }

}
