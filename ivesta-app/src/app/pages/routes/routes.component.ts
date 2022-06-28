import {Component, OnInit} from '@angular/core';
import {Route} from "../../model/route";
import {RoutesHttpService} from "./routes-http.service";

@Component({
  selector: 'app-routes',
  templateUrl: './routes.component.html',
  styleUrls: ['./routes.component.css']
})
export class RoutesComponent implements OnInit {

  routes?: Route[] = [];

  constructor(private routeService: RoutesHttpService) {
  }

  ngOnInit(): void {
    this.fetchRoutes();
  }

  fetchRoutes() {
    this.routeService.fetch().subscribe(response => {
      this.routes = response;
    });
  }

  deleteRouteById(removeCandidate: string) {
    if (confirm("Czy jesteś pewien?")) {
      this.routeService.delete(removeCandidate).subscribe(() => this.fetchRoutes())
    }
  }
  setTransportType(type: string){
    if (type == 'CARGO'){
      return "Transport towarów"
    }return "Transport osób";
  }
}
