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
    //this.fetchDriversById("0cf1f588-c61f-11ec-9d64-0242ac120002");
    this.deleteDriverById('0cf1f588-c61f-11ec-9d64-0242ac120002');
  }
  fetchDrivers(){
    this.driverService.fetch().subscribe(response=>{
      this.drivers = response;
    })
    console.log(this.drivers)
  }

  fetchDriversById(driverId: string){
    this.driverService.fetchDriverById(driverId).subscribe(response =>{
      this.drivers= [response];
    })
  }
  deleteDriverById(driverId: string){
    this.driverService.delete(driverId).subscribe();
  }

}
