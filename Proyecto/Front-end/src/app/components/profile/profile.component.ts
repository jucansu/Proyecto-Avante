import { Component, OnInit } from '@angular/core';
import { Usuario } from '../../models/usuario';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  private isLogged : boolean;
  private loggedUser : Usuario = new Usuario();

  constructor(private userService : UserService,
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

}
