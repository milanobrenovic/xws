import { Injectable } from '@angular/core';
import { environment } from 'environments/environment';
import { HttpClient } from '@angular/common/http';
import { Vehicle } from 'app/models/vehicle';
import { Ad } from 'app/models/ad';
import { Subject, Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  url = environment.baseUrl;
  _createNewVehicle = this.url + environment.createNewVehicle;
  _createNewAd = this.url + environment.createNewAd;
  _getAllVehicles = this.url + environment.getAllVehicles;
  _getVehicleDetails = this.url + environment.vehicleDetails;
  _getMostKMVehicle = this.url + environment.vehicleMostKM;
  _getBestGradeVehicle = this.url + environment.vehicleBestGrade;

  constructor(
    private httpClient: HttpClient,
  ) { }

  public createNewVehicle(vehicle: Vehicle) {
    return this.httpClient.post(this._createNewVehicle, vehicle);
  }

  public createNewAd(ad: Ad) {
    return this.httpClient.post(this._createNewAd, ad);
  }

  public getAllVehicles() {
    return this.httpClient.get(this._getAllVehicles);
  }

  public getVehicleById(id: number) {
    return this.httpClient.get(this._getVehicleDetails + "/" + id);
  }

  public getMostKMVehicle(){
    return this.httpClient.get(this._getMostKMVehicle);
  }

  public getBestGradeVehicle(){
    return this.httpClient.get(this._getBestGradeVehicle);
  }

}
