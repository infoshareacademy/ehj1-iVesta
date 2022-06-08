import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {DriversComponent} from './resources/drivers/drivers.component';
import {RoutesComponent} from './resources/routes/routes.component';
import {VehiclesComponent} from './resources/vehicles/vehicles/vehicles.component';
import {HttpClientModule} from "@angular/common/http";
import {DriverHtmlService} from "./resources/drivers/driverServices/driver-html.service";

@NgModule({
  declarations: [
    AppComponent,
    DriversComponent,
    RoutesComponent,
    VehiclesComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    DriverHtmlService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
