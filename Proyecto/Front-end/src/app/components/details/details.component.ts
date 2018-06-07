import { Component, OnInit } from '@angular/core';
import { Publicacion } from '../../models/publicacion';
import { PublicacionService } from '../../services/publicacion.service';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from '../../services/user.service';
import { Usuario } from '../../models/usuario';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

  private publicacion : Publicacion = new Publicacion(0, "", "", "", new Date(), 0, 0);
  private usuario : Usuario = new Usuario();

  constructor(private publicacionService : PublicacionService,
    private userService : UserService,
    private route : ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      var id = +params['id'];
      this.publicacionService.get(id).subscribe(pub => {
        this.publicacion = pub;
        this.userService.getUser(this.publicacion.id_usuario).subscribe(user =>{
          this.usuario = user;
        });
      });
    });
  }

}
