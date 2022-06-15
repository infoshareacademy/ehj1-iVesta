import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IncompleteRouteComponent } from './incomplete-route.component';

const routes: Routes = [{ path: '', component: IncompleteRouteComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class IncompleteRouteRoutingModule { }
