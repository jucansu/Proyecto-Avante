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

  constructor(private publicacionService : PublicacionService,
    private router : Router) { }

  ngOnInit() {
  }

  onSubmit(publicacionForm){
    var publicacion = new Publicacion(0, publicacionForm.titulo, 
      publicacionForm.descripcion, publicacionForm.etiqueta, new Date(), 0, 2);
    this.publicacionService.post(publicacion).subscribe(publicacion => {
      if(publicacion.id && publicacion.id != 0){
        this.router.navigate(["/detalle/"+publicacion.id]);
      }
    });
  }

}
