import { Component, OnInit } from '@angular/core';
import { TransportationVehicle } from 'C:/Users/Petar/workspace1/xws/Frontend/src/app/models/transportationVehicle';
import { Router } from '@angular/router';
import { TransportationVehicleService } from './transporation-vehicle-list.service';
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
@Component({
  selector: 'app-transporation-vehicle-list',
  templateUrl: './transporation-vehicle-list.component.html',
  styleUrls: ['./transporation-vehicle-list.component.scss']
})
export class TransporationVehicleListComponent implements OnInit {
  public transportationVehicles : Set<TransportationVehicle>;
  public freeTransportationVehicles : Set<TransportationVehicle>;
  id : number;
  idAgency: number;
  from: Date;
  to: Date;
  reservationDate : ReservationDate;
  public freeVehiclesForm: FormGroup;
  public displayedColumns: string[] = ['brand', 'model','type','addToAgency'];
  public ListDataSource = new MatTableDataSource<TransportationVehicle>();
  public ListDataSource2 = new MatTableDataSource<TransportationVehicle>();




  constructor(private service : TransportationVehicleService , router: Router,private _formBuilder: FormBuilder) { 
    this.transportationVehicles = new Set<TransportationVehicle>();
    this.freeTransportationVehicles = new Set<TransportationVehicle>();
    this.reservationDate = new ReservationDate(null,null);
    
  }

  ngOnInit(): void {
    var formattedObject: Array<TransportationVehicle>=[];
    this.service.getAgencyOfLogged().subscribe(response =>{
      this.idAgency = response;
      
    });
    this.service.getVehicles().subscribe(response =>{
      this.transportationVehicles = response;
      response.forEach(vehicle =>{
        console.log(vehicle.id);
        formattedObject.push(vehicle);
      })
      this.ListDataSource = new MatTableDataSource(formattedObject);

    });

   /* this.freeVehiclesForm = this._formBuilder.group({
      from: new FormControl(null),
      to: new FormControl(null),
    });*/


  }

  public showFreeVehicles(){
   // const from = this.freeVehiclesForm.value.from;
  //  const to = this.freeVehiclesForm.value.to;
  var formattedObject: Array<TransportationVehicle>=[];

    alert("from:"+this.from);
    alert("from:"+this.to);
    
    this.reservationDate.rentDateFrom = this.from;
    this.reservationDate.rentDateTo = this.to;
    alert(this.reservationDate.rentDateFrom);
    this.service.getFreeVehicles(this.reservationDate).subscribe(response =>{
      this.freeTransportationVehicles = response;
      response.forEach(vehicle =>{
        console.log(vehicle.id);
        formattedObject.push(vehicle);
      })
      this.ListDataSource2 = new MatTableDataSource(formattedObject);

    });

   



  }

  public reserveTransportationVehicle(idAgent : number){
  


    var reservationDate = new ReservationDate(
      this.from,
      this.to
    );

    this.service.getAgencyOfLogged().subscribe(response =>{
      this.idAgency = response;
      
    });
    this.service.reserveTransportation(reservationDate,this.idAgency,idAgent).subscribe(response =>{
      console.log('rezervisano');
    })
  }

}
