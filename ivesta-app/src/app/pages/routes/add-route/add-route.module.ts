import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AddRouteRoutingModule } from './add-route-routing.module';
import { AddRouteComponent } from './add-route.component';


@NgModule({
  declarations: [
    AddRouteComponent
  ],
  imports: [
    CommonModule,
    AddRouteRoutingModule
  ]
})
export class AddRouteModule { }
