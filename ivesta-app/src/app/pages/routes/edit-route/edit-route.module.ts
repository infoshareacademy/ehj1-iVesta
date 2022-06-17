import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EditRouteRoutingModule } from './edit-route-routing.module';
import { EditRouteComponent } from './edit-route.component';
import {ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatSelectModule} from "@angular/material/select";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatIconModule} from "@angular/material/icon";
import {MatInputModule} from "@angular/material/input";


@NgModule({
  declarations: [
    EditRouteComponent
  ],
  imports: [
    CommonModule,
    EditRouteRoutingModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatSelectModule,
    MatDatepickerModule,
    MatIconModule,
    MatInputModule
  ]
})
export class EditRouteModule { }
