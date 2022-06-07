import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {DriverComponent} from "../../../models/driver/driver.component";

const DRIVERS_API_PATH='http://localhost:8080/api/drivers';

@Injectable({
  providedIn: 'root'
})
export class DriverHtmlService {
  constructor(private http: HttpClient) { }

fetch(){
    return this.http.get<DriverComponent[]>(DRIVERS_API_PATH);
}


}
