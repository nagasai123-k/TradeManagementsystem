import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-traderequest',
  templateUrl: './traderequest.component.html',
  styleUrls: ['../app.component.css','./traderequest.component.css']
})
export class TraderequestComponent implements OnInit {
  clientid:any;
  url:any;
  buystocks:any;
  url1:any;
  sellstocks:any;
  currentDate:any;
  constructor(private router:Router,private http:HttpClient) { 
    this.currentDate=Date.now();
  }

  ngOnInit(){
    this.clientid=localStorage.getItem('clientid');
    this.url="http://localhost:8081/buystocks/"+this.clientid;
    let response= this.http.get(this.url);
    response.subscribe((data)=>this.buystocks=data);
    this.url1= "http://localhost:8081/sellstocks/"+this.clientid;
    let response1= this.http.get(this.url1);
    response1.subscribe((data)=>this.sellstocks=data);

  }
 

}
