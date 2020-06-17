import { Component, OnInit } from '@angular/core';
import { UserService } from 'app/services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  public loggedInUsername: string;
  public loggedInUserRole: string;

  constructor(
    private _userService: UserService,
    private _router: Router,
  ) { }

  ngOnInit(): void {
    const loggedInUser = this._userService.getLoggedInUser();

    if (loggedInUser == null) {
      this._router.navigate(['/pages/login']);
    }

    this.loggedInUsername = loggedInUser.username;

    if (loggedInUser.role === "ROLE_ADMIN") {
      this.loggedInUserRole = "admin";
    } else if (loggedInUser.role === "ROLE_AGENT") {
      this.loggedInUserRole = "agent";
    } else {
      this.loggedInUserRole = "normal user";
    }
  }

}
