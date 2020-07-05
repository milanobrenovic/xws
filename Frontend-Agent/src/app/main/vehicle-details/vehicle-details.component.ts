import { Component, OnInit, ViewChild } from '@angular/core';
import { environment } from 'environments/environment';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { Vehicle } from 'app/models/vehicle';
import { ToastrService } from 'ngx-toastr';
import { VehicleService } from 'app/services/vehicle.service';
import { ActivatedRoute } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-vehicle-details',
  templateUrl: './vehicle-details.component.html',
  styleUrls: ['./vehicle-details.component.scss']
})
export class VehicleDetailsComponent implements OnInit {

  public displayedColumns: string[] = ['brand', 'model', 'price', 'travelledMileage', 'plannedMileageToTravel',
    'isMileageUnlimited', 'hasCollisionDamageWaiver', 'numberOfSeats', 'grade', 'available', 'vehicleDiscount',
    'insurancePrice'];
  public itemsPerPage = environment.itemsPerPage;
  public vehicleDetailsDataSource = new MatTableDataSource<Vehicle>();

  public image = undefined;

  @ViewChild(MatPaginator, { static: true })
  paginator: MatPaginator;

  @ViewChild(MatSort, { static: true })
  sort: MatSort;
  
  constructor(
    private _toastrService: ToastrService,
    private _vehicleService: VehicleService,
    private _route: ActivatedRoute,
    public domSanitizer: DomSanitizer,
  ) { }

  ngOnInit(): void {
    this.fetchData();
    this.fetchImage();
  }

  private fetchData() {
    const id = this._route.snapshot.paramMap.get("id");

    this._vehicleService.getVehicleById(+id).subscribe(
      (data: any) => {
        var list = Array<Vehicle>(data);
        this.vehicleDetailsDataSource = new MatTableDataSource(list);
        this.vehicleDetailsDataSource.paginator = this.paginator;
        this.vehicleDetailsDataSource.sort = this.sort;
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to get details about this vehicle");
      }
    );
  }

  private fetchImage(){
    const id = this._route.snapshot.paramMap.get("id");
    this._vehicleService.getImage(+id).subscribe(
      (data: any) => { 
        console.log(data);
        const reader = new FileReader();
        reader.onload = (e) => this.image = e.target.result;
        reader.readAsDataURL(new Blob([data]));

      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to get images about this vehicle");
      }

    );
  }

}
