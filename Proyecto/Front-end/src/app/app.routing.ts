import {Routes, RouterModule} from '@angular/router';
import{FrontEndComponent} from './components/front-end/front-end.component';
import{ListadoComponent} from './components/listado/listado.component';

const routes : Routes = [
    {path: '', component: FrontEndComponent},
    {path: 'listado', component: ListadoComponent }
];

export const routing = RouterModule.forRoot(routes);

