import { Component, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { VehicleService } from 'app/services/vehicle.service';
import { FormBuilder, FormControl, Validators, FormGroup } from '@angular/forms';
import { List } from 'lodash';
import { Vehicle } from 'app/models/vehicle';
import { HttpErrorResponse } from '@angular/common/http';
import { ImageFile } from 'app/models/image';

@Component({
  selector: 'app-add-images',
  templateUrl: './add-images.component.html',
  styleUrls: ['./add-images.component.scss']
})
export class AddImagesComponent implements OnInit {

  public addImageForm: FormGroup;
  public vehicles: List<Vehicle>;
    // za slike
  public selectedFile: ImageFile;
  public imageId: BigInteger

  constructor(
    private _toastrService: ToastrService,
    private _vehicleService: VehicleService,
    private _formBuilder: FormBuilder,
  ) { }

  ngOnInit(): void {
    this.addImageForm = this._formBuilder.group({
      selectedVehicle: new FormControl(null, [Validators.required]),
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

  processFile(imageInput: any) {
    const file: File = imageInput.files[0];
    const reader = new FileReader();

    reader.addEventListener('load', (event: any) => {

      this.selectedFile = new ImageFile(event.target.result, file);

      this._vehicleService.uploadImage(this.selectedFile.file).subscribe(
        (res) => {
          console.log(res.id);
          this.imageId = res.id;
        },
        (err) => {
        
        })
    });

    reader.readAsDataURL(file);
  }

  adImage(): void{

    this._vehicleService.updateVehicle(this.addImageForm.value.selectedVehicle, this.imageId).subscribe(
      () => {
        this.addImageForm.reset();
				this._toastrService.success("New image for selected vehicle added successfully.", "Success");
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to add image to vehicle");
      }
    );
  }

}
