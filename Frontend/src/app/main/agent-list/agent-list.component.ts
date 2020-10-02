import { Router } from '@angular/router';
import { AgentListService } from 'C:/Users/Petar/workspace1/xws/Frontend/src/app/main/agent-list/agent-list.service'
import { Component, OnInit } from '@angular/core';
import { NormalUser } from 'C:/Users/Petar/workspace1/xws/Frontend/src/app/models/normalUser';
import { QualifiedUsersService } from 'C:/Users/Petar/workspace1/xws/Frontend/src/app/main/qualified-users/qualified-users.service';
import { MatTableDataSource } from '@angular/material/table';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { AdService } from 'app/services/ad.service';
import { List } from 'lodash';
import { HttpErrorResponse } from '@angular/common/http';
import { formatDate } from '@angular/common';
import { Ad } from 'app/models/ad';
import { environment } from 'environments/environment';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { CartService } from 'app/services/cart.service';
import { UserService } from 'app/services/user.service';
import { Cart } from 'app/models/cart';
import { Vehicle } from 'app/models/vehicle';
@Component({
  selector: 'app-agent-list',
  templateUrl: './agent-list.component.html',
  styleUrls: ['./agent-list.component.scss']
})
export class AgentListComponent implements OnInit {
  public agents : Set<NormalUser>;
  public eliteAgents : Set<NormalUser>;
  id : number;
  idAgency: number;
  public displayedColumns: string[] = ['username', 'firstName','lastName','email','addToAgency','demote'];

  public ListDataSource = new MatTableDataSource<NormalUser>();
  public ListDataSource2 = new MatTableDataSource<NormalUser>();



  constructor(private service: AgentListService,private router : Router) {
      this.agents = new Set<NormalUser>();
      this.eliteAgents = new Set<NormalUser>();
   }

  ngOnInit(): void {
    var formattedObject: Array<NormalUser>=[];
    var formattedObject2: Array<NormalUser>=[];
    this.service.getAgents().subscribe(response => {
      this.agents = response;
      response.forEach(userObject =>{
        console.log(userObject.id);
        formattedObject.push(userObject);
      })
      this.ListDataSource = new MatTableDataSource(formattedObject);

    });
    this.service.getEliteAgents().subscribe(response =>{
      this.eliteAgents = response;
      response.forEach(userObject =>{
        console.log(userObject.id);
        formattedObject2.push(userObject);
      })
      this.ListDataSource2 = new MatTableDataSource(formattedObject2);

    });
    this.service.getAgencyOfLogged().subscribe(response => {
      this.idAgency = response;
    });

  }

  public promote(idAgency1 : number,id : number){
    this.service.getAgencyOfLogged().subscribe(response =>{
      this.idAgency = response;
      
    });

    this.service.promote(this.idAgency,id).subscribe(response =>{

    });



  }

  public demote(idAgency1 : number,id : number){
    this.service.getAgencyOfLogged().subscribe(response =>{
      this.idAgency = response;
      
    });

    this.service.demote(this.idAgency,id).subscribe(response =>{

    });



  }


}
