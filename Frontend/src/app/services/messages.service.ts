import { Injectable } from '@angular/core';
import { environment } from 'environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MessagesService {

  url = environment.baseUrl;
  _getAllSentMessages = this.url + environment.getAllSentMessages;
  _getAllReceivedMessages = this.url + environment.getAllReceivedMessages;

  constructor(
    private httpClient: HttpClient,
  ) { }
  
  public getAllSentMessages(senderId: number) {
    return this.httpClient.get(this._getAllSentMessages + "/" + senderId);
  }
  
  public getAllReceivedMessages(receiverId: number) {
    return this.httpClient.get(this._getAllReceivedMessages + "/" + receiverId);
  }

}
