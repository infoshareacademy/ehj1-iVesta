import { Component, OnInit } from '@angular/core';
import {Route} from "../../../model/route";
import {ActivatedRoute} from "@angular/router";
import {FormBuilder} from "@angular/forms";
import {RoutesHttpService} from "../routes-http.service";

@Component({
  selector: 'app-edit-route',
  templateUrl: './edit-route.component.html',
  styleUrls: ['./edit-route.component.css']
})
export class EditRouteComponent implements OnInit {
  route: Route;

  routeId = this.activatedRoute.snapshot.params['id'];

  constructor(private activatedRoute: ActivatedRoute, private httpService: RoutesHttpService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.httpService.fetchRouteById(this.routeId)
      .subscribe(res => {
        this.route = res;
      })
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

  submit() {
    console.log(this.form.value)
    this.httpService.update(this.form.value, this.routeId).subscribe();
  }

}
