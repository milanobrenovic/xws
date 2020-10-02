import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TransportationVehicle } from 'C:/Users/Petar/workspace1/xws/Frontend/src/app/models/transportationVehicle';
import {ReservationDate } from 'app/models/reservationDate';

@Injectable()
export class TransportationVehicleService  {
  transportationVehicleList : string;
  freeTransportationVehicleList : string;
  reserveTransportationVehicle : string;


  constructor(private http: HttpClient) { 
    this.transportationVehicleList = 'http://localhost:8087/authentication/agencyVehicles'
    this.freeTransportationVehicleList = 'http://localhost:8087/authentication/freeAgencyVehicles'
    this.reserveTransportationVehicle = 'http://localhost:8087/authentication/reserveTransportation'
  
  }

   public getVehicles() : Observable<any> {
      return this.http.get<Set<TransportationVehicle>>(this.transportationVehicleList);
   }
   public getFreeVehicles(reservationDate : ReservationDate) : Observable<any> {
    return this.http.post<Set<TransportationVehicle>>(this.freeTransportationVehicleList,reservationDate);
 }
  public reserveTransportation(reservationDate : ReservationDate,idAgency : number,idLogged :number) : Observable<any> {
    return this.http.post<any>(this.reserveTransportationVehicle+'/'+ idAgency+'/'+idLogged,reservationDate);
  }
  
   public getAgencyOfLogged() : Observable<any> {
    return this.http.get<any>('http://localhost:8087/authentication/agencyOfLogged');
 }

   

  
      
}