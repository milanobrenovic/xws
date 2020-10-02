import { Injectable } from '@angular/core';
import { environment } from 'environments/environment';
import { HttpClient } from '@angular/common/http';
import { RequestToRent } from 'app/models/requestToRent';

@Injectable({
  providedIn: 'root'
})
export class RequestToRentService {

  url = environment.baseUrl;
  _createCarRentRequest = this.url + environment.createCarRentRequest;
  _getRequestDetails = this.url + environment.requestToShowForUser;
  _getRequestDetails1 = this.url + environment.requestToRentForUser;
  _acceptRequestToRent = this.url + environment.acceptRequestToRent;
  _declineRequestToRent = this.url + environment.declineRequestToRent;

  constructor(
    private httpClient: HttpClient,
  ) { }

  public createNewCarRequest(requestToRent: RequestToRent) {
    return this.httpClient.post("http://localhost:8087/car-rent-microservice/createRequest", requestToRent);
  }

  public getRequestToRentDetails(userId: number) {
    return this.httpClient.get(this._getRequestDetails + "/" + userId);
  }

  public getRequestToRentDetails1(userId: number) {
    return this.httpClient.get(this._getRequestDetails1 + "/" + userId);
  }

  public acceptRequestToRent(requestId: number) {
    return this.httpClient.get("http://localhost:8087/car-rent-microservice/acceptRequest" + "/" + requestId);
  }

  public declineRequestToRent(requestId: number) {
    return this.httpClient.get("http://localhost:8087/car-rent-microservice/declineRequest" + "/" + requestId);
  }

}
