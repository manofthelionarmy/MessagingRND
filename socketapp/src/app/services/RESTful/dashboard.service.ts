import { Customer } from './../../models/customer';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';



const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  constructor(private http: HttpClient) { }

  addCustomer(customer: Customer): Observable<Customer> {
    const url = 'http://localhost:8080/addCustomer';
    return this.http.post<Customer>(url, customer, httpOptions);
  }

  getAllCustomers(): Observable<Customer[]> {
    const url = 'http://localhost:8080/getAllCustomers';
    return this.http.get<Customer[]>(url, httpOptions);
  }
}
