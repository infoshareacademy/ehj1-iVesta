import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {FormBuilder} from "@angular/forms";
import {Vehicle} from "../../../model/vehicle";
import {VehiclesHttpService} from "../vehicles-http.service";

@Component({
  selector: 'app-edit-vehicle',
  templateUrl: './edit-vehicle.component.html',
  styleUrls: ['./edit-vehicle.component.css']
})
export class EditVehicleComponent implements OnInit {
  license: string;
  vehicle: Vehicle;

  vehicleId = this.activatedRoute.snapshot.params['id'];

  constructor(private activatedRoute: ActivatedRoute, private formBuilder: FormBuilder, private httpService: VehiclesHttpService) { }

  ngOnInit(): void {
  }
  form = this.formBuilder.group({
    marka: [],
    model: [],
    "kategoria-pojazdu": [],
    license: [],
    "liczba-miejsc-ogolem": [],
    "rodzaj-paliwa": [],
    "max-ladownosc": []
  });

  submit(){
    console.log(this.form.value)
    this.httpService.update(this.form.value, this.vehicleId).subscribe();
    console.log(this.form.value)
    this.form.reset();
  }

  licenseName = [ 'AM', 'A1', 'A2', 'A', 'B', 'B1', 'B+E', 'C', 'C1', 'C1+E', 'C+E', 'D', 'D1', 'D1+E', 'D+E', 'T']
}
