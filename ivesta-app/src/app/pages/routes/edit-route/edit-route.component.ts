import {Component, OnInit} from '@angular/core';
import {Route} from "../../../model/route";
import {ActivatedRoute} from "@angular/router";
import {FormBuilder} from "@angular/forms";
import {RoutesHttpService} from "../routes-http.service";
import {DriversHttpService} from "../../drivers/drivers-http.service";
import {VehiclesHttpService} from "../../vehicles/vehicles-http.service";

@Component({
  selector: 'app-edit-route',
  templateUrl: './edit-route.component.html',
  styleUrls: ['./edit-route.component.css']
})

export class EditRouteComponent implements OnInit {

  avRoute: Route;
  routeId = this.activatedRoute.snapshot.params['id'];

  constructor(private activatedRoute: ActivatedRoute, private httpService: RoutesHttpService, private formBuilder: FormBuilder,private httpDriverService: DriversHttpService, private httpVehicles: VehiclesHttpService) { }

  ngOnInit(){
    this.httpService.fetchRouteById(this.routeId)
      .subscribe(res => {
        this.avRoute = res;
      })
  }

  submit() {
    this.httpService.update(this.form.value, this.routeId).subscribe();
    console.log(this.form.value)
  }

  form = this.formBuilder.group({
    startAddress: [],
    destinationAddress: [],
    routeLength: [],
    transportType: [],
    transportVolume: [],
    date: [],
    driver:[],
    vehicle:[],
  });
  //todo ustawic datę na obecną a nie -1
}
