import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DriverAddComponent } from './driver-add.component';

const routes: Routes = [{ path: '', component: DriverAddComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DriverAddRoutingModule { }
