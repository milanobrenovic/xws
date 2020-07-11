import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { CartService } from 'app/services/cart.service';
import { HttpErrorResponse } from '@angular/common/http';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute } from '@angular/router';
import { Review } from 'app/models/review';
import { environment } from 'environments/environment';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { RequestToRentDetails } from 'app/models/requestToRentDetails';
import { UserService } from 'app/services/user.service';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.scss']
})
export class ReviewComponent implements OnInit {
  
  public createNewReviewForm: FormGroup;
  public itemsPerPage = environment.itemsPerPage;

  constructor(
    private _formBuilder: FormBuilder,
    private _cartService: CartService,
    private _toastrService: ToastrService,
    private _userService: UserService,
    private _route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.createNewReviewForm = this._formBuilder.group({
      grade: new FormControl(null, [Validators.required]),
      subject: new FormControl(null, [Validators.required]),
      description: new FormControl(null, [Validators.required]),
    });
  }

  public createNewReview() {
    const requestToRentDetailsId = this._route.snapshot.paramMap.get("requestToRentDetailsId");

    var review = new Review(
      this.createNewReviewForm.value.grade,
      this.createNewReviewForm.value.subject,
      this.createNewReviewForm.value.description,
    );

    this._cartService.createNewReview(+requestToRentDetailsId, review).subscribe(
      (data) => {
        this._toastrService.success("Review created successfully.", "Success");
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed create a new review");
      }
    );
  }

}
