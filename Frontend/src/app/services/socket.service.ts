import { Injectable } from '@angular/core';
import { environment } from 'environments/environment';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { catchError } from 'rxjs/operators';
import { Message } from 'app/models/message';

@Injectable({
  providedIn: 'root'
})
export class SocketService {

  url: string = "http://localhost:8087" + "/api/socket";
  restUrl:string = "http://localhost:8087" + "/sendMessageRest";

  constructor(private http: HttpClient) { }

  post(data: Message) {
    return this.http.post<Message>(this.url, data).pipe(map
      ((data: Message) => { return data; }))
      // .catch(error => {
      //   //return new ErrorObservable(error);
      // });
  }

  postRest(data: Message) {
    return this.http.post<Message>(this.restUrl, data).pipe(map
      ((data: Message) => { return data; }))
      // .pipe(catchError(error => {
      //   return new ErrorObservable(error);
      // }));
  }
}
