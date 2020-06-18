import { Injectable } from '@angular/core';
import { environment } from 'environments/environment';
import { HttpClient } from '@angular/common/http';
import { Vehicle } from 'app/models/vehicle';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  url = environment.baseUrl;
  _createNewVehicle = this.url + environment.createNewVehicle;

  constructor(
    private httpClient: HttpClient,
  ) { }

  public createNewVehicle(vehicle: Vehicle) {
    return this.httpClient.post(this._createNewVehicle, vehicle);
  }

}
