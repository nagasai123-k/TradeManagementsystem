import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { DashboardComponent } from '../dashboard/dashboard.component';

@Component({
  selector: 'app-clientprofile',
  templateUrl: './clientprofile.component.html',
  styleUrls: ['../app.component.css','./clientprofile.component.css']
})
export class ClientprofileComponent implements OnInit {
  url:any;
  url1:any;
  custodian:any;
  custodianid:any;
  custodianname:any;
  sendingclientid:any;
  clientname:any;
  client:any;
  clientinstrument:any;
  constructor(private router: Router ,private http:HttpClient,) { 
    this.clientname=''


    
    
   
    //  this.url="http://localhost:8081/client/"+this.sendingclientid;
   
  }

  ngOnInit(){
    let clientid2=localStorage.getItem('clientid');
   
    
    this.url="http://localhost:8081/client/"+clientid2;
    this.url1="http://localhost:8081/clientinstrument/"+clientid2;
    let response= this.http.get(this.url);
     response.subscribe((data)=>this.client=data);
     let response1= this.http.get(this.url1);
     response1.subscribe((data)=>this.clientinstrument=data);
     
     
   
    // response.subscribe((data)=>this.clientinstrument=data);
  }
  // onClient(){
  //   this.router.navigate(['/dashboard'])
  // }
  onBuy(){
    this.router.navigate(['/buystocks'])
  }
  onSell(){
    this.router.navigate(['/sellstocks'])
  }
  onTh(){
    this.router.navigate(['/tradehistory'])
  }
  onTr(){
    this.router.navigate(['/traderequest']);
  }

}
