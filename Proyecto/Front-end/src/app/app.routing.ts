import {Routes, RouterModule} from '@angular/router';
import{FrontEndComponent} from './components/front-end/front-end.component';
import{ListadoComponent} from './components/listado/listado.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { NgModule } from '@angular/core';

const routes : Routes = [
    {path: '', component: FrontEndComponent},
    {path: 'listado', component: ListadoComponent },
    {path: 'login', component: LoginPageComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
export class AppRoutingModule { }
  

