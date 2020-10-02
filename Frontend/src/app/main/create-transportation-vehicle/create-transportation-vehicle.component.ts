import { Component, OnInit } from '@angular/core';
import { TransportationVehicle } from 'C:/Users/Petar/workspace1/xws/Frontend/src/app/models/transportationVehicle';
import { Router } from '@angular/router';
import { CreateTransportationVehicleService } from './create-transportation-vehicle.service';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ReservationDate } from 'app/models/reservationDate';
import { AgentListService } from 'C:/Users/Petar/workspace1/xws/Frontend/src/app/main/agent-list/agent-list.service'
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
import { CodebookType } from 'app/models/codebookType';

@Component({
  selector: 'app-create-transportation-vehicle',
  templateUrl: './create-transportation-vehicle.component.html',
  styleUrls: ['./create-transportation-vehicle.component.scss']
})
export class CreateTransportationVehicleComponent implements OnInit {
  id : number;
  idAgency: number;

  transportationVehicle : TransportationVehicle;
  public createNewVehicleForm: FormGroup;



  constructor(private service : CreateTransportationVehicleService , router: Router,private _formBuilder: FormBuilder) { 
 
    this.transportationVehicle = new TransportationVehicle(null,null);
    
  }

  ngOnInit(): void {
    this.service.getAgencyOfLogged().subscribe(response =>{
      this.idAgency = response;
      
    });
    this.createNewVehicleForm = this._formBuilder.group({
      brand: new FormControl(null),
      model: new FormControl(null),
      type: new FormControl(null),
    
    });
  }


  public createVehicle(idAgent : number){
    
    alert(this.createNewVehicleForm.value.type);

    const vehicle = new TransportationVehicle(
      
      this.createNewVehicleForm.value.brand,
      this.createNewVehicleForm.value.model,
      this.createNewVehicleForm.value.type
    );

    this.service.getAgencyOfLogged().subscribe(response =>{
      this.idAgency = response;
      alert(vehicle.brand);
      alert(vehicle.model);
      alert(vehicle.type);
      
    });
    this.service.createTransportationVehicle(vehicle,this.idAgency).subscribe(response =>{
      
      alert('kreirano novo vozilo');
    })
  }

}
