import { Injectable } from '@angular/core';
import { environment } from 'environments/environment';
import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Vehicle } from 'app/models/vehicle';
import { Ad } from 'app/models/ad';
import { Subject, Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  url = environment.baseUrl;
  _createNewVehicle = this.url + environment.createNewVehicle;
  _getAllVehicles = this.url + environment.getAllVehicles;
  _getVehicleDetails = this.url + environment.vehicleDetails;
  _getMostKMVehicle = this.url + environment.vehicleMostKM;
  _getBestGradeVehicle = this.url + environment.vehicleBestGrade;
  _uploadImage = this.url + environment.uploadImage;
  _updateVehicle = this.url + environment.updateVehicle;
  _getImage = this.url + environment.getImage;
  _getAllImages = this.url + environment.getAllImages;

  constructor(
    private httpClient: HttpClient,
  ) { }

  public createNewVehicle(vehicle: Vehicle) {
    return this.httpClient.post(this._createNewVehicle, vehicle);
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

  public uploadImage(image: File): Observable<any> {
    const formData = new FormData();

    formData.append("imageFile", image);

    return this.httpClient.post(this._uploadImage, formData);
  }

  public updateVehicle(vehicle: Vehicle, id: BigInteger){
    return this.httpClient.put(this._updateVehicle + "/" + id, vehicle);
  }

  public getImage(id: number){
    return this.httpClient.get(this._getImage + "/" + id, {responseType: 'blob'});
  }

  public getAllImages(id: number){
    return this.httpClient.get(this._getAllImages + "/" + id);
  }

}
