import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

 

@Component({
  selector: 'app-success',
  templateUrl: './success.component.html',
  styleUrls: ['./success.component.css','../app.component.css']
})
export class SuccessComponent implements OnInit {

 

  receiver:any;
  amount:any;
  customer:any;
  constructor(private http:HttpClient) { 
   
    
  }

 

  ngOnInit(): void {
  }

 

}