import { Customer } from './../../models/customer';
import { DashboardService } from './../../services/RESTful/dashboard.service';
import { WebsocketService } from './../../services/messaging/websocket.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private websocketService: WebsocketService, private dasboardService: DashboardService) { }

  customer: Customer = {name: '', id: 0};

  customers: Customer[];

  ngOnInit() {
    // this.websocketService.connect();
  }

  addCustomer(): void {
    this.dasboardService.addCustomer(this.customer).subscribe();
    // this.websocketService.consume();
  }

  getCustomers(): void {
    this.dasboardService.getAllCustomers().subscribe((c: Customer[]) => this.customers = c);
  }


}
