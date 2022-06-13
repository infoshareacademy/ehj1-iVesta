import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';


const routes: Routes = [
  {path: 'drivers', loadChildren: () => import('./pages/drivers/drivers.module').then(m => m.DriversModule)},
  { path: 'home', loadChildren: () => import('./pages/home/home.module').then(m => m.HomeModule) },
  { path: 'routes', loadChildren: () => import('./pages/routes/routes.module').then(m => m.RoutesModule) },
  { path: 'vehicles', loadChildren: () => import('./pages/vehicles/vehicles.module').then(m => m.VehiclesModule) },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {
}

