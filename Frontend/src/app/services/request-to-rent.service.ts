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
  _getRequestDetails = this.url + environment.getRequestDetails;

  constructor(
    private httpClient: HttpClient,
  ) { }

  public createNewCarRequest(requestToRent: RequestToRent) {
    return this.httpClient.post(this._createCarRentRequest, requestToRent);
  }

  public getRequestToRentDetails(userId: number) {
    return this.httpClient.get(this._getRequestDetails + "/" + userId);
  }

}
