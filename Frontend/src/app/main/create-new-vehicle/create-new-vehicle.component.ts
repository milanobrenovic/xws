import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { VehicleService } from 'app/services/vehicle.service';
import { Vehicle } from 'app/models/vehicle';
import { HttpErrorResponse } from '@angular/common/http';
import { CodebookType } from 'app/models/codebookType';
import { MatTableDataSource } from '@angular/material/table';
import { List } from 'lodash';

@Component({
  selector: 'app-create-new-vehicle',
  templateUrl: './create-new-vehicle.component.html',
  styleUrls: ['./create-new-vehicle.component.scss']
})
export class CreateNewVehicleComponent implements OnInit {
  
  public createNewVehicleForm: FormGroup;
  public fuelTypes: List<CodebookType>;
  public vehicleTypes: List<CodebookType>;
  public transmissionTypes: List<CodebookType>;

  constructor(
    private _toastrService: ToastrService,
    private _vehicleService: VehicleService,
    private _formBuilder: FormBuilder,
  ) { }

  ngOnInit(): void {
    this.createNewVehicleForm = this._formBuilder.group({
      brand: new FormControl(null, [Validators.required]),
      model: new FormControl(null, [Validators.required]),
      fuelType: new FormControl(null, [Validators.required]),
      vehicleType: new FormControl(null, [Validators.required]),
      transmissionType: new FormControl(null, [Validators.required]),
      price: new FormControl(null, [Validators.required]),
      travelledMileage: new FormControl(null, [Validators.required]),
      plannedMileageToTravel: new FormControl(null, [Validators.required]),
      isMileageUnlimited: new FormControl(false),
      hasCollisionDamageWaiver: new FormControl(false),
      numberOfSeats: new FormControl(null, [Validators.required]),
      grade: new FormControl(null, [Validators.required]),
      available: new FormControl(false, [Validators.required]),
      vehicleDiscount: new FormControl(null, [Validators.required]),
      insurancePrice: new FormControl(null, [Validators.required]),
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

  addNewVehicle(): void {
    const vehicle = new Vehicle(
      this.createNewVehicleForm.value.brand,
      this.createNewVehicleForm.value.model,
      this.createNewVehicleForm.value.fuelType,
      this.createNewVehicleForm.value.vehicleType,
      this.createNewVehicleForm.value.transmissionType,
      this.createNewVehicleForm.value.price,
      this.createNewVehicleForm.value.travelledMileage,
      this.createNewVehicleForm.value.plannedMileageToTravel,
      this.createNewVehicleForm.value.isMileageUnlimited,
      this.createNewVehicleForm.value.hasCollisionDamageWaiver,
      this.createNewVehicleForm.value.numberOfSeats,
      this.createNewVehicleForm.value.grade,
      this.createNewVehicleForm.value.available,
      this.createNewVehicleForm.value.vehicleDiscount,
      this.createNewVehicleForm.value.insurancePrice,
    );
    this._vehicleService.createNewVehicle(vehicle).subscribe(
      () => {
        this.createNewVehicleForm.reset();
				this._toastrService.success("New vehicle added successfully.", "Success");
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to add a new vehicle");
      }
    );
  }

}
