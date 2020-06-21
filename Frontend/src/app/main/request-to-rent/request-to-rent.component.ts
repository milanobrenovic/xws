import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { List } from 'lodash';
import { ToastrService } from 'ngx-toastr';
import { VehicleService } from 'app/services/vehicle.service';
import { RequestToRent } from 'app/models/requestToRent';
import { RequestToRentService } from 'app/services/request-to-rent.service';
import { formatDate } from '@angular/common';
import { Ad } from 'app/models/ad';
import { HttpErrorResponse } from '@angular/common/http';
import { UserService } from 'app/services/user.service';
import { AdService } from 'app/services/ad.service';

@Component({
  selector: 'app-request-to-rent',
  templateUrl: './request-to-rent.component.html',
  styleUrls: ['./request-to-rent.component.scss']
})
export class RequestToRentComponent implements OnInit {

  public createNewCarRequestForm: FormGroup;
  public ads: List<Ad>;

  constructor(
    private _toastrService: ToastrService,
    private _requestToRentService: RequestToRentService,
    private _formBuilder: FormBuilder,
    private _userService: UserService,
    private _adService: AdService,
  ) { }

  ngOnInit(): void {
    this.createNewCarRequestForm = this._formBuilder.group({
      selectedAd: new FormControl(null, [Validators.required]),
      rentDateFrom: new FormControl(null, [Validators.required]),
      rentDateTo: new FormControl(null, [Validators.required]),
    });

    this._adService.getAllAds().subscribe(
      (data: List<Ad>) => {
        this.ads = data;
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to fetch all ads");
      }
    );
  }

  createNewRentRequest() {
    const pickupFrom = formatDate(this.createNewCarRequestForm.value.rentDateFrom, 'yyyy-MM-dd HH:mm', 'en-US');
    const pickupTo = formatDate(this.createNewCarRequestForm.value.rentDateFrom, 'yyyy-MM-dd HH:mm', 'en-US');
    
    const userId = this._userService.getLoggedInUser().id;

    const requestToRent = new RequestToRent(
      userId,
      this.createNewCarRequestForm.value.selectedAd.vehicle,
      new Date(pickupFrom),
      new Date(pickupTo),
    );
    this._requestToRentService.createNewCarRequest(requestToRent).subscribe(
      () => {
        this.createNewCarRequestForm.reset();
				this._toastrService.success("New car request to rent created successfully.", "Success");
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to create a new car request rent");
      }
    );
  }

}
