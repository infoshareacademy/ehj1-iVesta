import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {DriversHttpService} from "../drivers-http.service";
import {FormBuilder} from "@angular/forms";
import {Driver} from "../../../model/driver";

@Component({
  selector: 'app-edit-driver',
  templateUrl: './edit-driver.component.html',
  styleUrls: ['./edit-driver.component.css']
})
export class EditDriverComponent implements OnInit {
  license: string;
  driver: Driver;

  driverId = this.activatedRoute.snapshot.params['id'];

  constructor(private activatedRoute: ActivatedRoute, private httpService: DriversHttpService, private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.httpService.fetchDriverById(this.driverId)
      .subscribe(res => {
        this.driver = res;
      })
  }

  form = this.formBuilder.group({
    name: [],
    lastName: [],
    phoneNumber: [],
    license: [],
    availability: []
  });

  submit() {
    this.httpService.update(this.form.value, this.driverId).subscribe();
    console.log(this.form.value)
    this.form.reset();
  }

  //TODO - update drivera po submicie a nie po kliknieciu

  setStatusToActive() {
    this.httpService.activateDriver(this.driverId).subscribe();
  }

  setStatusToInactive() {
    this.httpService.deactivateDriver(this.driverId).subscribe();
  }
  LICENSES =[
    {name:'A1'},
    {name:'A2'},
    {name:'A'},
    {name:'B'},
    {name:'B1'},
    {name:'B+E'},
    {name:'C'},
    {name:'C1'},
    {name:'C1+E'},
    {name:'C+E'},
    {name:'D'},
    {name:'D1'},
    {name:'D1+E'},
    {name:'D+E'},
    {name:'T'},
  ]
}
