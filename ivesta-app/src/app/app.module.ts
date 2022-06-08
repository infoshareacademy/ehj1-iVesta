import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DriversComponent } from './resources/drivers/drivers.component';
import { RoutesComponent } from './resources/routes/routes.component';
import { VehiclesComponent } from './resources/vehicles/vehicles.component';
import {HttpClientModule} from "@angular/common/http";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AddDriverComponent } from './resources/drivers/add-driver/add-driver.component';
import { EditDriverComponent } from './resources/drivers/edit-driver/edit-driver.component';
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    DriversComponent,
    RoutesComponent,
    VehiclesComponent,
    AddDriverComponent,
    EditDriverComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        NgbModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
