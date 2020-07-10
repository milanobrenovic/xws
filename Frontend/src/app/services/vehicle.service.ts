import { Injectable } from '@angular/core';
import { environment } from 'environments/environment';
import { HttpClient } from '@angular/common/http';
import { Vehicle } from 'app/models/vehicle';
import { Ad } from 'app/models/ad';
import { Subject, Observable, BehaviorSubject } from 'rxjs';
import { CodebookType } from 'app/models/codebookType';

@Injectable({
  providedIn: 'root'
})
export class VehicleService {

  url = environment.baseUrl;
  _createNewVehicle = this.url + environment.createNewVehicle;
  _createNewAd = this.url + environment.createNewAd;
  _getAllVehicles = this.url + environment.getAllVehicles;
  _getVehicleDetails = this.url + environment.vehicleDetails;
  _uploadImage = this.url + environment.uploadImage;
  _updateVehicle = this.url + environment.updateVehicle;
  _getImage = this.url + environment.getImage;
  _getAllImages = this.url + environment.getAllImages;
  _getAllFuelTypes = this.url + environment.getAllFuelTypes;
  _getAllTransmissionTypes = this.url + environment.getAllTransmissionTypes;
  _getAllVehicleTypes = this.url + environment.getAllVehicleTypes;
  _createFuelType = this.url + environment.createFuelType;
  _createTransmissionType = this.url + environment.createTransmissionType;
  _createVehicleType = this.url + environment.createVehicleType;
  _getAllVehiclesFromCart = this.url + environment.getAllVehiclesFromCart;

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

  public getAllFuelTypes(){
    return this.httpClient.get(this._getAllFuelTypes);
  }

  public getAllTransmissionTypes(){
    return this.httpClient.get(this._getAllTransmissionTypes);
  }

  public getAllVehicleTypes(){
    return this.httpClient.get(this._getAllVehicleTypes);
  }

  public createFuelType(codebookType: CodebookType){
    return this.httpClient.post(this._createFuelType, codebookType);
  }

  public createTransmissionType(codebookType: CodebookType){
    return this.httpClient.post(this._createTransmissionType, codebookType);
  }

  public createVehicleType(codebookType: CodebookType){
    return this.httpClient.post(this._createVehicleType, codebookType);
  }

  public getAllVehiclesFromCart(vehicleIds: Array<number>){
    return this.httpClient.post(this._getAllVehiclesFromCart, vehicleIds);
  }
}
