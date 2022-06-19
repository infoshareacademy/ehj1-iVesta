import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditRouteComponent } from './edit-route.component';

const routes: Routes = [{ path: '', component: EditRouteComponent }, { path: ':id/addDriver', loadChildren: () => import('./add-driver-to-route/add-driver-to-route.module').then(m => m.AddDriverToRouteModule) }, { path: ':id/addVehicle', loadChildren: () => import('./add-vehicle-to-route/add-vehicle-to-route.module').then(m => m.AddVehicleToRouteModule) }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EditRouteRoutingModule { }
