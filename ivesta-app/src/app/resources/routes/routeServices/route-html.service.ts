import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
// @ts-ignore
import {RouteComponent} from "../../../models/route/route.component";

const ROUTES_API_PATH='http://localhost:8080/api/routes';

@Injectable({
  providedIn: 'root'
})
export class RouteHtmlService {
  constructor(private http: HttpClient) { }

  fetch(){
    return this.http.get<RouteComponent[]>(ROUTES_API_PATH);
  }


}
