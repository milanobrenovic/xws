import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { UserTokenState } from 'app/models/userTokenState';
import { UserService } from 'app/services/user.service';

@Injectable({
  providedIn: 'root'
})
export class NormalUserGuard implements CanActivate {

  public userTokenState: UserTokenState;

  constructor(
    private router: Router,
    private userService: UserService,
  ) { }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    this.userTokenState = this.userService.getLoggedInUser();

    if (this.userTokenState) {
      if (this.userTokenState.role == "ROLE_NORMAL_USER") {
        return true;
      } else {
        this.router.navigate(['/errors/unauthorized']);
        return false;
      }
    }

    this.router.navigate(['/errors/unauthenticated']);
    return false;
  }
  
}
