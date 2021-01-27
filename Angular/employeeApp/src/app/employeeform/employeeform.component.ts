import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Details} from '../detail'
import { SvcService } from '../svc.service';

@Component({
  selector: 'app-employeeform',
  templateUrl: './employeeform.component.html',
  styleUrls: ['./employeeform.component.scss']
})
export class EmployeeformComponent implements OnInit {

  constructor(
    public router: Router,
    public svc: SvcService
  ) { }

  ngOnInit(): void {
  }

  model = new Details(18, '', 0, '',false);

  id = 0;


  submitted = false;

  onSubmit() {
    var name= ((document.getElementById("name") as HTMLInputElement).value);
    var age = parseInt((document.getElementById("Age") as HTMLInputElement).value);
    var dob = ((document.getElementById("dob") as HTMLInputElement).value);
    this.id = Math.floor((Math.random() * 1000) + 1);
    this.model = new Details(this.id,name,age,dob,false);
    this.svc.addToService(this.model);
    alert("Employee details added successfully");

  }

  viewListOfEmployees(){
    this.router.navigate(['/route']);
    this.submitted = true;
  }

  newDetail() {
    this.model = new Details(0, '',0,'',false);

  }

}
