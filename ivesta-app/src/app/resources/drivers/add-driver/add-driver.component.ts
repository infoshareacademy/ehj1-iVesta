import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl} from "@angular/forms";
import {License} from "../../../model/license";
import {DriverCandidate} from "../../../model/driver-candidate";
import {DriversHttpService} from "../drivers-http.service";
import {Driver} from "../../../model/driver";

@Component({
  selector: 'app-add-driver',
  templateUrl: './add-driver.component.html',
  styleUrls: ['./add-driver.component.css']
})

export class AddDriverComponent implements OnInit {
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

  submit() {
    this.form.markAllAsTouched();
    if (!this.form.valid) {
      return;
    }
    console.log('this.form.value', JSON.stringify(this.form.value)); // SEND TO BACKEND
    console.log('this.form.errors', this.form.errors);
    this.createNewDriver(this.form.value)
    this.form.reset();
  }
  createNewDriver(driver: DriverCandidate){
    this.driverService.create(driver).subscribe(()=>{
      this.fetchDrivers();
    })
  }
  fetchDrivers() {
    this.driverService.fetch().subscribe(response => {
      this.drivers = response;
    })
  }
}


