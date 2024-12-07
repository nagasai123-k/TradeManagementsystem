import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormControl, FormGroup} from '@angular/forms';
import { MinimumPrice } from '../common/priceval';

@Component({
  selector: 'app-sellstocks',
  templateUrl: './sellstocks.component.html',
  styleUrls: ['../app.component.css']
})
export class SellstocksComponent implements OnInit {
  sellstocksform : FormGroup;
  clientid:any;
  url1:any;
  url:any;
  client:any;
  price:any;
  quantity:any;

  instrumentProfile:any;

  constructor(private router: Router ,private http:HttpClient) {

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
     }
     this.sellstocksform = new FormGroup({
      price:new FormControl('',[MinimumPrice])
    })

  }

  ngOnInit(): void {
  }
  onSubmit(){
    this.url1="http://localhost:8081/sellstocks";
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

          this.router.navigate(['/success'])
        }
          else{
          // this.apiResult.success=false;
          // this.apiResult.error =true;
          }
        }
        )

  }
  myurl:any;
instrumentid:any;
instrumentDetails:any;
getInstrumentName(){
  this.myurl="http://localhost:8081/instrument/"+this.instrumentid;
     let response= this.http .get(this.myurl);
     response.subscribe((data)=>this.instrumentDetails=data);
    //  console.log(this.inst);
}
get price1() {
  return this.sellstocksform.controls['price'];
}
get facevalue(){
  return this.sellstocksform.controls['facevalue'];
}
onBgo(){
  this.router.navigate(['/clientprofile']);
}
apiResult={
  success:false,
  error:false
}
key:any;
onChange(){
  let facevalue=this.instrumentDetails.facevalue;
  let price=this.price;
  this.key=false;
  if(facevalue>price+(0.12*price)||facevalue<price-(0.12*price)){
    this.apiResult.error=true;
    this.apiResult.success=false;
  }
  else{
    this.apiResult.success=true;
    this.apiResult.error=false;
  }
}

}
