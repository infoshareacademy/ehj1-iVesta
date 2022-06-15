import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AddRouteRoutingModule } from './add-route-routing.module';
import { AddRouteComponent } from './add-route.component';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatSelectModule} from "@angular/material/select";
import {ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    AddRouteComponent
  ],
  imports: [
    CommonModule,
    AddRouteRoutingModule,
    MatFormFieldModule,
    MatSelectModule,
    ReactiveFormsModule
  ]
})
export class AddRouteModule { }
