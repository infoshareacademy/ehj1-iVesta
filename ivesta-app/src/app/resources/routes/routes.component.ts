import { Component, OnInit } from '@angular/core';
import {Route} from "../../model/route";
import {RoutesHttpService} from "./routes-http.service";

@Component({
  selector: 'app-routes',
  templateUrl: './routes.component.html',
  styleUrls: ['./routes.component.css']
})
export class RoutesComponent implements OnInit {

  routes: Route[] = [];

  constructor(private routeService: RoutesHttpService) { }

  ngOnInit(): void {
    this.fetchRoutes();
  }
  fetchRoutes() {
    this.routeService.fetch().subscribe(response => {
      this.routes = response;
    });
  }
}
