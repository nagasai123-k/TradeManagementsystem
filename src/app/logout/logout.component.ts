import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private router:Router) { 
    var txt;
    if (confirm("Are you sure want to logout!")) {
      localStorage.clear();
    this.router.navigate(['/index']) ;
    } else {
      this.router.navigate(['dashboard']) ;
    }
  }

  ngOnInit(): void {
  }

}
