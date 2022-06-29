import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DriversRoutingModule } from './drivers-routing.module';
import { DriversComponent } from './drivers.component';
import {MatPaginatorModule} from "@angular/material/paginator";


@NgModule({
  declarations: [
    DriversComponent
  ],
    imports: [
        CommonModule,
        DriversRoutingModule,
        MatPaginatorModule
    ]
})
export class DriversModule { }
