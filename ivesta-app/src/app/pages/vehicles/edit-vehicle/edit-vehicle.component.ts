import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {FormBuilder} from "@angular/forms";
import {Vehicle} from "../../../model/vehicle";
import {VehiclesHttpService} from "../vehicles-http.service";

@Component({
  selector: 'app-edit-vehicle',
  templateUrl: './edit-vehicle.component.html',
  styleUrls: ['./edit-vehicle.component.css']
})
export class EditVehicleComponent implements OnInit {
  license: string;
  vehicle: Vehicle;

  vehicleId = this.activatedRoute.snapshot.params['id'];

  constructor(private activatedRoute: ActivatedRoute, private formBuilder: FormBuilder, private httpService: VehiclesHttpService) { }

  ngOnInit(): void {
    this.httpService.fetchDriverById(this.vehicleId).subscribe(res =>{
      this.vehicle=res
    })
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

  submit(){
    console.log(this.form.value)
    this.httpService.update(this.form.value, this.vehicleId).subscribe();
    console.log(this.form.value)
    this.form.reset();
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
  ];
}
