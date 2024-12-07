import { HttpClient } from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { Router  } from '@angular/router';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['../app.component.css']
})
export class DashboardComponent implements OnInit {
  clientProfile:any;
  clientInstrumentProfile:any;
  sendingclientid:any;
  url:any;
  custodian:any;
  client:any;
  url1:any;
  custodianid:any;
  custodianname:any;
  constructor(private router: Router ,private http:HttpClient ) {
    this.sendingclientid='';
    this.clientProfile={
      "clientid":''
    };

    this.url="http://localhost:8081/custodian/"+localStorage.getItem('custodianid');
    this.custodianname=localStorage.getItem('clientname');
  }

    onProfile(clientid:any) {
      this.url1="http://localhost:8081/client/"+clientid;
      console.log(clientid);





     localStorage.setItem("clientid",clientid);

     this.router.navigate(['/clientprofile']);
   }


//   onRecent() {
//     this.router.navigate(['/transactions'])
// }

  ngOnInit(){
    let response= this.http.get(this.url);
     response.subscribe((data)=>this.custodian=data);

     //console.log(this.custodian);

  }
  onTh(){
    this.router.navigate(['/custtradehistory'])
  }
  onPort(){
    this.router.navigate(['/portfolio'])
  }

}
