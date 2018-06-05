import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'creacion-publicacion',
  templateUrl: './creacion-publicacion.component.html',
  styleUrls: ['./creacion-publicacion.component.css']
})
export class CreacionPublicacionComponent implements OnInit {

  titulo : string;
  descripcion: string;
  etiqueta: string;
  fecha: any;
  valoracion: number;
  id_usuario: number;
  id: number;


  constructor() { }

  ngOnInit() {
  }

}
