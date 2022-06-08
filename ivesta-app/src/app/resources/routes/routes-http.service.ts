import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Route} from "../../model/route";

const ROUTES_API_PATH='http://localhost:8080/api/routes';

@Injectable({
  providedIn: 'root'
})
export class RoutesHttpService {

  constructor(private http: HttpClient) {
  }

  fetch() {
    return this.http.get<Route[]>(ROUTES_API_PATH);
  }
}
