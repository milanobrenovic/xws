import { Component, OnInit } from '@angular/core';
import { Agency } from 'C:/Users/Petar/workspace1/xws/Frontend/src/app/models/agency';
import { Router } from '@angular/router';
import { AgencyService } from './other-agencies.service';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ContractRequest } from 'app/models/contractRequest';
import { NormalUser } from 'C:/Users/Petar/workspace1/xws/Frontend/src/app/models/normalUser';
import { QualifiedUsersService } from 'C:/Users/Petar/workspace1/xws/Frontend/src/app/main/qualified-users/qualified-users.service';
import { MatTableDataSource } from '@angular/material/table';
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
  selector: 'app-other-agencies',
  templateUrl: './other-agencies.component.html',
  styleUrls: ['./other-agencies.component.scss']
})
export class OtherAgenciesComponent implements OnInit {
  public agencies : Set<Agency>;
  id : number;
  idAgency: number;
  public agencyListForm: FormGroup;
  public displayedColumns: string[] = ['id', 'agencyName','request'];
  public ListDataSource = new MatTableDataSource<Agency>();



  constructor(private service : AgencyService, router: Router,private _formBuilder: FormBuilder) { 
    this.agencies = new Set<Agency>();
  }

  ngOnInit(): void {
    var formattedObject: Array<Agency>=[];
    this.service.getAgencyOfLogged().subscribe(response =>{
      this.idAgency = response;
      
    });
    this.service.getOtherAgencies().subscribe(response =>{
      this.agencies = response;
      response.forEach(agency =>{
       
        formattedObject.push(agency);
      })
      this.ListDataSource = new MatTableDataSource(formattedObject);

    });
    this.agencyListForm = this._formBuilder.group({
      id: new FormControl(null),
      agencyName: new FormControl(null),
      
    
    });
  }
  public request(idA : number){
  

    alert(idA);
    
    const contractRequest = new ContractRequest(
      this.idAgency,
      idA,
      
    );

    this.service.getAgencyOfLogged().subscribe(response =>{
      this.idAgency = response;
      
    });
    this.service.request(contractRequest,idA).subscribe(response =>{
      alert('Poslato');
    })
  }
}
