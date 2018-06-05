import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'

import { AppComponent } from './app.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { AppRoutingModule } from './app.routing';
import { UserService } from './services/user.service';
import { LocationStrategy, HashLocationStrategy } from '@angular/common';
import { ProfileComponent } from './components/profile/profile.component';
import { RegisterComponent } from './components/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { CreacionPublicacionComponent } from './components/creacion-publicacion/creacion-publicacion.component';
import { ListadoPublicacionComponent } from './components/listado-publicacion/listado-publicacion.component';
import { NavbarComponent } from './components/navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CreacionPublicacionComponent,
    ListadoPublicacionComponent,
    LoginPageComponent,
    ProfileComponent,
    RegisterComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [{provide: LocationStrategy, useClass: HashLocationStrategy},
    UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
