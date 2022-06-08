import {Component, OnInit} from '@angular/core';
import {DriverHtmlService} from "./driverServices/driver-html.service";
import {DriverComponent} from "../../models/driver/driver.component"
import {hide} from "@popperjs/core";

@Component({
  selector: 'app-drivers',
  templateUrl: './drivers.component.html',
  styleUrls: ['./drivers.component.css']
})
export class DriversComponent implements OnInit {

  drivers: DriverComponent[] = [];

  constructor(private driverService: DriverHtmlService) {
  }

  ngOnInit(): void {
    //this.fetchDriversById("0cf1f588-c61f-11ec-9d64-0242ac120002");
    //this.deleteDriverById('0cf1f588-c61f-11ec-9d64-0242ac120002');
  }

  fetchDrivers() {
    this.driverService.fetch().subscribe(response => {
      this.drivers = response;
    })
  }

  fetchDriversById(driverId: string) {
    this.driverService.fetchDriverById(driverId).subscribe(response => {
      this.drivers = [response];
    })
  }

  deleteDriverById(removeCandidate: DriverComponent) {
    this.driverService.delete(removeCandidate).subscribe(() => {
      this.fetchDrivers();
    })
  }
  setTableVisible(){
    const driverTable = <HTMLInputElement>document.getElementById("driver-table");
    driverTable.style.display ='block';
  }
  setTableInvisible(){
    const driverTable = <HTMLInputElement>document.getElementById("driver-table");
    driverTable.style.display ='none';
  }
}
