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

@Component({
  selector: 'app-vehicle-statistic',
  templateUrl: './vehicle-statistic.component.html',
  styleUrls: ['./vehicle-statistic.component.scss']
})
export class VehicleStatisticComponent implements OnInit {

  public displayedColumns: string[] = ['brand', 'model', 'travelledMileage','numberOfSeats', 'grade'];
  public itemsPerPage = environment.itemsPerPage;
  public vehicleHighestMileageDataSource = new MatTableDataSource<Vehicle>();
  public vehicleBestGradeDataSource = new MatTableDataSource<Vehicle>();

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
    this.fetchData2();
  }

  private fetchData() {
    const id = this._route.snapshot.paramMap.get("id");

    this._vehicleService.getMostKMVehicle().subscribe(
      (data: any) => {
        var list = Array<Vehicle>(data);
        this.vehicleHighestMileageDataSource = new MatTableDataSource(list);
        this.vehicleHighestMileageDataSource.paginator = this.paginator;
        this.vehicleHighestMileageDataSource.sort = this.sort;
      },
      (e: HttpErrorResponse) => {
        this._toastrService.error(e.message, "Failed to get vehicle with highest mileage.");
      }
    );

  }

  private fetchData2(){
    this._vehicleService.getBestGradeVehicle().subscribe(
      (data: any) => {
        var list = Array<Vehicle>(data);
        this.vehicleBestGradeDataSource = new MatTableDataSource(list);
        this.vehicleBestGradeDataSource.paginator = this.paginator;
        this.vehicleBestGradeDataSource.sort = this.sort;
      },
      (e: HttpErrorResponse) => {
        this._toastrService.error(e.message, "Failed to get vehicle with best grade."); 
      }
    );
  }
}
