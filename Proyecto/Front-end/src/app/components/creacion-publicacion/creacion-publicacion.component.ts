import { Component, OnInit } from '@angular/core';
import { Publicacion } from '../../models/publicacion';
import { PublicacionService } from '../../services/publicacion.service';
import { UserService } from '../../services/user.service';
import { Usuario } from '../../models/usuario';

@Component({
  selector: 'creacion-publicacion',
  templateUrl: './creacion-publicacion.component.html',
  styleUrls: ['./creacion-publicacion.component.css']
})
export class CreacionPublicacionComponent implements OnInit {

  constructor(private publicacionService : PublicacionService) { }

  ngOnInit() {
  }

  onSubmit(publicacionForm){
    console.log("asd", publicacionForm);
        
    var publicacion = new Publicacion(0, publicacionForm.titulo, 
      publicacionForm.descripcion, publicacionForm.etiquetas, new Date(), 0, new Usuario());
    this.publicacionService.post(publicacion).subscribe(publicacion => {
     
    });
  }

}
