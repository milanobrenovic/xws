import { Component, OnInit, ViewChild } from '@angular/core';
import { CartService } from 'app/services/cart.service';
import { UserService } from 'app/services/user.service';
import { HttpErrorResponse } from '@angular/common/http';
import { ToastrService } from 'ngx-toastr';
import { Cart } from 'app/models/cart';
import { environment } from 'environments/environment';
import { MatTableDataSource } from '@angular/material/table';
import { Vehicle } from 'app/models/vehicle';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { VehicleService } from 'app/services/vehicle.service';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { formatDate } from '@angular/common';
import { RequestToRentDate } from 'app/models/requestToRentDate';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent implements OnInit {

  public displayedColumns: string[] = ['brand', 'model', 'price', 'travelledMileage', 'plannedMileageToTravel',
    'isMileageUnlimited', 'hasCollisionDamageWaiver', 'numberOfSeats', 'grade', 'available', 'vehicleDiscount',
    'insurancePrice'];
  public itemsPerPage = environment.itemsPerPage;
  public cartVehiclesDataSource = new MatTableDataSource<Vehicle>();
  public cartCreated: boolean = false;
  public createRequestToRentFromCartForm: FormGroup;

  private cartId: number;

  @ViewChild(MatPaginator, { static: true })
  paginator: MatPaginator;

  @ViewChild(MatSort, { static: true })
  sort: MatSort;

  constructor(
    private _cartService: CartService,
    private _userService: UserService,
    private _vehicleService: VehicleService,
    private _toastrService: ToastrService,
    private _formBuilder: FormBuilder,
  ) { }

  ngOnInit(): void {
    const userId = this._userService.getLoggedInUser().id;
    
    this._cartService.getCartRent(userId).subscribe(
      (exists: boolean) => {
        if (exists) {
          this.cartCreated = true;

          this.fetchCartId(userId);
        } else {
          this.cartCreated = false;
        }
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to get cart rent object");
      }
    );

    this.createRequestToRentFromCartForm = this._formBuilder.group({
      rentFrom: new FormControl(null, [Validators.required]),
      rentTo: new FormControl(null, [Validators.required]),
    });
  }

  public fetchCartId(userId: number) {
    this._cartService.getCartRentId(userId).subscribe(
      (cartId: number) => {
        this.loadCartVehicles(cartId);
        this.cartId = cartId;
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to get cart rent id");
      }
    );
  }

  public loadCartVehicles(cartId: number) {
    this._cartService.getAllCartVehicles(cartId).subscribe(
      (vehicleIds: Array<number>) => {
        this.fetchCartVehicles(vehicleIds);
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to load all cart vehicles");
      }
    );
  }

  public fetchCartVehicles(vehicleIds: Array<number>) {
    this._vehicleService.getAllVehiclesFromCart(vehicleIds).subscribe(
      (data: any) => {
        console.log(data);
        this.cartVehiclesDataSource = new MatTableDataSource(data);
        this.cartVehiclesDataSource.paginator = this.paginator;
        this.cartVehiclesDataSource.sort = this.sort;
      },
      (e: HttpErrorResponse) => {
        this._toastrService.error(e.message, "Failed to get details about this ad");
      }
    );
  }

  public createNewCartRent() {
    const userId = this._userService.getLoggedInUser().id;
    var cart = new Cart(null, userId);
    this._cartService.createNewCartRent(cart).subscribe(
      (data) => {
				this._toastrService.success("New cart rent created successfully.", "Success");
        this.cartCreated = true;
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Could not create a new cart rent");
      }
    );
  }

  public createRequestToRent() {
    const rentFrom = this.createRequestToRentFromCartForm.value.rentFrom;
    const rentTo = this.createRequestToRentFromCartForm.value.rentTo;

    var requestToRentDate = new RequestToRentDate(
      rentFrom,
      rentTo,
    );
    
    this._cartService.createRequestFromCart(this.cartId, requestToRentDate).subscribe(
      (data) => {
				this._toastrService.success("New cart rent request created successfully.", "Success");
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Could not create a new cart rent request");
      }
    );
  }

}
