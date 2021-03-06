import { Component, OnInit, ViewChild } from '@angular/core';
import { environment } from 'environments/environment';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { NormalUser } from 'app/models/normalUser';
import { UserService } from 'app/services/user.service';
import { ActivatedRoute } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { HttpErrorResponse } from '@angular/common/http';
import { Agent } from 'app/models/agent';

@Component({
  selector: 'app-user-access',
  templateUrl: './user-access.component.html',
  styleUrls: ['./user-access.component.scss']
})
export class UserAccessComponent implements OnInit {

  public displayedNormalUserColumns: string[] = ['id', 'username', 'firstName', 'lastName', 'email',
    'country', 'phoneNumber', 'numberOfAds', 'isBanned', 'actions'];
    public displayedAgentColumns: string[] = ['id', 'username', 'firstName', 'lastName', 'email',
      'companyName', 'businessRegistrationNumber', 'address', 'isBanned', 'actions'];
  public itemsPerPage = environment.itemsPerPage;
  public normalUsersDataSource = new MatTableDataSource<NormalUser>();
  public agentsDataSource = new MatTableDataSource<Agent>();

  @ViewChild(MatPaginator, { static: true })
  paginator: MatPaginator;

  @ViewChild(MatSort, { static: true })
  sort: MatSort;

  constructor(
    private _toastrService: ToastrService,
    private _userService: UserService,
    private _route: ActivatedRoute,
  ) { }

  ngOnInit(): void {
    this.fetchAllNormalUsers();
    this.fetchAllAgents();
  }

  private fetchAllNormalUsers() {
    this._userService.getAllNormalUsers().subscribe(
      (data: Array<NormalUser>) => {
        this.normalUsersDataSource = new MatTableDataSource(data);
        this.normalUsersDataSource.paginator = this.paginator;
        this.normalUsersDataSource.sort = this.sort;
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to get normal users");
      }
    );
  }

  private fetchAllAgents() {
    this._userService.getAllAgents().subscribe(
      (data: Array<Agent>) => {
        this.agentsDataSource = new MatTableDataSource(data);
        this.agentsDataSource.paginator = this.paginator;
        this.agentsDataSource.sort = this.sort;
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to get agents");
      }
    );
  }

  public blockNormalUser(element: NormalUser) {
    this._userService.blockNormalUser(element.username).subscribe(
      () => {
        this.fetchAllNormalUsers();
				this._toastrService.success("User banned successfully.", "Success");
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to block normal user");
      }
    );
  }

  public unblockNormalUser(element: NormalUser) {
    this._userService.unblockNormalUser(element.username).subscribe(
      () => {
        this.fetchAllNormalUsers();
				this._toastrService.success("User unbanned successfully.", "Success");
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to unblock normal user");
      }
    );
  }

  public blockAgent(element: Agent) {
    this._userService.blockAgent(element.username).subscribe(
      () => {
        this.fetchAllAgents();
				this._toastrService.success("Agent banned successfully.", "Success");
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to block agent");
      }
    );
  }

  public unblockAgent(element: Agent) {
    this._userService.unblockAgent(element.username).subscribe(
      () => {
        this.fetchAllAgents();
				this._toastrService.success("Agent unbanned successfully.", "Success");
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed to unblock agent");
      }
    );
  }

}
