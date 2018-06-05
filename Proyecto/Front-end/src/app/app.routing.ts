import {Routes, RouterModule} from '@angular/router';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { NgModule } from '@angular/core';
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/register/register.component';
import { ProfileComponent } from './components/profile/profile.component';
import { CreacionPublicacionComponent } from './components/creacion-publicacion/creacion-publicacion.component';
import { ListadoPublicacionComponent } from './components/listado-publicacion/listado-publicacion.component';

const routes : Routes = [
    {path: '', component: HomeComponent},
    {path: 'register', component: RegisterComponent},
    {path: 'profile', component: ProfileComponent},
    {path: 'post', component: CreacionPublicacionComponent},
    {path: 'post/:id', component: CreacionPublicacionComponent},
    {path: 'post/get/:id', component: ListadoPublicacionComponent},
    {path: 'login', component: LoginPageComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
export class AppRoutingModule { }
  

