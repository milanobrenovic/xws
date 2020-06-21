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

  constructor(
    private httpClient: HttpClient,
  ) { }

  public createNewCarRequest(requestToRent: RequestToRent) {
    return this.httpClient.post(this._createCarRentRequest, requestToRent);
  }

}
