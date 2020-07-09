import { Component, OnInit } from '@angular/core';
import { AppComponent } from 'app/app.component';
import { WebSocketAPI } from 'app/models/webSocketAPI';
import { environment } from 'environments/environment';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { SocketService } from 'app/services/socket.service';
import { Message } from 'app/models/message';
import * as Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
import { UserService } from 'app/services/user.service';

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.scss']
})
export class ChatComponent implements OnInit {

  private serverUrl = "http://localhost:8087/message-microservice" + '/socket';
  private stompClient;
  private form: FormGroup;
  private userForm: FormGroup;

  isLoaded: boolean = false;
  isCustomSocketOpened = false;
  messages: Message[] = [];
  fromId: string;
  username: string;

  constructor(private socketService: SocketService, private toastr: ToastrService, private userService: UserService) { }

  ngOnInit() {
    this.form = new FormGroup({
      message: new FormControl(null, [Validators.required]),
      toId: new FormControl(null)
    })

    this.fromId = (this.userService.getLoggedInUser().id).toString();
    this.username = this.userService.getLoggedInUser().username;

    this.initializeWebSocketConnection();
  
  }

  // Funkcija za otvaranje konekcije sa serverom
  initializeWebSocketConnection() {
    // serverUrl je vrednost koju smo definisali u registerStompEndpoints() metodi na serveru
    let ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(ws);
    let that = this;

    this.stompClient.connect({}, function () {
      that.isLoaded = true;
      that.openGlobalSocket()
    });

  }

  // Funkcija salje poruku na WebSockets endpoint na serveru
  sendMessageUsingSocket() {
    if (this.form.valid) {
      let message: Message = {
        message: this.form.value.message,
        fromId: this.fromId,
        toId: this.form.value.toId
      };

      // Primer slanja poruke preko web socketa sa klijenta. URL je 
      //  - ApplicationDestinationPrefix definisan u config klasi na serveru (configureMessageBroker() metoda) : /socket-subscriber
      //  - vrednost @MessageMapping anotacije iz kontrolera na serveru : /send/message
      this.stompClient.send("/socket-subscriber/send/message", {}, JSON.stringify(message));
    }
  }

  // Funckija salje poruku na REST endpoint na serveru
  sendMessageUsingRest() {
    if (this.form.valid) {
      let message: Message = {
        message: this.form.value.message,
        fromId: this.fromId,
        toId: this.form.value.toId
      };

      this.socketService.postRest(message).subscribe(res => {
        console.log(res);
      })
    }
  }

  // Funckija za pretplatu na topic /socket-publisher (definise se u configureMessageBroker() metodi)
  // Globalni socket se otvara prilikom inicijalizacije klijentske aplikacije
  openGlobalSocket() {
    if (this.isLoaded) {
      this.stompClient.subscribe("/socket-publisher", (message: { body: string; }) => {
        this.handleResult(message);
      });
    }
  }

  // Funkcija za pretplatu na topic /socket-publisher/user-id
  // CustomSocket se otvara kada korisnik unese svoj ID u polje 'fromId' u submit callback-u forme 'userForm'
  public openSocket() {
    console.log(this.fromId);
    if (this.isLoaded) {
      this.isCustomSocketOpened = true;
      this.stompClient.subscribe("/socket-publisher/" + this.fromId, (message: { body: string; }) => {
        this.handleResult(message);
      });
    }
  }

  // Funkcija koja se poziva kada server posalje poruku na topic na koji se klijent pretplatio
  handleResult(message: { body: string; }) {
    if (message.body) {
      let messageResult: Message = JSON.parse(message.body);
      this.messages.push(messageResult);
      this.toastr.success("new message recieved", null, {
        'timeOut': 3000
      });
    }
  }
  
}
