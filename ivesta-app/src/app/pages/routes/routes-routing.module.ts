import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RoutesComponent } from './routes.component';

const routes: Routes = [{ path: '', component: RoutesComponent }, { path: 'add', loadChildren: () => import('./add-route/add-route.module').then(m => m.AddRouteModule) }, { path: ':id', loadChildren: () => import('./edit-route/edit-route.module').then(m => m.EditRouteModule) }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RoutesRoutingModule { }
