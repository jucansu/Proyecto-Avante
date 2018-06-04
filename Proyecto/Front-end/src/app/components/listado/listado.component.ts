import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-listado',
  templateUrl: './listado.component.html',
  styleUrls: ['./listado.component.css']
})
export class ListadoComponent implements OnInit {

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
