import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {VehiclesComponent} from "./resources/vehicles/vehicles.component";
import {DriversComponent} from "./resources/drivers/drivers.component";
import {RoutesComponent} from "./resources/routes/routes.component";
import {AddDriverComponent} from "./resources/drivers/add-driver/add-driver.component";
import {EditDriverComponent} from "./resources/drivers/edit-driver/edit-driver.component";

const routes: Routes = [
  {path:'vehicles', component:VehiclesComponent},
  {path:'drivers', component:DriversComponent,
  children: [
    {path: 'add-driver', component:AddDriverComponent},
    {path: 'edit-driver', component:EditDriverComponent}
  ]},
  {path:'routes', component:RoutesComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
