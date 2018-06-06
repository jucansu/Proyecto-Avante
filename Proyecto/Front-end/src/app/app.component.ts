import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  private isLogged : boolean;
  //EndPoint que diga si estoy loggeada

  ngOnInit() {
    var cookies : string[] = document.cookie.split(";");
    for(let cookie of cookies){
      //if(cookie.)
    }
  }
}


