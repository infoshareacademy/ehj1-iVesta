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
  license: string | undefined;
  driver: Driver;

  driverId = this.activatedRoute.snapshot.params['id'];

  constructor(private activatedRoute: ActivatedRoute, private httpService: DriversHttpService, private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.httpService.fetchDriverById(this.driverId)
      .subscribe(res => {
        this.driver = res;
      })
    console.log(this.licenseValue)
  }

  form = this.formBuilder.group({
    name: [],
    lastName: [],
    phoneNumber: [],
    license: [],
  });

  submit() {
    console.log(this.form.value)
    this.httpService.update(this.form.value, this.driverId).subscribe();
  }

  licenseValue = <HTMLInputElement><unknown>document.getElementsByClassName("mat-select-6");
}
