import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-custtradehistory',
  templateUrl: './custtradehistory.component.html',
  styleUrls: ['./custtradehistory.component.css','../app.component.css']
})
export class CusttradehistoryComponent implements OnInit {
  custodianid:any;
  url:any;
  transactions:any;

  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.custodianid=localStorage.getItem('custodianid');
    this.url="http://localhost:8081/transaction/"+this.custodianid;
    let response= this.http.get(this.url);
    response.subscribe((data)=>this.transactions=data);
  }

}
