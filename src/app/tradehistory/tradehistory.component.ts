
    
import {​​​​​​​ HttpClient }​​​​​​​ from '@angular/common/http';
import {​​​​​​​ Component, OnInit }​​​​​​​ from '@angular/core';


@Component({​​​​​​​
  selector: 'app-tradehistory',
  templateUrl: './tradehistory.component.html',
  styleUrls: ['./tradehistory.component.css','../app.component.css']
}​​​​​​​)
export class TradehistoryComponent implements OnInit {​​​​​​​
  clientid:any;
  url:any;
  transactions:any;


  constructor(private http:HttpClient) {​​​​​​​ }​​​​​​​


  ngOnInit(): void {​​​​​​​
    this.clientid=localStorage.getItem('clientid');
    this.url="http://localhost:8081/transaction/client/"+this.clientid;
    let response= this.http.get(this.url);
    response.subscribe((data)=>this.transactions=data);
  }​​​​​​​


}​​​​​​​
 






