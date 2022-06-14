import { Component, OnInit } from '@angular/core';
import {Route} from "../../../model/route";
import {FormBuilder} from "@angular/forms";
import {RoutesHttpService} from "../routes-http.service";
import {RouteCandidate} from "../../../model/route-candidate";

@Component({
  selector: 'app-add-route',
  templateUrl: './add-route.component.html',
  styleUrls: ['./add-route.component.css']
})
export class AddRouteComponent implements OnInit {
  routes: Route[] = [];

  constructor(private formBuilder: FormBuilder, private routeService: RoutesHttpService) { }

  ngOnInit(): void {
  }

  form = this.formBuilder.group({
    startAddress: [],
    destinationAddress: [],
    routeLength: [],
    transportType: [],
    transportVolume: [],
    date: []
  });

  submit() {
    this.form.markAllAsTouched();
    if (!this.form.valid) {
      return;
    }
    this.createNewRoute(this.form.value)
    this.form.reset();
  }

  createNewRoute(route: RouteCandidate) {
    this.routeService.create(route).subscribe(() => {
      this.fetchRoutes();
    })
  }

  fetchRoutes() {
    this.routeService.fetch().subscribe(response => {
      this.routes = response;
      console.log(this.routes);
    })
  }

}
