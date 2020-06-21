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
  _getAllAds = this.url + environment.getAllAds;

  constructor(
    private httpClient: HttpClient,
  ) { }

  public searchAd(ad: Ad) {
    return this.httpClient.post(this._searchAd, ad);
  }

  public getAllAds() {
    return this.httpClient.get(this._getAllAds);
  }

}
