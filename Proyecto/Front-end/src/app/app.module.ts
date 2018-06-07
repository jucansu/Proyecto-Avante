import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'
import {HttpClientModule} from '@angular/common/http';

import { AppComponent } from './app.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { AppRoutingModule } from './app.routing';
import { UserService } from './services/user.service';
import { ProfileComponent } from './components/profile/profile.component';
import { RegisterComponent } from './components/register/register.component';
import { HomeComponent } from './components/home/home.component';
import { CreacionPublicacionComponent } from './components/creacion-publicacion/creacion-publicacion.component';
import { ListadoPublicacionComponent } from './components/listado-publicacion/listado-publicacion.component';
import { DetailsComponent } from './components/details/details.component';

import { FroalaEditorModule, FroalaViewModule } from 'angular-froala-wysiwyg';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    CreacionPublicacionComponent,
    ListadoPublicacionComponent,
    LoginPageComponent,
    ProfileComponent,
    RegisterComponent,
    DetailsComponent
  ],
  imports: [
    FroalaEditorModule.forRoot(), 
    FroalaViewModule.forRoot(),
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
