import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'

import { AppComponent } from './app.component';
import { FrontEndComponent } from './components/front-end/front-end.component';
import { ListadoComponent } from './components/listado/listado.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { AppRoutingModule } from './app.routing';
import { UserService } from './services/user.service';
import { LocationStrategy, HashLocationStrategy } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
    FrontEndComponent,
    ListadoComponent,
    LoginPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [{provide: LocationStrategy, useClass: HashLocationStrategy},
    UserService],
  bootstrap: [AppComponent,ListadoComponent]
})
export class AppModule { }
