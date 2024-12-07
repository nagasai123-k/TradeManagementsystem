import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['../app.component.css']
})
export class LoginComponent implements OnInit {
  loginForm:FormGroup;
  custodianProfile:any;
  custodian:any;
  constructor(private http:HttpClient, private router:Router) {
    this.custodianProfile={
      "custodianid":'',
      "password":'',
    };
    this.loginForm =new FormGroup({
      custodianid: new FormControl('', [

        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(10),
        Validators.pattern(/^[a-z0-9]+$/i)
      ]),
      password: new FormControl('', [

        Validators.required,
        Validators.minLength(4),
        Validators.maxLength(10),
       // Validators.pattern(/^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,10}$/)
      ]),

    });

  }
  ngOnInit(): void {
  }
  apiResult={
    success:false,
    error:false
  }
  handleLogin() {
    let url = 'http://localhost:8081/custodian/'+this.custodianProfile.custodianid;
    let payLoad= {
      "custodianid":this.custodianProfile.custodianid,
      "password":this.custodianProfile.password
    }
    this.http.post(url,payLoad).subscribe((result)=>{
      this.custodian=result;
      this.apiResult.success=true;
      this.apiResult.error =false;
      console.log(this.custodian);
      localStorage.setItem("custodianname",this.custodian.clientname);
      localStorage.setItem("custodianid",this.custodianProfile.custodianid);
      this.router.navigate(['/dashboard'])

    },err => {
       this.apiResult.success=false;
       this.apiResult.error =true;
   })
   }
  get custodianid() {
    return this.loginForm.controls['custodianid'];
  }
  get password() {
    return this.loginForm.controls['password'];
  }


}
