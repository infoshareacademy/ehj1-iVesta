import {Vehicle} from "./vehicle";
import {Driver} from "./driver";

export interface Route {
  id: string;
  startAddress: string;
  destinationAddress: string;
  routeLength: number;
  transportType: string;
  transportVolume: string;
  date: string;
  vehicle: Vehicle;
  driver: Driver;
}
