import { Component, OnInit } from '@angular/core';
import { PublicacionService } from '../../services/publicacion.service';

@Component({
  selector: 'app-listado-publicacion',
  templateUrl: './listado-publicacion.component.html',
  styleUrls: ['./listado-publicacion.component.css']
})
export class ListadoPublicacionComponent implements OnInit {

  constructor(private publicacionService: PublicacionService) { }

  ngOnInit() {
  }

}
