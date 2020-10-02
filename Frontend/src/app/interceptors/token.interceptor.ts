import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserTokenState } from '../models/userTokenState';
import { UserService } from '../services/user.service';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const userTokenState = localStorage.getItem('LoggedInUser');
    console.log(localStorage.getItem('LoggedInUser'));
    console.log(localStorage);
     console.log(localStorage.getItem("role"));
    if(userTokenState){
       console.log("STIGAO DOVDE++++++++++++++++++++++++++++++");
      request = request.clone(
        {
          setHeaders: {
            Role: JSON.parse(localStorage.getItem("role")),
            Id: localStorage.getItem("id")
          }
        }
      );
    }


    

    return next.handle(request);
  }
  
}