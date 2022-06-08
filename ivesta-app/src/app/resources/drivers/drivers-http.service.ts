import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Driver} from "../../model/driver";

const DRIVERS_API_PATH = 'http://localhost:8080/api/drivers';

@Injectable({
  providedIn: 'root'
})
export class DriversHttpService {
  constructor(private http: HttpClient) {
  }

  fetch() {
    return this.http.get<Driver[]>(DRIVERS_API_PATH);
  }

  fetchDriverById(driverId: string) {
    return this.http.get<Driver>(`${DRIVERS_API_PATH}/${driverId}`);
  }

  delete(removeCandidate: string){
    return this.http.delete(`${DRIVERS_API_PATH}/${removeCandidate}`);
  }
}
