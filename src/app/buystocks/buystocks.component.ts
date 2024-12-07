import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
// import { DataService } from '../services/data.service';

@Component({
  selector: 'app-buystocks',
  templateUrl: './buystocks.component.html',
  styleUrls: ['../app.component.css']
})
export class BuystocksComponent implements OnInit {
  clientid:any;
  url:any;
  url1:any;
  // message:any;
  instrumentProfile:any;
  client:any;
  instrumentDetails: any;
  quantity:any;
  price:any;
 
  
 
  

  constructor(private router: Router,private http:HttpClient ) {
    this.clientid=localStorage.getItem('clientid');
    this.url="http://localhost:8081/client/"+this.clientid;
    let response= this.http.get(this.url);
    response.subscribe((data)=>this.client=data);
    this.instrumentProfile={
      instrumentid:'',
      instrumentname:'',
      facevalue:'',
      expirydate:'',
      quantity:''
     };

     

    
    
  }  
 
    onSubmit() {  
      this.url1="http://localhost:8081/buystocks";
        let payload={
          
            "client":{"clientid":localStorage.getItem('clientid')},
            "instrument": {"instrumentid":this.instrumentid},
            "quantity":this.quantity,
            "price":this.price
            }
            this.http.post(this.url1, payload).subscribe( result => {
              
              console.log(result);
             
            }, err => {
              if(err.status==200){

              // this.apiResult.success=true;
              // this.apiResult.error =false;
              // localStorage.setItem("receiver",this.transferProfile.receiveraccountholdername);
              // localStorage.setItem("amount",this.transferProfile.inramount);
              this.router.navigate(['/success'])
            }
              else{
              // this.apiResult.success=false;
              // this.apiResult.error =true;
              }
            }
            )
            
          
        }
        
       

    
 

    

  ngOnInit(): void {
   
}
onBgo(){
  this.router.navigate(['/clientprofile'])
}
myurl:any;
instrumentid:any;
getInstrumentName(){
  this.myurl="http://localhost:8081/instrument/"+this.instrumentid;
     let response= this.http .get(this.myurl);
     response.subscribe((data)=>this.instrumentDetails=data);
    //  console.log(this.inst);
}
}
