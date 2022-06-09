import {Component, OnInit} from '@angular/core';
import {Driver} from "../../model/driver";
import {DriversHttpService} from "./drivers-http.service";
import {DriverCandidate} from "../../model/driver-candidate";

@Component({
  selector: 'app-drivers',
  templateUrl: './drivers.component.html',
  styleUrls: ['./drivers.component.css']
})
export class DriversComponent implements OnInit {

  drivers: Driver[]=[];

  constructor(private driverService: DriversHttpService) { }

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
  createNewDriver(driver: DriverCandidate){
    this.driverService.create(driver).subscribe(()=>{
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


