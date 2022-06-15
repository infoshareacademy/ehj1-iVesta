import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Vehicle} from "../../model/vehicle";
import {Driver} from "../../model/driver";
import {VehicleCandidate} from "../../model/vehicle-candidate";

const VEHICLES_API_PATH='http://localhost:8080/api/vehicles';

@Injectable({
  providedIn: 'root'
})
export class VehiclesHttpService {

  constructor(private http: HttpClient) { }

  fetch(){
    return this.http.get<Vehicle[]>(VEHICLES_API_PATH);
  }

  fetchDriverById(vehicleId: string) {
    return this.http.get<Vehicle>(`${VEHICLES_API_PATH}/${vehicleId}`);
  }

  delete(removeCandidate: string){
    return this.http.delete(`${VEHICLES_API_PATH}/${removeCandidate}`);
  }
  create(vehicle: VehicleCandidate){
    return this.http.post<Vehicle>(VEHICLES_API_PATH, vehicle);
  }

  update(vehicle: VehicleCandidate,vehicleId: string){
    return this.http.put<Vehicle>(`${VEHICLES_API_PATH}/${vehicleId}`,vehicle)
  }
}
