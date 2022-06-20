import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {RoutesHttpService} from "../../routes-http.service";
import {FormBuilder} from "@angular/forms";
import {VehiclesHttpService} from "../../../vehicles/vehicles-http.service";
import {Route} from "../../../../model/route";
import {Driver} from "../../../../model/driver";
import {Vehicle} from "../../../../model/vehicle";
import {VehicleCandidate} from "../../../../model/vehicle-candidate";

@Component({
  selector: 'app-add-vehicle-to-route',
  templateUrl: './add-vehicle-to-route.component.html',
  styleUrls: ['./add-vehicle-to-route.component.css']
})
export class AddVehicleToRouteComponent implements OnInit {

  avRoute: Route;
  avVehicle: Vehicle[]=[];

  routeId = this.activatedRoute.snapshot.params['id'];

  constructor(private activatedRoute: ActivatedRoute, private httpService: RoutesHttpService, private formBuilder: FormBuilder,private httpVehicles: VehiclesHttpService) { }


  ngOnInit(): void {
    this.httpService.fetchRouteById(this.routeId)
      .subscribe(res => {
        this.avRoute = res;
      })
  }

  availableVehicles(){
    this.httpVehicles.getAvailableVehiclesForGivenDate(this.avRoute.date).subscribe((response) =>{
      this.avVehicle = response;
    })
  }

  addVehicleToRoute(vehicleId: VehicleCandidate){
    this.httpService.addVehicleToRoute(vehicleId,this.routeId).subscribe();
  }
  submit() {
    this.addVehicleToRoute(this.form.value)
    this.form.reset();
  }

  form = this.formBuilder.group({
    vehicleId: [],
  })

}
