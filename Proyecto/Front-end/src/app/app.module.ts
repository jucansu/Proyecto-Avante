import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FrontEndComponent } from './components/front-end/front-end.component';
import  {ListadoComponent} from './components/listado/listado.component';
import {routing} from './app.routing';
import { LocationStrategy, HashLocationStrategy } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    FrontEndComponent,
    ListadoComponent
  ],
  imports: [
    BrowserModule, routing
  ],
  providers: [{provide: LocationStrategy, useClass: HashLocationStrategy}],
  bootstrap: [AppComponent,ListadoComponent]
})
export class AppModule { }
