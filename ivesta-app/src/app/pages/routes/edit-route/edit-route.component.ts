import {Component, OnInit} from '@angular/core';
import {Route} from "../../../model/route";
import {ActivatedRoute} from "@angular/router";
import {FormBuilder} from "@angular/forms";
import {RoutesHttpService} from "../routes-http.service";
import {Driver} from "../../../model/driver";
import {Vehicle} from "../../../model/vehicle";
import {DriversHttpService} from "../../drivers/drivers-http.service";
import {VehiclesHttpService} from "../../vehicles/vehicles-http.service";

@Component({
  selector: 'app-edit-route',
  templateUrl: './edit-route.component.html',
  styleUrls: ['./edit-route.component.css']
})
export class EditRouteComponent implements OnInit {

  avRoute: Route;
  avDriver: Driver[]=[];
  avVehicle: Vehicle[]=[];

  routeId = this.activatedRoute.snapshot.params['id'];


  constructor(private activatedRoute: ActivatedRoute, private httpService: RoutesHttpService, private formBuilder: FormBuilder,private httpDriverService: DriversHttpService, private httpVehicles: VehiclesHttpService) { }

  ngOnInit(){
    this.httpService.fetchRouteById(this.routeId)
      .subscribe(res => {
        this.avRoute = res;
      })
  }


  availableDrivers(){
    this.httpDriverService.getAvailableDriversForGivenDate(this.avRoute.date).subscribe((response) =>{
      this.avDriver = response;
    })
  }

  availableVehicles(){
    this.httpVehicles.getAvailableVehiclesForGivenDate(this.avRoute.date).subscribe((response) =>{
      this.avVehicle = response;
    })
  }

  submit() {
    this.httpService.update(this.form.value, this.routeId).subscribe();
  }

  form = this.formBuilder.group({
    startAddress: [],
    destinationAddress: [],
    routeLength: [],
    transportType: [],
    transportVolume: [],
    date: [],
    driver:[],
    vehicle:[]
  });

  //todo ustawic datę na obecną a nie -1
}
