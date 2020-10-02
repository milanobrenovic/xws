import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { NormalUser } from 'C:/Users/Petar/workspace1/xws/Frontend/src/app/models/normalUser';

@Injectable()
export class AgentListService  {
  agentsList : string;
  eliteAgentsList : string;
  buttonPromote : string;
  buttonDemote : string;


  constructor(private http: HttpClient) { 
    this.agentsList = 'http://localhost:8087/authentication/agentsOfAgency'
    this.eliteAgentsList = 'http://localhost:8087/authentication/eliteAgentsOfAgency'
    this.buttonPromote = 'http://localhost:8087/authentication/promote'
    this.buttonDemote = 'http://localhost:8087/authentication/demote'
  }

   public getAgents() : Observable<any> {
      return this.http.get<Set<NormalUser>>(this.agentsList);
   }
   public getEliteAgents() : Observable<any> {
    return this.http.get<Set<NormalUser>>(this.eliteAgentsList);
 }
   public getAgencyOfLogged() : Observable<any> {
    return this.http.get<any>('http://localhost:8087/authentication/agencyOfLogged');
 }

   public promote(id2:number,id: number) : Observable<any> {
     return this.http.post<any>(this.buttonPromote+'/'+ id2+ '/' + id ,null);
   }
   public demote(id2:number,id: number) : Observable<any> {
    return this.http.post<any>(this.buttonDemote+'/'+ id2+ '/' + id ,null);
  }

  
      
}