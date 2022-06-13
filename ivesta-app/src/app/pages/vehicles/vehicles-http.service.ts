import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Vehicle} from "../../model/vehicle";

const VEHICLES_API_PATH='http://localhost:8080/api/vehicles';

@Injectable({
  providedIn: 'root'
})
export class VehiclesHttpService {

  constructor(private http: HttpClient) { }

  fetch(){
    return this.http.get<Vehicle[]>(VEHICLES_API_PATH);
  }
}
