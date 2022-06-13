import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DriverAddRoutingModule } from './driver-add-routing.module';
import { DriverAddComponent } from './driver-add.component';
import {ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatSelectModule} from "@angular/material/select";


@NgModule({
  declarations: [
    DriverAddComponent
  ],
  imports: [
    CommonModule,
    DriverAddRoutingModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatSelectModule
  ]
})
export class DriverAddModule { }
