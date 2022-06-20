import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AddVehicleToRouteRoutingModule } from './add-vehicle-to-route-routing.module';
import { AddVehicleToRouteComponent } from './add-vehicle-to-route.component';
import {ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    AddVehicleToRouteComponent
  ],
    imports: [
        CommonModule,
        AddVehicleToRouteRoutingModule,
        ReactiveFormsModule
    ]
})
export class AddVehicleToRouteModule { }
