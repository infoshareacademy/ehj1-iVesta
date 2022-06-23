import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EditVehicleRoutingModule } from './edit-vehicle-routing.module';
import { EditVehicleComponent } from './edit-vehicle.component';
import {ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatSelectModule} from "@angular/material/select";
import {MatInputModule} from "@angular/material/input";


@NgModule({
  declarations: [
    EditVehicleComponent
  ],
    imports: [
        CommonModule,
        EditVehicleRoutingModule,
        ReactiveFormsModule,
        MatFormFieldModule,
        MatSelectModule,
        MatInputModule
    ]
})
export class EditVehicleModule { }
