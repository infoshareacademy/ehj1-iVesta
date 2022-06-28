import {Component, OnInit} from '@angular/core';
import {Vehicle} from "../../model/vehicle";
import {VehiclesHttpService} from "./vehicles-http.service";

@Component({
  selector: 'app-vehicles',
  templateUrl: './vehicles.component.html',
  styleUrls: ['./vehicles.component.css']
})
export class VehiclesComponent implements OnInit {

  vehicles?: Vehicle[] = [];

  constructor(private vehicleService: VehiclesHttpService) {
  }

  ngOnInit(): void {
    this.fetchVehicles();
  }

  fetchVehicles() {
    this.vehicleService.fetch().subscribe(response => {
      this.vehicles = response;
    })
  }

  deleteVehicleById(removeCandidate: string) {
    if (confirm("Czy jesteś pewien?")) {
      this.vehicleService.delete(removeCandidate).subscribe(() => this.fetchVehicles())
    }
  }

  setStatus(status: string){
    if (status == 'active'){
      return "Aktywny"
    }return "Nieaktywny";
  }

  setTransportType(type: string){
    if (type == 'CARGO'){
      return "Ciężarowy"
    }return "Osobowy";
  }
}
