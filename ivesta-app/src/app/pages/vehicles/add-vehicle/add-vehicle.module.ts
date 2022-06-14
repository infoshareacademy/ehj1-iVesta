import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AddVehicleRoutingModule } from './add-vehicle-routing.module';
import { AddVehicleComponent } from './add-vehicle.component';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatSelectModule} from "@angular/material/select";
import {ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    AddVehicleComponent
  ],
  imports: [
    CommonModule,
    AddVehicleRoutingModule,
    MatFormFieldModule,
    MatSelectModule,
    ReactiveFormsModule
  ]
})
export class AddVehicleModule { }
