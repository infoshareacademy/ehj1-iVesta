import { Component, OnInit } from '@angular/core';
import {RoutesHttpService} from "../routes-http.service";
import {Route} from "../../../model/route";

@Component({
  selector: 'app-incomplete-route',
  templateUrl: './incomplete-route.component.html',
  styleUrls: ['./incomplete-route.component.css']
})
export class IncompleteRouteComponent implements OnInit {

  routes: Route[] = [];

  constructor(private http: RoutesHttpService) { }

  ngOnInit(): void {
    this.fetchIncompleteRoutes()
  }

  fetchIncompleteRoutes(){
    this.http.fetchIncompleteRoutes().subscribe((res)=>{
      this.routes = res
    })
  }
}
