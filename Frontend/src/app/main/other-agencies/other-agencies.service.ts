import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Agency } from 'C:/Users/Petar/workspace1/xws/Frontend/src/app/models/agency';
import {ContractRequest } from 'app/models/contractRequest';
@Injectable()
export class AgencyService  {
  agencyList : string;
  request1 : string;
 


  constructor(private http: HttpClient) { 
    this.agencyList = 'http://localhost:8087/authentication/otherAgencies'
    this.request1 = 'http://localhost:8087/authentication/requestContract'
  
  }

   public getOtherAgencies() : Observable<any> {
      return this.http.get<Set<Agency>>(this.agencyList);
   }
   public request(contractRequest : ContractRequest,id : number) : Observable<any> {
    return this.http.post<any>(this.request1+'/'+ id,contractRequest);
  }
  
   public getAgencyOfLogged() : Observable<any> {
    return this.http.get<any>('http://localhost:8087/authentication/agencyOfLogged');
 }

   

  
      
}
