import { Component, OnInit, ViewChild } from '@angular/core';
import { environment } from 'environments/environment';
import { MatTableDataSource } from '@angular/material/table';
import { Mail } from 'app/models/mail';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { ToastrService } from 'ngx-toastr';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { MessagesService } from 'app/services/messages.service';
import { UserService } from 'app/services/user.service';
import { HttpErrorResponse } from '@angular/common/http';
import { formatDate } from '@angular/common';
import { NormalUser } from 'app/models/normalUser';
import { Agent } from 'app/models/agent';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.scss']
})
export class MessagesComponent implements OnInit {

  public displayedColumns: string[] = ['subject', 'content', 'date'];
  public itemsPerPage = environment.itemsPerPage + 5;
  public mailSentDataSource = new MatTableDataSource<Mail>();
  public mailReceivedDataSource = new MatTableDataSource<Mail>();
  public sendPrivateMessageForm: FormGroup;
  public listOfNormalUsers: Array<NormalUser>;
  public listOfAgents: Array<Agent>;
  public listOfAllUsers: Array<Object> = [];

  @ViewChild(MatPaginator, { static: true })
  paginator: MatPaginator;

  @ViewChild(MatSort, { static: true })
  sort: MatSort;

  constructor(
    private _toastrService: ToastrService,
    private _messagesService: MessagesService,
    private _userService: UserService,
    private _formBuilder: FormBuilder,
  ) { }

  ngOnInit(): void {
    this.sendPrivateMessageForm = this._formBuilder.group({
      selectedUser: new FormControl(null, [Validators.required]),
      privateMessage: new FormControl(null, [Validators.required]),
    });
    
    const senderId = this._userService.getLoggedInUser().id;

    this._messagesService.getAllSentMessages(+senderId).subscribe(
      (data: any) => {
        var formattedObject: Array<Mail> = [];

        data.forEach(adObject => {
          const date = formatDate(adObject.date, 'yyyy-MM-dd HH:mm', 'en-US');
          adObject.date = date;
          formattedObject.push(adObject);
        });

        this.mailSentDataSource = new MatTableDataSource(formattedObject);
        this.mailSentDataSource.paginator = this.paginator;
        this.mailSentDataSource.sort = this.sort;
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Failed display all sender messages");
      }
    );
    
    this._messagesService.getAllReceivedMessages(+senderId).subscribe(
      (data: any) => {
        var formattedObject: Array<Mail> = [];

        data.forEach(adObject => {
          const date = formatDate(adObject.date, 'yyyy-MM-dd HH:mm', 'en-US');
          adObject.date = date;
          formattedObject.push(adObject);
        });

        this.mailReceivedDataSource = new MatTableDataSource(formattedObject);
        this.mailReceivedDataSource.paginator = this.paginator;
        this.mailReceivedDataSource.sort = this.sort;
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Could not display all receiver messages");
      }
    );

    this._userService.getAllNormalUsers().subscribe(
      (data: Array<NormalUser>) => {
        this.listOfNormalUsers = data;

        for (let i = 0; i < this.listOfNormalUsers.length; i++) {
          this.listOfAllUsers.push(this.listOfNormalUsers[i]);
        }
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Could not fetch all normal users");
      }
    );

    this._userService.getAllAgents().subscribe(
      (data: Array<Agent>) => {
        this.listOfAgents = data;

        for (let i = 0; i < this.listOfAgents.length; i++) {
          this.listOfAllUsers.push(this.listOfAgents[i]);
        }
      },
      (e: HttpErrorResponse) => {
				this._toastrService.error(e.message, "Could not fetch all agents");
      }
    );
  }

  sendMessage() {
    console.log(this.sendPrivateMessageForm.value.selectedUser);
  }

}
