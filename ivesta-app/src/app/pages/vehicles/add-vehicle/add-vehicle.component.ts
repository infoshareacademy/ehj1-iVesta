import { Component, OnInit } from '@angular/core';
import {License} from "../../../model/license";
import {FormBuilder} from "@angular/forms";
import {VehiclesHttpService} from "../vehicles-http.service";
import {VehicleCandidate} from "../../../model/vehicle-candidate";
import {Vehicle} from "../../../model/vehicle";

@Component({
  selector: 'app-add-vehicle',
  templateUrl: './add-vehicle.component.html',
  styleUrls: ['./add-vehicle.component.css']
})
export class AddVehicleComponent implements OnInit {

  license: License[] = [];
  vehicle: Vehicle[] = [];

  constructor(private formBuilder: FormBuilder, private  vehicleService: VehiclesHttpService) { }

  ngOnInit(): void {
  }

  form = this.formBuilder.group({
    brand: [],
    model: [],
    vehicleCategory: [],
    license: [],
    numberOfSeats: [],
    fuelType: [],
    weightLimit: [],
    availability: []
  });

  submit() {
    this.form.markAllAsTouched();
    if (!this.form.valid) {
      return;
    }
    this.createNewVehicle(this.form.value)
    console.log(this.form.value)
    this.form.reset();
    alert('Pojazd został dodany');
  }

  createNewVehicle(vehicle: VehicleCandidate){
    this.vehicleService.create(vehicle).subscribe(()=>this.fetchVehicles())
  }

  fetchVehicles(){
    this.vehicleService.fetch().subscribe( response => {
      this.vehicle = response;
    })
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

  FUEL_TYPE = [
    {name: 'benzyna'},
    {name: 'diesel'},
    {name: 'LPG'},
    {name: 'CNG'}
  ]
}
