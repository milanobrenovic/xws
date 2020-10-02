import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TransportationVehicle } from 'app/models/transportationVehicle';
import { ReservationDate } from 'app/models/reservationDate';

@Injectable()
export class CreateTransportationVehicleService  {
  createVehicle : string;
  


  constructor(private http: HttpClient) { 
    this.createVehicle = 'http://localhost:8087/authentication/createVehicle'

  
  }

   public createTransportationVehicle(transportationVehicle : TransportationVehicle, idAgency : number) : Observable<any> {
    return this.http.post<TransportationVehicle>(this.createVehicle+'/'+idAgency,transportationVehicle);
 }
  
  
   public getAgencyOfLogged() : Observable<any> {
    return this.http.get<any>('http://localhost:8087/authentication/agencyOfLogged');
 }

   

  
      
}