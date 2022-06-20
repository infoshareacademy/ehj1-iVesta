import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddVehicleToRouteComponent } from './add-vehicle-to-route.component';

const routes: Routes = [{ path: '', component: AddVehicleToRouteComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AddVehicleToRouteRoutingModule { }
