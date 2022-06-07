import { Component, OnInit } from '@angular/core';
import {DriverHtmlService} from "./driverServices/driver-html.service";
import {DriverComponent} from "../../models/driver/driver.component"

@Component({
  selector: 'app-drivers',
  templateUrl: './drivers.component.html',
  styleUrls: ['./drivers.component.css']
})
export class DriversComponent implements OnInit {

  drivers: DriverComponent[]=[];

  constructor(private driverService: DriverHtmlService) { }

  ngOnInit(): void {
    this.fetchDrivers();
  }
  fetchDrivers(){
    this.driverService.fetch().subscribe(response=>{
      this.drivers = response;
    })
    console.log(this.drivers)
  }
}
