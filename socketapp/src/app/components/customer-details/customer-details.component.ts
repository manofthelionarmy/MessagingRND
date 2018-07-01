import { Customer } from './../../models/customer';
import { DashboardService } from './../../services/RESTful/dashboard.service';
import { WebsocketService } from './../../services/messaging/websocket.service';
import { Component, OnInit } from '@angular/core';
import * as SockJs from 'sockjs-client';
import * as Stomp from 'stompjs';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent implements OnInit {

  constructor(private webSocketService: WebsocketService, private dashboardService: DashboardService) { }

  private stompClient;
  response: string;

  customers: Customer[] = [];

  // something: Observable<string>;
  ngOnInit() {
    // try to open websocket just as the documentation showed
    // for some reason it didn't work the way it did in dashboard, maybe because the consume occured becuase of an event.
    const ws = new SockJs('http://localhost:8080/gs-guide-websocket');
    this.stompClient = Stomp.over(ws);
    const _this = this;
    this.response = 'Standby...';
    this.stompClient.connect({}, function (frame) {

      console.log(frame);
      _this.stompClient.subscribe('/topic/queuedMessage', function(message) {
        console.log(message.body);
        if ( message.body === 'customer created') {
          _this.response = message.body;
          console.log('Retrieving');
          _this.dashboardService.getAllCustomers().subscribe((c: Customer[]) => _this.customers = c);
        }
      });

    });

  }




}
