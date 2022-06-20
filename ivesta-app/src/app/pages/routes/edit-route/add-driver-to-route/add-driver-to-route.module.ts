import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AddDriverToRouteRoutingModule } from './add-driver-to-route-routing.module';
import { AddDriverToRouteComponent } from './add-driver-to-route.component';
import {ReactiveFormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    AddDriverToRouteComponent
  ],
    imports: [
        CommonModule,
        AddDriverToRouteRoutingModule,
        ReactiveFormsModule
    ]
})
export class AddDriverToRouteModule { }
