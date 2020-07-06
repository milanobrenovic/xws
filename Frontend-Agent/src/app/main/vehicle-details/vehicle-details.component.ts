import { Component, OnInit, ViewChild } from '@angular/core';
import { environment } from 'environments/environment';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { Vehicle } from 'app/models/vehicle';
import { ToastrService } from 'ngx-toastr';
import { VehicleService } from 'app/services/vehicle.service';
import { ActivatedRoute } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';

@Component({
  selector: 'app-vehicle-details',
  templateUrl: './vehicle-details.component.html',
  styleUrls: ['./vehicle-details.component.scss']
})
export class VehicleDetailsComponent implements OnInit {

  public displayedColumns: string[] = ['brand', 'model', 'price', 'travelledMileage', 'plannedMileageToTravel',
    'isMileageUnlimited', 'hasCollisionDamageWaiver', 'numberOfSeats', 'grade', 'available', 'vehicleDiscount',
    'insurancePrice'];
  public itemsPerPage = environment.itemsPerPage;
  public vehicleDetailsDataSource = new MatTableDataSource<Vehicle>();

  public images: Array<object> = [];
  public imageIDs: Array<number>;

  @ViewChild(MatPaginator, { static: true })
  paginator: MatPaginator;

  @ViewChild(MatSort, { static: true })
  sort: MatSort;
  
  constructor(
    private _toastrService: ToastrService,
    private _vehicleService: VehicleService,
    private _route: ActivatedRoute,
    public domSanitizer: DomSanitizer,
  ) { }

  ngOnInit(): void {
    this.fetchData();
    // this.fetchImage(1);
    this.fetchAllImages();
  }

  private fetchData() {
    const id = this._route.snapshot.paramMap.get("id");

    this._vehicleService.getVehicleById(+id).subscribe(
      (data: any) => {
        var list = Array<Vehicle>(data);
        this.vehicleDetailsDataSource = new MatTableDataSource(list);
        this.vehicleDetailsDataSource.paginator = this.paginator;
        this.vehicleDetailsDataSource.sort = this.sort;
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to get details about this vehicle");
      }
    );
  }

  public fetchImage(id: number){
    this._vehicleService.getImage(id).subscribe(
      (data: any) => { 
        const reader = new FileReader();
        reader.onload = (e) => {
          // console.log(e.target.result);
          console.log(this.domSanitizer.bypassSecurityTrustResourceUrl('data:image/jpg;base64,' 
          + e.target.result));
          //this.images.push(this.domSanitizer.bypassSecurityTrustResourceUrl('data:image/jpg;base64,' 
            //    + e.target.result));
          this.images.push(e.target.result as object);
        }
        reader.readAsDataURL(new Blob([data]));
        // console.log(">>> " + typeof(this.images));
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to get one of the images of this vehicle");
      }
    );
  }

  private fetchAllImages(){
    const id = this._route.snapshot.paramMap.get("id");
    this._vehicleService.getAllImages(+id).subscribe(
      (data: any) => { 
        // console.log(data);
        this.imageIDs = data;
        this.imageIDs.forEach(element => {
          this.fetchImage(element);
        });
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to get images of this vehicle");
      }
    );
  }

}
