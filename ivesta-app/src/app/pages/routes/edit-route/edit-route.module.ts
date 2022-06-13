import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EditRouteRoutingModule } from './edit-route-routing.module';
import { EditRouteComponent } from './edit-route.component';


@NgModule({
  declarations: [
    EditRouteComponent
  ],
  imports: [
    CommonModule,
    EditRouteRoutingModule
  ]
})
export class EditRouteModule { }
