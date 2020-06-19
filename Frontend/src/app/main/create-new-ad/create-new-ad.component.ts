import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { VehicleService } from 'app/services/vehicle.service';
import { Ad } from 'app/models/ad';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-create-new-ad',
  templateUrl: './create-new-ad.component.html',
  styleUrls: ['./create-new-ad.component.scss']
})
export class CreateNewAdComponent implements OnInit {

  public createNewAdForm: FormGroup;

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
  }

  createNewAd(): void {
    const ad = new Ad(
      this.createNewAdForm.value.selectedVehicle,
      this.createNewAdForm.value.pickupLocation,
      this.createNewAdForm.value.pickupFrom,
      this.createNewAdForm.value.pickupTo,
    );
    this._vehicleService.createNewAd(ad).subscribe(
      () => {
				this._toastrService.success("New ad created successfully.", "Success");
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to create a new ad");
      }
    );
  }

}
