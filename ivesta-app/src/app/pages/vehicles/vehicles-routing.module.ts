import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { VehiclesComponent } from './vehicles.component';

const routes: Routes = [{ path: '', component: VehiclesComponent }, { path: 'add', loadChildren: () => import('./add-vehicle/add-vehicle.module').then(m => m.AddVehicleModule) }, { path: ':id', loadChildren: () => import('./edit-vehicle/edit-vehicle.module').then(m => m.EditVehicleModule) }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VehiclesRoutingModule { }
