import { Component, OnInit, ViewChild } from '@angular/core';
import { environment } from 'environments/environment';
import { MatTableDataSource } from '@angular/material/table';
import { CodebookType } from 'app/models/codebookType';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { ToastrService } from 'ngx-toastr';
import { VehicleService } from 'app/services/vehicle.service';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-vehicle-types',
  templateUrl: './vehicle-types.component.html',
  styleUrls: ['./vehicle-types.component.scss']
})
export class VehicleTypesComponent implements OnInit {

  public displayedColumns: string[] = ['id', 'type'];
  public itemsPerPage = environment.itemsPerPage;
  public vehicleTypesDataSource = new MatTableDataSource<CodebookType>();
  public createVehicleTypeForm: FormGroup;

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
    this.fetchAllVehicleTypes();

    this.createVehicleTypeForm = this._formBuilder.group({
      type: new FormControl(null, [Validators.required]),
    });
  }
  
  private fetchAllVehicleTypes(){
    this._vehicleService.getAllVehicleTypes().subscribe(
      (data: Array<CodebookType>) => {
        this.vehicleTypesDataSource = new MatTableDataSource(data);
        this.vehicleTypesDataSource.paginator = this.paginator;
        this.vehicleTypesDataSource.sort = this.sort;
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to get existing vahicle types");
      }
    );
  }

  addVehicleType(): void {

    const codebookType = new CodebookType(
      0, // id hardkodovan
      this.createVehicleTypeForm.value.type,
    );
    this._vehicleService.createVehicleType(codebookType).subscribe(
      () => {
        this.createVehicleTypeForm.reset();
				this._toastrService.success("New vehicle type added successfully.", "Success");
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to create new vehicle type");
      }
    );
  }
}
