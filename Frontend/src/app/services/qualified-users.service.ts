import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NormalUser } from 'C:/Users/Petar/workspace1/xws/Frontend/src/app/models/normalUser';

@Injectable()
export class QualifiedUsersService  {
  listOfUsersUrl : string;
  buttonUrl : string;


  constructor(private http: HttpClient) { 
    this.listOfUsersUrl = 'http://localhost:8087/authentication/allQualifiedUsers'
    this.buttonUrl = 'http://localhost:8087/authentication/addToAgency/'
  }

   public getAllQualified() : Observable<any> {
      return this.http.get<Set<NormalUser>>(this.listOfUsersUrl);
   }

  
      
}