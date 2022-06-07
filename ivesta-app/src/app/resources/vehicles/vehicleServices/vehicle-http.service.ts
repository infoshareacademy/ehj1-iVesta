import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {VehicleComponent} from "../../../models/vehicle/vehicle.component";

const VEHICLES_API_PATH='http://localhost:8080/api/vehicles';

@Injectable({
  providedIn: 'root'
})
export class VehicleHttpService {

  constructor(private http: HttpClient) { }

  fetch(){
    return this.http.get<VehicleComponent[]>(VEHICLES_API_PATH);
  }
}
