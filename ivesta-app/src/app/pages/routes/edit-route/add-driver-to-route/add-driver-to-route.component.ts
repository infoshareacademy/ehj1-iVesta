import {Component, OnInit} from '@angular/core';
import {Route} from "../../../../model/route";
import {Driver} from "../../../../model/driver";
import {ActivatedRoute} from "@angular/router";
import {RoutesHttpService} from "../../routes-http.service";
import {FormBuilder} from "@angular/forms";
import {DriversHttpService} from "../../../drivers/drivers-http.service";

@Component({
  selector: 'app-add-driver-to-route',
  templateUrl: './add-driver-to-route.component.html',
  styleUrls: ['./add-driver-to-route.component.css']
})
export class AddDriverToRouteComponent implements OnInit {

  avRoute: Route;
  avDriver: Driver[] = [];
  routeId = this.activatedRoute.snapshot.params['id'];

  constructor(private activatedRoute: ActivatedRoute, private httpService: RoutesHttpService, private formBuilder: FormBuilder, private httpDriverService: DriversHttpService) {
  }

  ngOnInit(): void {
    this.httpService.fetchRouteById(this.routeId)
      .subscribe(res => {
        this.avRoute = res;
      })
  }

  availableDrivers() {
    this.httpDriverService.getAvailableDriversForGivenDate(this.avRoute.date).subscribe((response) => {
      this.avDriver = response;
    })
  }

  addDriverToRoute(driverId: string) {
    this.httpService.addDriverToRoute(driverId, this.routeId).subscribe();
  }

  submit() {
    this.addDriverToRoute(this.form.value)
    this.form.reset();
    alert('Kierowca został dodany do trasy');
  }

  form = this.formBuilder.group({
    driverId: [],
  })

}
