import { Injectable } from '@angular/core';
import { environment } from 'environments/environment';
import { HttpClient } from '@angular/common/http';
import { Cart } from 'app/models/cart';
import { Vehicle } from 'app/models/vehicle';
import { RequestToRentDate } from 'app/models/requestToRentDate';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  private url = environment.baseUrl;
  private _createCartRent = this.url + environment.createCartRent;
  private _addVehicleToCartRent = this.url + environment.addVehicleToCartRent;
  private _getCartRentId = this.url + environment.getCartRentId;
  private _getCartRent = this.url + environment.getCartRent;
  private _getAllCartVehicles = this.url + environment.getAllCartVehicles;
  private _createRequestFromCart = this.url + environment.createRequestFromCart;

  constructor(
    private httpClient: HttpClient,
  ) { }
  
  public createNewCartRent(cart: Cart) {
    return this.httpClient.post(this._createCartRent, cart);
  }

  public getCartRentId(userId: number) {
    return this.httpClient.get(this._getCartRentId + "/" + userId);
  }

  public getCartRent(userId: number) {
    return this.httpClient.get(this._getCartRent + "/" + userId);
  }

  public getAllCartVehicles(cartId: number) {
    return this.httpClient.get(this._getAllCartVehicles + "/" + cartId);
  }

  public addVehicleToCartRent(vehicleId: number, cartId: number) {
    return this.httpClient.post(this._addVehicleToCartRent + "/" + vehicleId + "/to/" + cartId, null);
  }

  public createRequestFromCart(cartId: number, requestToRentDate: RequestToRentDate) {
    return this.httpClient.post(this._createRequestFromCart + "/" + cartId, requestToRentDate);
  }
  
}
