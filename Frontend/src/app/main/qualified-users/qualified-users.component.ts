import { Component, OnInit } from '@angular/core';
import { NormalUser } from 'C:/Users/Petar/workspace1/xws/Frontend/src/app/models/normalUser';
import { Router } from '@angular/router';
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
  selector: 'app-qualified-users',
  templateUrl: './qualified-users.component.html',
  styleUrls: ['./qualified-users.component.scss']
})
export class QualifiedUsersComponent  implements OnInit{
  public users : Set<NormalUser>;
  id: number;
  idAgency: number;
  public ListDataSource = new MatTableDataSource<NormalUser>();
  public displayedColumns: string[] = ['username', 'firstName','lastName','email','addToAgency'];

  constructor(private service: QualifiedUsersService , private router: Router) { 
      this.users = new Set<NormalUser>();
  }

  ngOnInit(): void {
    var formattedObject: Array<NormalUser>=[];
      this.service.getAllQualified().subscribe(response =>{
        this.users = response;
        response.forEach(userObject =>{
          console.log(userObject.firstName);
          formattedObject.push(userObject);
        })
        this.ListDataSource = new MatTableDataSource(formattedObject);
      });
      this.service.getAgencyOfLogged().subscribe(response =>{
        this.idAgency = response;
        
      });


  }

  public addToAgency(idAgency1 :number,id: number){
    this.service.getAgencyOfLogged().subscribe(response =>{
      this.idAgency = response;
      
    });


    this.service.addToAgency(this.idAgency,id).subscribe(response =>  {
    });
    
}

}
