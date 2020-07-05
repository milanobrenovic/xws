import { Injectable } from '@angular/core';
import { environment } from 'environments/environment';
import { HttpClient } from '@angular/common/http';
import { Vehicle } from 'app/models/vehicle';
import { Ad } from 'app/models/ad';

@Injectable({
  providedIn: 'root'
})
export class AdService {

  url = environment.baseUrl;
  _searchAd = this.url + environment.searchAd;
  _createNewAd = this.url + environment.createNewAd;

  constructor(
    private httpClient: HttpClient,
  ) { }

  public createNewAd(ad: Ad) {
    return this.httpClient.post(this._createNewAd, ad);
  }

  public searchAd(ad: Ad) {
    console.log(ad);
    return this.httpClient.post(this._searchAd, ad);
  }

}
