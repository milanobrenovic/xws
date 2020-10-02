import { Component, OnInit, ViewChild } from '@angular/core';
import { environment } from 'environments/environment';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { ToastrService } from 'ngx-toastr';
import { RequestToRentDetails } from 'app/models/requestToRentDetails';
import { RequestToRentService } from 'app/services/request-to-rent.service';
import { UserService } from 'app/services/user.service';
import { HttpErrorResponse } from '@angular/common/http';
import { formatDate } from '@angular/common';
import { CartService } from 'app/services/cart.service';

@Component({
  selector: 'app-request-details',
  templateUrl: './request-details.component.html',
  styleUrls: ['./request-details.component.scss']
})
export class RequestDetailsComponent implements OnInit {

  public displayedColumns: string[] = ['id', 'vehicleId', 'normalUser', 'requestStatusType',
  'rentDateFrom', 'rentDateTo', 'options'];
  public itemsPerPage = environment.itemsPerPage;
  public requestDetailsDataSource = new MatTableDataSource<RequestToRentDetails>();
  public requestsToShowForUserThatRequestedDataSource = new MatTableDataSource<RequestToRentDetails>();

  @ViewChild(MatPaginator, { static: true })
  paginator: MatPaginator;

  @ViewChild(MatSort, { static: true })
  sort: MatSort;
  
  constructor(
    private _toastrService: ToastrService,
    private _requestToRentService: RequestToRentService,
    private _userService: UserService,
    private _cartService: CartService,
  ) { }

  ngOnInit(): void {
    this.fetchData();
    this.fetchRequestsForUser();
  }

  fetchData() {
    const id = this._userService.getLoggedInUser().id;
    const userRole = this._userService.getLoggedInUser().role;

    this._cartService.requestToShowForUser(id, userRole).subscribe(
      (data: any) => {
        var formattedObject: Array<RequestToRentDetails> = [];

        data.forEach(adObject => {
          const rentDateFrom = formatDate(adObject.rentDateFrom, 'yyyy-MM-dd HH:mm', 'en-US');
          const rentDateTo = formatDate(adObject.rentDateTo, 'yyyy-MM-dd HH:mm', 'en-US');
          adObject.rentDateFrom = rentDateFrom;
          adObject.rentDateTo = rentDateTo;
          formattedObject.push(adObject);
        });

        this.requestDetailsDataSource = new MatTableDataSource(formattedObject);
        this.requestDetailsDataSource.paginator = this.paginator;
        this.requestDetailsDataSource.sort = this.sort;
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed create a new review");
      }
    );
  }
    
  //   this._requestToRentService.requestToShowForUser(+id, role).subscribe(
  //     (data: any) => {
  //       console.log(data);
  //       var formattedObject: Array<RequestToRentDetails> = [];

  //       data.forEach(adObject => {
  //         const rentDateFrom = formatDate(adObject.rentDateFrom, 'yyyy-MM-dd HH:mm', 'en-US');
  //         const rentDateTo = formatDate(adObject.rentDateTo, 'yyyy-MM-dd HH:mm', 'en-US');
  //         adObject.rentDateFrom = rentDateFrom;
  //         adObject.rentDateTo = rentDateTo;
  //         formattedObject.push(adObject);
  //       });

  //       this.requestDetailsDataSource = new MatTableDataSource(formattedObject);
  //       this.requestDetailsDataSource.paginator = this.paginator;
  //       this.requestDetailsDataSource.sort = this.sort;
  //     },
  //     (e: HttpErrorResponse) => {
	// 			this._toastrService.error(e.message, "Failed to get details about this request");
  //     }
  //   );
  // }

  acceptRequest(data: RequestToRentDetails) {
    this._requestToRentService.acceptRequestToRent(data.id).subscribe(
      () => {
        this._toastrService.success("Request has been accepted.", "Success");
        this.fetchData();
      },
      (e: HttpErrorResponse) => {
        this._toastrService.error(e.message, "Failed to accept this request");
      }
    );
  }

  declineRequest(data: RequestToRentDetails) {
    this._requestToRentService.declineRequestToRent(data.id).subscribe(
      (data) => {
        this._toastrService.success("Request has been declined.", "Success");
        this.fetchData();
      },
      (e: HttpErrorResponse) => {
        this._toastrService.error(e.message, "Failed to decline this request");
      }
    );
  }

  public payRequest(element: RequestToRentDetails) {
    this._cartService.payVehicle(element.id).subscribe(
      (data) => {
        this._toastrService.success("Vehicle paid successfully.", "Success");
        this.fetchData();
      },
      (e: HttpErrorResponse) => {
        this._toastrService.error(e.message, "Failed to buy vehicle");
      }
    );
  }

  private fetchRequestsForUser() {
    const userId = this._userService.getLoggedInUser().id;
    const userRole = this._userService.getLoggedInUser().role;
    console.log(userId);
    console.log(userRole);
    
    this._cartService.requestToRentForUser(userId).subscribe(
      (data: Array<RequestToRentDetails>) => {
        this.requestsToShowForUserThatRequestedDataSource = new MatTableDataSource(data);
        this.requestsToShowForUserThatRequestedDataSource.paginator = this.paginator;
        this.requestsToShowForUserThatRequestedDataSource.sort = this.sort;
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed create a new review");
      }
    );
  }

}
