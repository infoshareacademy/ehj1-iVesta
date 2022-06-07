import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {VehiclesComponent} from "./resources/vehicles/vehicles/vehicles.component";
import {RoutesComponent} from "./resources/routes/routes.component";
import {DriversComponent} from "./resources/drivers/drivers.component";

const routes: Routes = [
  {path:'vehicles', component:VehiclesComponent},
  {path:'drivers', component:DriversComponent},
  {path:'routes', component:RoutesComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
