import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { List } from 'lodash';
import { CodebookType } from 'app/models/codebookType';
import { ToastrService } from 'ngx-toastr';
import { VehicleService } from 'app/services/vehicle.service';
import { Vehicle } from 'app/models/vehicle';
import { HttpErrorResponse } from '@angular/common/http';
import { MatTableDataSource } from '@angular/material/table';
import { Ad } from 'app/models/ad';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-advanced-search',
  templateUrl: './advanced-search.component.html',
  styleUrls: ['./advanced-search.component.scss']
})
export class AdvancedSearchComponent implements OnInit {

  public advancedSearchVehiclesForm: FormGroup;
  public fuelTypes: List<CodebookType>;
  public vehicleTypes: List<CodebookType>;
  public transmissionTypes: List<CodebookType>;
  public advancedSearchResultsDataSource = new MatTableDataSource<Vehicle>();
  public displayedColumns: string[] = ['brand', 'model', 'fuelType', 'vehicleType', 'transmissionType',
    'price', 'travelledMileage', 'plannedMileageToTravel', 'isMileageUnlimited', 'hasCollisionDamageWaiver',
    'numberOfSeats', 'grade', 'available', 'vehicleDiscount', 'insurancePrice'];

  @ViewChild(MatPaginator, { static: true })
  paginator: MatPaginator;

  @ViewChild(MatSort, { static: true })
  sort: MatSort;
  
  constructor(
    private _toastrService: ToastrService,
    private _vehicleService: VehicleService,
    private _formBuilder: FormBuilder,
  ) { }

  ngOnInit(): void {
    this.advancedSearchVehiclesForm = this._formBuilder.group({
      brand: new FormControl(null),
      model: new FormControl(null),
      fuelType: new FormControl(null),
      vehicleType: new FormControl(null),
      transmissionType: new FormControl(null),
      price: new FormControl(null),
      travelledMileage: new FormControl(null),
      plannedMileageToTravel: new FormControl(null),
      isMileageUnlimited: new FormControl(false),
      hasCollisionDamageWaiver: new FormControl(false),
      numberOfSeats: new FormControl(null),
      grade: new FormControl(null),
      available: new FormControl(false),
      vehicleDiscount: new FormControl(null),
      insurancePrice: new FormControl(null),
    });

    this._vehicleService.getAllFuelTypes().subscribe(
      (data: Array<CodebookType>) => {
        this.fuelTypes = data;
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to get existing fuel types");
      }
    );

    this._vehicleService.getAllVehicleTypes().subscribe(
      (data: Array<CodebookType>) => {
        this.vehicleTypes = data;
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to get existing vehicle types");
      }
    );

    this._vehicleService.getAllTransmissionTypes().subscribe(
      (data: Array<CodebookType>) => {
        this.transmissionTypes = data;
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to get existing transmission types");
      }
    );
  }

  public advancedSearchVehicles() {
    var vehicleToQuery = new Vehicle(
      this.advancedSearchVehiclesForm.value.brand,
      this.advancedSearchVehiclesForm.value.model,
      this.advancedSearchVehiclesForm.value.fuelType,
      this.advancedSearchVehiclesForm.value.vehicleType,
      this.advancedSearchVehiclesForm.value.transmissionType,
      this.advancedSearchVehiclesForm.value.price,
      this.advancedSearchVehiclesForm.value.travelledMileage,
      this.advancedSearchVehiclesForm.value.plannedMileageToTravel,
      this.advancedSearchVehiclesForm.value.isMileageUnlimited,
      this.advancedSearchVehiclesForm.value.hasCollisionDamageWaiver,
      this.advancedSearchVehiclesForm.value.numberOfSeats,
      this.advancedSearchVehiclesForm.value.grade,
      this.advancedSearchVehiclesForm.value.available,
      this.advancedSearchVehiclesForm.value.vehicleDiscount,
      this.advancedSearchVehiclesForm.value.insurancePrice,
    );
    console.log(vehicleToQuery);
    this._vehicleService.advancedSearchVehicles(vehicleToQuery).subscribe(
      (queriedVehicles: Array<Vehicle>) => {
        this._toastrService.success("Results found successfully.", "Success");
        
        console.log(queriedVehicles);
        
        this.advancedSearchResultsDataSource = new MatTableDataSource(queriedVehicles);
        this.advancedSearchResultsDataSource.paginator = this.paginator;
        this.advancedSearchResultsDataSource.sort = this.sort;
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to do advanced search");
      }
    );
  }

}
