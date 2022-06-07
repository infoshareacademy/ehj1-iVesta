import { Component, OnInit } from '@angular/core';
import {VehicleHttpService} from "../vehicleServices/vehicle-http.service";
import {VehicleComponent} from "../../../models/vehicle/vehicle.component";

@Component({
  selector: 'app-vehicles',
  templateUrl: './vehicles.component.html',
  styleUrls: ['./vehicles.component.css']
})
export class VehiclesComponent implements OnInit {

  vehicles: VehicleComponent[] = [];

  constructor(private vehicleService: VehicleHttpService) { }

  ngOnInit(): void {
    this.fetchVehicles();
  }
  fetchVehicles(){
    this.vehicleService.fetch().subscribe(response=>{
      this.vehicles = response;
    })
    console.log(this.vehicles);
  }

}
