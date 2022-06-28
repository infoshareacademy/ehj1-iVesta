import {Component, OnInit} from '@angular/core';
import {Driver} from "../../model/driver";
import {DriversHttpService} from "./drivers-http.service";

@Component({
  selector: 'app-drivers',
  templateUrl: './drivers.component.html',
  styleUrls: ['./drivers.component.css']
})
export class DriversComponent implements OnInit {

  drivers: Driver[] = [];

  constructor(private driverService: DriversHttpService) { }

  ngOnInit(): void {
  this.fetchDrivers();
  }

  fetchDrivers() {
    this.driverService.fetch().subscribe(response => {
      this.drivers = response;
    })
  }

  deleteDriverById(removeCandidate: string) {
    if (confirm("Czy jesteś pewien?")) {
      this.driverService.delete(removeCandidate).subscribe(() => {
        this.fetchDrivers();
      })
    }
  }
  setStatus(status: string){
    if (status == 'active'){
      return "Aktywny"
    }return "Nieaktywny";
  }
  checkIfCanDelete(status: string, removeCandidate: string){
    if (status == 'active'){
      return confirm("Nie można usunąć aktywnego pracownika.")
    }return this.deleteDriverById(removeCandidate)
  }

}
