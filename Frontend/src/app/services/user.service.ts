import { Injectable } from '@angular/core';
import { environment } from 'environments/environment';
import { BehaviorSubject, Observable } from 'rxjs';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { map } from 'rxjs/operators';
import { UserTokenState } from 'app/models/userTokenState';
import { UserLoginRequest } from 'app/models/userLoginRequest';
import { List } from 'lodash';
import { NormalUser } from 'app/models/normalUser';
import { Agent } from 'app/models/agent';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private _url = environment.baseUrl;
  private _login = this._url + environment.login;
  private _register = this._url + environment.register;
  private _getAllNormalUsers = this._url + environment.getAllNormalUsers;
  private _getAllAgents = this._url + environment.getAllAgents;

  jwt_access_token = null;
  req: UserTokenState;
  loggedInUserSubject: BehaviorSubject<UserTokenState>;
  loggedInUser: Observable<UserTokenState>;
  loggedInSuccess: BehaviorSubject<UserTokenState> = new BehaviorSubject<UserTokenState>(null);

  constructor(private httpClient: HttpClient, private router: Router) {
    this.loggedInUserSubject = new BehaviorSubject<UserTokenState>(
      JSON.parse(localStorage.getItem('LoggedInUser'))
    );
    this.loggedInUser = this.loggedInUserSubject.asObservable();
  }

  getLoggedInUser(): UserTokenState {
    return this.loggedInUserSubject.value;
  }

  login(user: UserLoginRequest) {
    return this.httpClient.post(this._login, user).pipe(map((res: UserTokenState) => {
      this.jwt_access_token = res.jwtAccessToken;
      localStorage.setItem('LoggedInUser', JSON.stringify(res));
      localStorage.setItem('role', JSON.stringify(res.role));
      localStorage.setItem('id', JSON.stringify(res.id));
      this.loggedInUserSubject.next(res);
    }));
  }

  register(user: UserLoginRequest) {
    return this.httpClient.post(this._register, user);
  }
  
  getToken() {
    return this.jwt_access_token;
  }

  logout() {
    this.jwt_access_token = null;
    localStorage.removeItem('LoggedInUser');
    this.router.navigate(['/pages/login']);
  }

  isLoggedIn(): boolean {
    return localStorage.getItem('LoggedInUser') !== null;
  }

  public getAllNormalUsers() {
    return this.httpClient.get(this._getAllNormalUsers);
  }

  public getAllAgents() {
    return this.httpClient.get(this._getAllAgents);
  }

}
