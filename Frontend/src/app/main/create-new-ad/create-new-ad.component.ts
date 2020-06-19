import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { VehicleService } from 'app/services/vehicle.service';
import { Ad } from 'app/models/ad';
import { HttpErrorResponse } from '@angular/common/http';
import { List } from 'lodash';
import { Vehicle } from 'app/models/vehicle';
import { formatDate } from '@angular/common';

@Component({
  selector: 'app-create-new-ad',
  templateUrl: './create-new-ad.component.html',
  styleUrls: ['./create-new-ad.component.scss']
})
export class CreateNewAdComponent implements OnInit {

  public createNewAdForm: FormGroup;
  public vehicles: List<Vehicle>;

  constructor(
    private _toastrService: ToastrService,
    private _vehicleService: VehicleService,
    private _formBuilder: FormBuilder,
  ) { }

  ngOnInit(): void {
    this.createNewAdForm = this._formBuilder.group({
      selectedVehicle: new FormControl(null, [Validators.required]),
      pickupLocation: new FormControl(null, [Validators.required]),
      pickupFrom: new FormControl(null, [Validators.required]),
      pickupTo: new FormControl(null, [Validators.required]),
    });

    this._vehicleService.getAllVehicles().subscribe(
      (data: List<Vehicle>) => {
        this.vehicles = data;
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to get all vehicles");
      }
    );
  }

  createNewAd(): void {
    const pickupFrom = formatDate(this.createNewAdForm.value.pickupFrom, 'yyyy-MM-dd HH:mm', 'en-US');
    const pickupTo = formatDate(this.createNewAdForm.value.pickupTo, 'yyyy-MM-dd HH:mm', 'en-US');

    console.log(pickupFrom);
    console.log(pickupTo);
    console.log(new Date(pickupFrom));
    console.log(new Date(pickupTo));

    const ad = new Ad(
      this.createNewAdForm.value.selectedVehicle.id,
      this.createNewAdForm.value.pickupLocation,
      new Date(pickupFrom),
      new Date(pickupTo),
    );
    this._vehicleService.createNewAd(ad).subscribe(
      () => {
        this.createNewAdForm.reset();
				this._toastrService.success("New ad created successfully.", "Success");
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to create a new ad");
      }
    );
  }

}
