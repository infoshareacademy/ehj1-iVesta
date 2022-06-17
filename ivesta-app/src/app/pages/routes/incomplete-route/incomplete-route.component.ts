import {Component, OnInit} from '@angular/core';
import {RoutesHttpService} from "../routes-http.service";
import {Route} from "../../../model/route";
import {DriversHttpService} from "../../drivers/drivers-http.service";

@Component({
  selector: 'app-incomplete-route',
  templateUrl: './incomplete-route.component.html',
  styleUrls: ['./incomplete-route.component.css']
})
export class IncompleteRouteComponent implements OnInit {

  routes: Route[] = [];

  constructor(private http: RoutesHttpService, private driverService: DriversHttpService) {
  }

  ngOnInit(): void {
    this.fetchIncompleteRoutes()
  }

  fetchIncompleteRoutes() {
    this.http.fetchIncompleteRoutes().subscribe((res) => {
      this.routes = res;
    })
  }

  echAvailableDriver() {
    let date = this.routes.map((data) => {
      return data.date[0]
    })
  }
}
