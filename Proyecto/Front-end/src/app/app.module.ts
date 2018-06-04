import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FrontEndComponent } from './components/front-end/front-end.component';
import { ListadoComponent } from './components/listado/listado.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { AppRoutingModule } from './app.routing';

@NgModule({
  declarations: [
    AppComponent,
    FrontEndComponent,
    ListadoComponent,
    LoginPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
