import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DriversComponent} from './drivers.component';

const routes: Routes = [{path: '', component: DriversComponent}, {
  path: 'add',
  loadChildren: () => import('./driver-add/driver-add.module').then(m => m.DriverAddModule)
}, {path: ':id', loadChildren: () => import('./edit-driver/edit-driver.module').then(m => m.EditDriverModule)}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DriversRoutingModule {
}
