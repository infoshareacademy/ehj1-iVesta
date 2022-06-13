import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EditDriverRoutingModule } from './edit-driver-routing.module';
import { EditDriverComponent } from './edit-driver.component';
import {ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatSelectModule} from "@angular/material/select";


@NgModule({
  declarations: [
    EditDriverComponent
  ],
  imports: [
    CommonModule,
    EditDriverRoutingModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatSelectModule
  ]
})
export class EditDriverModule { }