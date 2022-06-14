import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EditRouteRoutingModule } from './edit-route-routing.module';
import { EditRouteComponent } from './edit-route.component';
import {ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatSelectModule} from "@angular/material/select";


@NgModule({
  declarations: [
    EditRouteComponent
  ],
  imports: [
    CommonModule,
    EditRouteRoutingModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatSelectModule
  ]
})
export class EditRouteModule { }
