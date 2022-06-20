import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddDriverToRouteComponent } from './add-driver-to-route.component';

const routes: Routes = [{ path: '', component: AddDriverToRouteComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AddDriverToRouteRoutingModule { }
