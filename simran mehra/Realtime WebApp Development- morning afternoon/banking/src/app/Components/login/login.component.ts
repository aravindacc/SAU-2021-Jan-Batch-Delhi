import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { Router } from '@angular/router';
import { BASE_URL } from 'src/app/constants/baseurl';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  login=false;
  register=false;
  email='';
  password='';
  name='';
  loggedIn=true;
  transaction=false;
  admin=false;
  amount=0;
  cnum='';

  constructor(
    private http: HttpClient,
    private route: Router
  ) { }

  ngOnInit(): void {
  }

  showLogin=()=>{
    this.login=true;
    this.register=false;
    this.email='';
    this.password='';
    this.name='';

  }

  showReg=()=>{
    this.login=false;
    this.register=true;
    this.email='';
    this.password='';
    this.name='';
  }

  regfunc=()=>{
    this.http.post(BASE_URL + '/register',
    {name:this.name,email:this.email,password:this.password},
    { responseType: 'text'})
    .subscribe(data=>{
      if(data==="true"){
        alert("Login now")
      }
      else{
        alert("Try again")
      }
    });
  }

  loginfunc=()=>{

    if(this.email==="Simran" && this.password==="qwerty"){
        alert("Admin logging in");
        this.admin=true;
        this.loggedIn=false;
        this.route.navigate(['/admin']);

    }
    else{
    this.http.post(BASE_URL + '/login',
    {email:this.email,password:this.password},
    { responseType: 'text'})
    .subscribe(data=>{
      if(data==="Matched"){
        this.transaction=true;
        this.loggedIn=false;
      }
      else{
      }
    });
  }

  }

  submit=()=>{
    if((this.amount%500==0) || (this.amount%1000==0)){
    const d=new Date;
    const date= d.getFullYear()+"/"+(d.getMonth()+1)+"/"+d.getDate();
    this.http.post(BASE_URL + '/emp',{
    email:this.email,amount:this.amount,currency_id:this.cnum,timestamp: date},
    {responseType:"text"})
    .subscribe(data=>{
      alert("Amount submitted");
    })
  }
  else{
    alert("Enter amount in multiple of 500 or 1000")
  }
  }

}
