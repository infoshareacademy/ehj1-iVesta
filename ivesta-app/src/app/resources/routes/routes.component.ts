import { Component, OnInit } from '@angular/core';
import {RouteHtmlService} from "./routeServices/route-html.service";
import {RouteComponent} from '../../models/route/route.component'

@Component({
  selector: 'app-routes',
  templateUrl: './routes.component.html',
  styleUrls: ['./routes.component.css']
})
export class RoutesComponent implements OnInit {

  routes: RouteComponent[] = [];

  constructor(private routeService: RouteHtmlService) { }

  ngOnInit(): void {
    this.fetchRoutes();
  }

  fetchRoutes() {
    this.routeService.fetch().subscribe(response => {
      this.routes = response;
    });
    console.log(this.routes);
  }

}
