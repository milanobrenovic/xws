import { Injectable } from '@angular/core';
import { environment } from 'environments/environment';
import { HttpClient } from '@angular/common/http';
import { Vehicle } from 'app/models/vehicle';
import { Ad } from 'app/models/ad';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  url = environment.baseUrl;
  _createNewVehicle = this.url + environment.createNewVehicle;
  _createNewAd = this.url + environment.createNewAd;

  constructor(
    private httpClient: HttpClient,
  ) { }

  public createNewVehicle(vehicle: Vehicle) {
    return this.httpClient.post(this._createNewVehicle, vehicle);
  }

  public createNewAd(ad: Ad) {
    return this.httpClient.post(this._createNewAd, ad);
  }

}
