import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { IncompleteRouteRoutingModule } from './incomplete-route-routing.module';
import { IncompleteRouteComponent } from './incomplete-route.component';


@NgModule({
  declarations: [
    IncompleteRouteComponent
  ],
  imports: [
    CommonModule,
    IncompleteRouteRoutingModule
  ]
})
export class IncompleteRouteModule { }
