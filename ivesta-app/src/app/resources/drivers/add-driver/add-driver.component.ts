import { Component, OnInit } from '@angular/core';
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-add-driver',
  templateUrl: './add-driver.component.html',
  styleUrls: ['./add-driver.component.css']
})
export class AddDriverComponent implements OnInit {

  constructor(private formBuilder: FormBuilder){ }

  ngOnInit(): void {
  }

  form = this.formBuilder.group({
    name: [],
    lastName: [],
    phoneNumber: [],
    license: [],
  });

  submit() {
    this.form.markAllAsTouched();
    if (!this.form.valid) {
      return;
    }
    console.log('this.form.value', this.form.value); // SEND TO BACKEND
    console.log('this.form.errors', this.form.errors);
    this.form.reset();
  }
}
