import { Component, OnInit } from '@angular/core';
import { Publicacion } from '../../models/publicacion';
import { PublicacionService } from '../../services/publicacion.service';
import { UserService } from '../../services/user.service';
import { Usuario } from '../../models/usuario';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-delete-publicacion',
  templateUrl: './delete-publicacion.component.html',
  styleUrls: ['./delete-publicacion.component.css']
})
export class DeletePublicacionComponent implements OnInit {

  constructor(private publicacionService : PublicacionService,
    private router : Router,private route : ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      var id = +params['id'];
    this.publicacionService.delete(id).subscribe(publicacion => {
        this.router.navigate([""]);
      
    });
  });
  }
}