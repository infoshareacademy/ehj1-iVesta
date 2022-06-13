import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditRouteComponent } from './edit-route.component';

const routes: Routes = [{ path: '', component: EditRouteComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EditRouteRoutingModule { }
