import { Component, OnInit } from '@angular/core';
import { AppComponent } from 'app/app.component';
import { WebSocketAPI } from 'app/models/webSocketAPI';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.scss']
})
export class ChatComponent implements OnInit {

  public webSocketAPI: WebSocketAPI;
  public greeting: any;
  public name: string;
  
  ngOnInit() {
    this.webSocketAPI = new WebSocketAPI(new ChatComponent());
  }

  public connect(){
    this.webSocketAPI._connect();
  }

  public disconnect(){
    this.webSocketAPI._disconnect();
  }

  public sendMessage(){
    this.webSocketAPI._send(this.name);
  }

  public handleMessage(message){
    this.greeting = message;
  }
  
}
