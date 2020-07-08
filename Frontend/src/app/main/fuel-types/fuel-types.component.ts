import { Component, OnInit, ViewChild } from '@angular/core';
import { environment } from 'environments/environment';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { ToastrService } from 'ngx-toastr';
import { VehicleService } from 'app/services/vehicle.service';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { CodebookType } from 'app/models/codebookType';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-fuel-types',
  templateUrl: './fuel-types.component.html',
  styleUrls: ['./fuel-types.component.scss']
})
export class FuelTypesComponent implements OnInit {

  public displayedColumns: string[] = ['id', 'type'];
  public itemsPerPage = environment.itemsPerPage;
  public fuelTypesDataSource = new MatTableDataSource<CodebookType>();
  public createFuelTypeForm: FormGroup;

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
    this.fetchAllFuelTypes();

    this.createFuelTypeForm = this._formBuilder.group({
      type: new FormControl(null, [Validators.required]),
    });
  }
  
  private fetchAllFuelTypes(){
    this._vehicleService.getAllFuelTypes().subscribe(
      (data: Array<CodebookType>) => {
        this.fuelTypesDataSource = new MatTableDataSource(data);
        this.fuelTypesDataSource.paginator = this.paginator;
        this.fuelTypesDataSource.sort = this.sort;
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to get existing fuel types");
      }
    );
  }

  addFuelType(): void {

    const codebookType = new CodebookType(
      0, // id hardkodovan
      this.createFuelTypeForm.value.type,
    );
    this._vehicleService.createFuelType(codebookType).subscribe(
      () => {
        this.createFuelTypeForm.reset();
				this._toastrService.success("New fuel type added successfully.", "Success");
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to create new fuel type");
      }
    );
  }

}
