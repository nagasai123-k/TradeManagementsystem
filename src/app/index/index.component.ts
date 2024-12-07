import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['../app.component.css']
})
export class IndexComponent implements OnInit {

  constructor(private router: Router, ) {}  
    onSubmit() {  
        this.router.navigate(['/login'])  
    } 


  ngOnInit(): void {
  }

}
