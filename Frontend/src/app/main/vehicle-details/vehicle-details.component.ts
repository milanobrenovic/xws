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

  @ViewChild(MatPaginator, { static: true })
  paginator: MatPaginator;

  @ViewChild(MatSort, { static: true })
  sort: MatSort;
  
  constructor(
    private _toastrService: ToastrService,
    private _vehicleService: VehicleService,
    private _route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.fetchData();
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
				this._toastrService.error(e.message, "Failed to get details about this ad");
      }
    );
  }

}
