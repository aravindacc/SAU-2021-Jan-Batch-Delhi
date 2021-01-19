import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import {DataService} from '../data.service';
import {Router} from "@angular/router";
@Component({
  selector: 'app-insertdata',
  templateUrl: './insertdata.component.html',
  styleUrls: ['./insertdata.component.scss']
})
export class InsertdataComponent implements OnInit {

  formvalue= new FormGroup({
    firstname: new FormControl(),
    lastname: new FormControl(),
    dob: new FormControl(),
    phone: new FormControl(),
    age: new FormControl(),
    email: new FormControl()
  })
  showform= true;
  show = false;
  constructor(public services : DataService,public route: Router) {}

  ngOnInit(): void {

  }
  submit(): void {
    console.log(this.formvalue.value);
    this.services.insertvalues(this.formvalue.value);
  }
  nav(): void {
    this.route.navigate(['/show']);
    this.show = true;
    this.showform = false;
  }
  Back(): void{
    this.route.navigate(['']);
    this.show=false;
    this.showform=true;
  }

}
