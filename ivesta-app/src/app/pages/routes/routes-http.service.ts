import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Route} from "../../model/route";
import {RouteCandidate} from "../../model/route-candidate";
import {forkJoin, map} from "rxjs";
import {VehicleCandidate} from "../../model/vehicle-candidate";

const ROUTES_API_PATH = 'http://localhost:8080/api/routes';

@Injectable({
  providedIn: 'root'
})
export class RoutesHttpService {

  constructor(private http: HttpClient) {
  }

  fetch() {
    return this.http.get<Route[]>(ROUTES_API_PATH);
  }

  fetchRouteById(routeId: string) {
    return this.http.get<Route>(`${ROUTES_API_PATH}/${routeId}`);
  }

  delete(removeCandidate: string) {
    return this.http.delete(`${ROUTES_API_PATH}/${removeCandidate}`);
  }

  create(route: RouteCandidate) {
    return this.http.post<Route>(ROUTES_API_PATH, route);
  }

  update(route: RouteCandidate, routeId: string) {
    return this.http.put<Route>(`${ROUTES_API_PATH}/${routeId}`, route)
  }

  fetchIncompleteRoutes() {
    return forkJoin([this.http.get<[Route]>(`${ROUTES_API_PATH}/incompleteRoutes?withoutDriver=true&withoutVehicle=true`),
      this.http.get<[Route]>(`${ROUTES_API_PATH}/incompleteRoutes?withoutDriver=false&withoutVehicle=true`),
      this.http.get<[Route]>(`${ROUTES_API_PATH}/incompleteRoutes?withoutDriver=true&withoutVehicle=false`)
    ]).pipe(
      map(allRequests => allRequests.flat()),
    )
  }

  addVehicleToRoute(vehicle: VehicleCandidate, routeId: string){
    return this.http.put<Route>(`${ROUTES_API_PATH}/${routeId}/assignVehicle`,vehicle)
  }

  addDriverToRoute(driver: string, routeId: string){
    return this.http.put<Route>(`${ROUTES_API_PATH}/${routeId}/assignDriver`,driver)
  }
}
