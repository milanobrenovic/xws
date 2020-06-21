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

@Component({
  selector: 'app-request-details',
  templateUrl: './request-details.component.html',
  styleUrls: ['./request-details.component.scss']
})
export class RequestDetailsComponent implements OnInit {

  public displayedColumns: string[] = ['id', 'vehicleId', 'normalUser', 'requestStatusType',
  'rentDateFrom', 'rentDateTo'];
  public itemsPerPage = environment.itemsPerPage;
  public requestDetailsDataSource = new MatTableDataSource<RequestToRentDetails>();

  @ViewChild(MatPaginator, { static: true })
  paginator: MatPaginator;

  @ViewChild(MatSort, { static: true })
  sort: MatSort;
  
  constructor(
    private _toastrService: ToastrService,
    private _requestToRentService: RequestToRentService,
    private _userService: UserService,
  ) { }

  ngOnInit(): void {
    const id = this._userService.getLoggedInUser().id;
    
    this._requestToRentService.getRequestToRentDetails(+id).subscribe(
      (data: any) => {
        var formattedObject: Array<RequestToRentDetails> = [];

        data.forEach(adObject => {
          const rentDateFrom = formatDate(adObject.rentDateFrom, 'yyyy-MM-dd HH:mm', 'en-US');
          const rentDateTo = formatDate(adObject.rentDateTo, 'yyyy-MM-dd HH:mm', 'en-US');
          adObject.rentDateFrom = rentDateFrom;
          adObject.rentDateTo = rentDateTo;
          formattedObject.push(adObject);
        });

        this.requestDetailsDataSource = new MatTableDataSource(data);
        this.requestDetailsDataSource.paginator = this.paginator;
        this.requestDetailsDataSource.sort = this.sort;
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to get details about this request");
      }
    );
  }

}
