import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.scss']
})
export class AdminComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  uReport=false;
  weekReport=false;
  fakeReport=false;

  
  weekReport1=()=>{
    this.uReport=false;
    this.weekReport=true;
    this.fakeReport=false;
  }
  fakeReport1=()=>{

    this.uReport=false;
    this.weekReport=false;
    this.fakeReport=true;
  }
  userReport1=()=>{
    this.uReport=true;
    this.weekReport=false;
    this.fakeReport=false;
  }

}
