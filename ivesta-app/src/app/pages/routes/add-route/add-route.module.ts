import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AddRouteRoutingModule } from './add-route-routing.module';
import { AddRouteComponent } from './add-route.component';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatSelectModule} from "@angular/material/select";
import {ReactiveFormsModule} from "@angular/forms";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatInputModule} from "@angular/material/input";


@NgModule({
  declarations: [
    AddRouteComponent
  ],
  imports: [
    CommonModule,
    AddRouteRoutingModule,
    MatFormFieldModule,
    MatSelectModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatInputModule
  ]
})
export class AddRouteModule { }
