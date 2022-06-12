import { Component, OnInit } from '@angular/core';
import {License} from "../../../model/license";
import {Driver} from "../../../model/driver";
import {FormBuilder} from "@angular/forms";
import {DriversHttpService} from "../drivers-http.service";
import {DriverCandidate} from "../../../model/driver-candidate";

@Component({
  selector: 'app-edit-driver',
  templateUrl: './edit-driver.component.html',
  styleUrls: ['./edit-driver.component.css']
})
export class EditDriverComponent implements OnInit {

  license: License[]=[];
  drivers: Driver[]=[];

  constructor(private formBuilder: FormBuilder, private driverService: DriversHttpService){ }

  ngOnInit(): void {
  }

  form = this.formBuilder.group({
    name: [],
    lastName: [],
    phoneNumber: [],
    license: [this.license],
    availability:[]
  });

  updateDriver() {
    this.form.markAllAsTouched();
    if (!this.form.valid) {
      return;
    }
    this.updateCurrentDriver(this.form.value,this.drivers[0].id)
    this.form.reset();
  }

  updateCurrentDriver(driver: DriverCandidate,driverId: string){
    this.driverService.update(driver,driverId).subscribe(()=> this.fetchDrivers());

  }
  fetchDrivers() {
    this.driverService.fetch().subscribe(response => {
      this.drivers = response;
    })
  }
}
