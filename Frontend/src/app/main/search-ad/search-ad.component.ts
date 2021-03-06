import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { AdService } from 'app/services/ad.service';
import { List } from 'lodash';
import { HttpErrorResponse } from '@angular/common/http';
import { formatDate } from '@angular/common';
import { Ad } from 'app/models/ad';
import { environment } from 'environments/environment';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { CartService } from 'app/services/cart.service';
import { UserService } from 'app/services/user.service';
import { Cart } from 'app/models/cart';
import { Vehicle } from 'app/models/vehicle';

@Component({
  selector: 'app-search-ad',
  templateUrl: './search-ad.component.html',
  styleUrls: ['./search-ad.component.scss']
})
export class SearchAdComponent implements OnInit {

  public searchAdForm: FormGroup;
  public ads: object;
  public displayedColumns: string[] = ['pickupLocation', 'pickupFrom', 'pickupTo', 'details', 'addToCart'];
  public itemsPerPage = environment.itemsPerPage;
  public adSearchDataSource = new MatTableDataSource<Ad>();

  @ViewChild(MatPaginator, { static: true })
  paginator: MatPaginator;

  @ViewChild(MatSort, { static: true })
  sort: MatSort;

  constructor(
    private _toastrService: ToastrService,
    private _adService: AdService,
    private _formBuilder: FormBuilder,
    private _cartService: CartService,
    private _userService: UserService,
  ) { }

  ngOnInit(): void {
    this.searchAdForm = this._formBuilder.group({
      pickupLocation: new FormControl(null, [Validators.required]),
      pickupFrom: new FormControl(null, [Validators.required]),
      pickupTo: new FormControl(null, [Validators.required]),
    });
  }

  searchAd(): void {
    const pickupFrom = formatDate(this.searchAdForm.value.pickupFrom, 'yyyy-MM-dd HH:mm', 'en-US');
    const pickupTo = formatDate(this.searchAdForm.value.pickupTo, 'yyyy-MM-dd HH:mm', 'en-US');

    const ad = new Ad(
      null,
      this.searchAdForm.value.pickupLocation,
      new Date(pickupFrom),
      new Date(pickupTo),
    );

    this._adService.searchAd(ad).subscribe(
      (data: any) => {
        var formattedObject: Array<Ad> = [];

        data.forEach(adObject => {
          const pickupFrom = formatDate(adObject.pickupFrom, 'yyyy-MM-dd HH:mm', 'en-US');
          const pickupTo = formatDate(adObject.pickupTo, 'yyyy-MM-dd HH:mm', 'en-US');
          adObject.pickupFrom = pickupFrom;
          adObject.pickupTo = pickupTo;
          adObject.details = "/pages/vehicle-details/" + adObject.vehicle;
          formattedObject.push(adObject);
        });
        
        this.adSearchDataSource = new MatTableDataSource(formattedObject);
        this.adSearchDataSource.paginator = this.paginator;
        this.adSearchDataSource.sort = this.sort;
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to search ads");
      }
    );
  }

  public addToCart(element: Ad) {
    const userId = this._userService.getLoggedInUser().id;
    
    this._cartService.getCartRentId(userId).subscribe(
      (cartId: number) => {
        var cart = new Cart(cartId, userId);
        this._cartService.addVehicleToCartRent(element.vehicle, cart.id).subscribe(
          (data: Cart) => {
            console.log(data);
            this._toastrService.success("Item added to cart successfully.", "Success");
          },
          (e: HttpErrorResponse) => {
            this._toastrService.error(e.message, "Failed to create new cart rent");
          }
        );
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to get cart rent id");
      }
    );
  }

}
