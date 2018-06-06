import { Component, OnInit } from '@angular/core';
import { PublicacionService } from '../../services/publicacion.service';
import { Publicacion } from '../../models/publicacion';
@Component({
  selector: 'home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  private listaPublicacion : Publicacion[]

  constructor(private publicacionService: PublicacionService) { }

  ngOnInit() {
    console.log("sdf");
    
    this.publicacionService.getList().subscribe(lista =>{
      this.listaPublicacion=lista;
      console.log("llega de subscribe", lista);
      console.log("lista", this.listaPublicacion);
      
    });
  }

}
