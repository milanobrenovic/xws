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
  selector: 'app-transmission-types',
  templateUrl: './transmission-types.component.html',
  styleUrls: ['./transmission-types.component.scss']
})
export class TransmissionTypesComponent implements OnInit {

  public displayedColumns: string[] = ['id', 'type'];
  public itemsPerPage = environment.itemsPerPage;
  public transmissionTypesDataSource = new MatTableDataSource<CodebookType>();
  public createTransmissionTypeForm: FormGroup;

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
    this.fetchAllTransmissionTypes();

    this.createTransmissionTypeForm = this._formBuilder.group({
      type: new FormControl(null, [Validators.required]),
    });
  }
  
  private fetchAllTransmissionTypes(){
    this._vehicleService.getAllTransmissionTypes().subscribe(
      (data: Array<CodebookType>) => {
        this.transmissionTypesDataSource = new MatTableDataSource(data);
        this.transmissionTypesDataSource.paginator = this.paginator;
        this.transmissionTypesDataSource.sort = this.sort;
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to get existing transmission types");
      }
    );
  }

  addTransmissionType(): void {

    const codebookType = new CodebookType(
      0, // id hardkodovan
      this.createTransmissionTypeForm.value.type,
    );
    this._vehicleService.createTransmissionType(codebookType).subscribe(
      () => {
        this.createTransmissionTypeForm.reset();
				this._toastrService.success("New transmission type added successfully.", "Success");
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to create new transmission type");
      }
    );
  }

}
