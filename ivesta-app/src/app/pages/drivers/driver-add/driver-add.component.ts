import { Component, OnInit } from '@angular/core';
import {License} from "../../../model/license";
import {Driver} from "../../../model/driver";
import {FormBuilder} from "@angular/forms";
import {DriverCandidate} from "../../../model/driver-candidate";
import {DriversHttpService} from "../drivers-http.service";

@Component({
  selector: 'app-driver-add',
  templateUrl: './driver-add.component.html',
  styleUrls: ['./driver-add.component.css']
})
export class DriverAddComponent implements OnInit {
  license: License[] = [];
  drivers: Driver[] = [];

  constructor(private formBuilder: FormBuilder, private driverService: DriversHttpService) { }

  ngOnInit(): void {
  }

  form = this.formBuilder.group({
    name: [],
    lastName: [],
    phoneNumber: [],
    license: [this.license],
    availability: []
  });

  submit() {
    this.form.markAllAsTouched();
    if (!this.form.valid) {
      return;
    }
    this.createNewDriver(this.form.value)
    this.form.reset();
  }

  createNewDriver(driver: DriverCandidate) {
    this.driverService.create(driver).subscribe(() => {
      this.fetchDrivers();
    })
  }

  fetchDrivers() {
    this.driverService.fetch().subscribe(response => {
      this.drivers = response;
    })
  }

}
