import {Component, OnInit} from '@angular/core';
import {DriverHtmlService} from "./driverServices/driver-html.service";
import {DriverComponent} from "../../models/driver/driver.component"

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

  deleteDriverById(removeCandidate: string) {
    this.driverService.delete(removeCandidate).subscribe(() => {
      this.fetchDrivers();
      console.log("Klikniete")
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
